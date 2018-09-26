package com.listen.service;

import com.listen.common.utils.ListenResult;
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
}
