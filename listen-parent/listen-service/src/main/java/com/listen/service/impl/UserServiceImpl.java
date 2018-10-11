package com.listen.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.listen.common.jedis.JedisClient;
import com.listen.common.utils.JsonUtils;
import com.listen.common.utils.ListenResult;
import com.listen.mapper.LibraryPoolMapper;
import com.listen.mapper.SysUserLibraryPoolMapper;
import com.listen.mapper.UserMapper;
import com.listen.pojo.SysUserLibraryPool;
import com.listen.pojo.User;
import com.listen.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import tk.mybatis.mapper.entity.Example;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Exler
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SysUserLibraryPoolMapper sysUserLibraryPoolMapper;
    @Autowired
    private LibraryPoolMapper libraryPoolMapper;
    @Autowired
    private JedisClient jedisClient;
    @Value("${JEDIS_KEY}")
    private String JEDIS_KEY;
    @Value("${SESSION_EXPIRE}")
    private Integer SESSION_EXPIRE;

    @Override
    public ListenResult login(User user) {
        // 根据账号查找账户
        User selectUser = selectUserByAccount(user.getAccount());
        if (selectUser == null) {
            return ListenResult.error("账号/密码错误");
        }
        // 账户存在验证密码
        if (!DigestUtils.md5DigestAsHex((user.getPassword() + selectUser.getSalt()).getBytes()).equals(selectUser.getPassword())) {
            // (用户输入的密码+盐)与数据库密码 不相等
            return ListenResult.error("账号/密码错误");
        }
        // 生成token
        String token = UUID.randomUUID().toString();
        // 把用户信息写入redis key:token value:用户信息
        selectUser.setPassword(null);
        selectUser.setSalt(null);
        jedisClient.set(JEDIS_KEY + token, JsonUtils.objectToJson(selectUser));
        // 设置Session的过期时间
        jedisClient.expire(JEDIS_KEY + token, SESSION_EXPIRE);
        Map<String, Object> data = new HashMap<>(2);
        data.put("token", token);
        data.put("redirect", selectUser.getClassify() == 0 ? "user" : "admin");
        return ListenResult.success(data);
    }

    @Override
    public ListenResult register(User user) {
        User existUser = selectUserByAccount(user.getAccount());
        if (existUser != null) {
            return new ListenResult("账号已存在", 9, null);
        }
        // 盐
        String uuidSalt = UUID.randomUUID().toString().replace("-", "");
        user.setSalt(uuidSalt);
        // 密码加盐
        String password = DigestUtils.md5DigestAsHex((user.getPassword() + uuidSalt).getBytes());
        user.setPassword(password);
        // 数据初始化
        user.setGrade(0);
        user.setClassify(0);
        user.setCurrentCheck(null);
        // 插入
        User insertUser = new User();
        BeanUtils.copyProperties(user, insertUser);
        userMapper.insert(insertUser);
        return ListenResult.success(insertUser.getAccount());
    }

    @Override
    public void logout(String token) {
        Long l = jedisClient.del(JEDIS_KEY + token);
        if (l > 0) {
            System.out.println("success");
        } else {
            System.out.println("no");
        }
    }

    @Override
    public User selectUserByAccount(String account) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("account", account);
        User existUser = userMapper.selectOneByExample(example);
        return existUser;
    }

    @Override
    public ListenResult getUserByToken(String token) {
        // 根据token到redis中取用户信息
        String json = jedisClient.get(JEDIS_KEY + token);
        // 取不到用户信息 登录已经过期 返回登录过期
        if (StringUtils.isBlank(json)) {
            return new ListenResult("用户登录已经过期", 201, null);
        }
        // 取到用户信息 更新token的过期时间
        User user = JsonUtils.jsonToPojo(json, User.class);
        // 更新token的过期时间
        jedisClient.expire(JEDIS_KEY + token, SESSION_EXPIRE);
        return ListenResult.success(user);
    }

    /**
     * 初始化学生等级
     *
     * @param user
     * @param score
     */
    @Override
    public ListenResult initGradeCode(User user, Float score) {
        user.setCurrentCheck(0);
        // <= 70 1 <= 90 2 >90 3
        user.setGrade(score <= 70 ? 1 : score <= 90 ? 2 : 3);
        int i = userMapper.updateByPrimaryKey(user);
        if (i > 0) {
            return ListenResult.success(null);
        }
        return ListenResult.error("更新失败");
    }

    @Override
    public ListenResult saveScore(User user, SysUserLibraryPool sysUserLibraryPool, Integer checkPoint) {
        Integer lpId = libraryPoolMapper.selectLpByGradeAndCheck(user.getGrade(), checkPoint).getId();
        sysUserLibraryPool.setLpId(lpId);
        sysUserLibraryPool.setUserId(user.getId());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sysUserLibraryPool.setTime(simpleDateFormat.format(new Date()));
        Example example = new Example(SysUserLibraryPool.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId", user.getId());
        criteria.andEqualTo("lpId", lpId);
        sysUserLibraryPool.setCount(sysUserLibraryPoolMapper.selectCountByExample(example) + 1);
//        int insert = sysUserLibraryPoolMapper.insert(sysUserLibraryPool);
//        return insert == 0 ? ListenResult.error("提交试卷保存失败") : ListenResult.success(null);
        sysUserLibraryPoolMapper.insert(sysUserLibraryPool);
        return ListenResult.success(null);
    }

    @Override
    public ListenResult getHistoryPage(User user, Integer checkPoint, Integer pageNum, Integer pageSize) {
        Example example = new Example(SysUserLibraryPool.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId", user.getId());
        if (null != checkPoint && user.getGrade() > 1) {
            Integer lpId = libraryPoolMapper.selectLpByGradeAndCheck(user.getGrade(), checkPoint).getId();
            criteria.andEqualTo("lpId", lpId);
        }
        example.orderBy("time").desc();
        PageHelper.startPage(pageNum == null ? 1 : pageNum, pageSize == null ? 8 : pageSize);
        List<SysUserLibraryPool> sysUserLibraryPools = sysUserLibraryPoolMapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo(sysUserLibraryPools);
        return ListenResult.success(pageInfo);
    }

}
