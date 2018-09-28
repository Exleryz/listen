package com.listen.service;

import com.listen.common.utils.ListenResult;
import com.listen.pojo.SysUserLibraryPool;
import com.listen.pojo.User;

/**
 * @author Exler
 */
public interface UserService {

    /**
     * 登录
     *
     * @param User
     * @return
     */
    ListenResult login(User User);

    /**
     * 注册
     *
     * @param User
     * @return
     */
    ListenResult register(User User);

    /**
     * 登出
     *
     * @param token
     */
    void logout(String token);

    /**
     * 根据账号查找用户
     *
     * @param account
     * @return
     */
    User selectUserByAccount(String account);

    /**
     * 根据token 获取用户信息
     *
     * @param token
     * @return
     */
    ListenResult getUserByToken(String token);

    /**
     * 初始化学生等级
     *
     * @param user
     * @param score
     * @return
     */
    ListenResult initGradeCode(User user, Float score);

    /**
     * 保存试卷分数
     *
     * @param user
     * @param sysUserLibraryPool
     * @param checkPoint
     * @return
     */
    ListenResult saveScore(User user, SysUserLibraryPool sysUserLibraryPool, Integer checkPoint);

    /**
     * 获取历史做题记录
     *
     * @param user
     * @param checkPoint
     * @param pageNum
     * @param pageSize
     * @return
     */
    ListenResult getHistoryPage(User user, Integer checkPoint, Integer pageNum, Integer pageSize);
}
