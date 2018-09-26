package com.listen.service.impl;

import com.listen.common.jedis.JedisClient;
import com.listen.common.utils.JsonUtils;
import com.listen.common.utils.ListenResult;
import com.listen.mapper.UserMapper;
import com.listen.pojo.User;
import com.listen.pojo.vo.UserVo;
import com.listen.service.UserService;
import com.sun.xml.internal.xsom.impl.scd.Iterators;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

/**
 * @author Exler
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JedisClient jedisClient;
    @Value("${JEDIS_KEY}")
    private String JEDIS_KEY;
    @Value("${SESSION_EXPIRE}")
    private Integer SESSION_EXPIRE;

    @Override
    public ListenResult login(UserVo userVo) {
        // 根据账号查找账户
        User selectUser = selectUserByAccount(userVo.getAccount());
        if (selectUser == null) {
            return ListenResult.error("账号/密码错误");
        }
        // 账户存在验证密码
        if (!DigestUtils.md5DigestAsHex((userVo.getPassword() + selectUser.getSalt()).getBytes()).equals(selectUser.getPassword())) {
            // (用户输入的密码+盐)与数据库密码 不相等
            return ListenResult.error("账号/密码错误");
        }
        // 生成token
        String token = UUID.randomUUID().toString();
        // 把用户信息写入redis key:token value:用户信息
        userVo.setPassword(null);
        jedisClient.set(JEDIS_KEY + token, JsonUtils.objectToJson(userVo));
        // 设置Session的过期时间
        jedisClient.expire(JEDIS_KEY + token, SESSION_EXPIRE);
        Map<String, String> data = new HashMap<>(2);
        data.put("token", token);
        data.put("redirect", selectUser.getClassify() == 0 ? "user" : "admin");
        return ListenResult.success(data);
    }

    @Override
    public ListenResult register(UserVo userVo) {
        User existUser = selectUserByAccount(userVo.getAccount());
        if (existUser != null) {
            return new ListenResult("账号已存在", 9, null);
        }
        // 盐
        String uuidSalt = UUID.randomUUID().toString().replace("-", "");
        userVo.setSalt(uuidSalt);
        // 密码加盐
        String password = DigestUtils.md5DigestAsHex((userVo.getPassword() + uuidSalt).getBytes());
        userVo.setPassword(password);
        // 数据初始化
        userVo.setGrade(0);
        userVo.setClassify(0);
        userVo.setCurrentCheck(null);
        // 插入
        User user = new User();
        BeanUtils.copyProperties(userVo, user);
        userMapper.insert(user);
        return ListenResult.success(user.getAccount());
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

}
