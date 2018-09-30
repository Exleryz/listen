package com.listen.service;

import com.listen.pojo.Integral;
import com.listen.pojo.User;

/**
 * @author Exler
 */
public interface IntegralService {

    /**
     * 获取积分 + -
     * num getWay 由调用方提前填写
     *
     * @param user
     * @param integral
     */
    void operateIntegral(User user, Integral integral);

    /**
     * 用户查看所有的 积分记录
     */

}
