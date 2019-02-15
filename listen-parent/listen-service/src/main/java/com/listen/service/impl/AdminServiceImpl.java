package com.listen.service.impl;

import com.github.pagehelper.PageHelper;
import com.listen.mapper.UserMapper;
import com.listen.pojo.vo.QuerySULP;
import com.listen.pojo.vo.QuerySysStudentLibraryPoolVo;
import com.listen.service.AdminService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  * **************************************************************
 *  * 公司名称    :杭州大猷网络科技有限公司
 *  * 系统名称    :大猷金融平台-spring cloud2 最新架构版 v1.10
 *  * 类 名 称    :
 *  * 功能描述    :
 *  * 业务描述    :
 *  * 作 者 名    :@Author Exleryz(叶舟)
 *  * 开发日期    :2019/2/14 9:19
 *  * Created     :IntelliJ IDEA
 *  * **************************************************************
 *  * 修改日期    :
 *  * 修 改 者    :
 *  * 修改内容    :
 *  * **************************************************************
 *  
 */

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    UserMapper userMapper;

    /**
     * 管理员界面 成绩查询
     *
     * @param vo
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<QuerySULP> queryHistory(QuerySysStudentLibraryPoolVo vo, Integer pageNum, Integer pageSize) {
        Map<String, Object> query = new HashMap<>(3);

        query.put("account", vo.getAccount());
        query.put("userName", vo.getUserName());
        query.put("grade", vo.getGrade());
        query.put("currentCheck", vo.getCurrentCheck());
        if (!StringUtils.isEmpty(vo.getScore())) {
            String[] score = vo.getScore().split(";");
            query.put("startScore", StringUtils.isEmpty(score[0]) ? null : score[0]);
            query.put("endScore", StringUtils.isEmpty(score[1]) ? null : score[1]);
        }
        if (!StringUtils.isEmpty(vo.getTime())) {
            String[] time = vo.getTime().split(";");
            query.put("startTime", StringUtils.isEmpty(time[0]) ? null : time[0]);
            query.put("endTime", StringUtils.isEmpty(time[1]) ? null : time[1]);
        }
        PageHelper.startPage(pageNum, pageSize);
        return userMapper.queryHistory(query);

    }
}
