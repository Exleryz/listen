package com.listen.service;

import com.listen.common.utils.ListenResult;
import com.listen.pojo.User;
import com.listen.pojo.vo.UserVo;

/**
 * @author Exler
 */
public interface UserService {

    /**
     * 登录
     *
     * @param userVo
     * @return
     */
    ListenResult login(UserVo userVo);

    /**
     * 注册
     *
     * @param userVo
     * @return
     */
    ListenResult register(UserVo userVo);

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
