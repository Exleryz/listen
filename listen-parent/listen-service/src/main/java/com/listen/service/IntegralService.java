package com.listen.service;

import com.listen.common.utils.ListenResult;
import com.listen.pojo.Integral;

import java.util.List;

/**
 * @author Exler
 */
public interface IntegralService {

    /**
     * 修改积分 + -
     * num getWay 由调用方提前填写(自动调用及手动扣除)
     *
     * @param integral
     */
    Boolean operateIntegral(Integral integral);

    /**
     * 获取用户总积分
     *
     * @param userId 用户id
     */
    Integer getUserSumIntegral(Integer userId);

    /**
     * 用户查看所有的 积分记录 分页
     */
    ListenResult getIntegralHistory(Integer userId, Integer pageNum, Integer pageSize);

    /**
     * 上传对应积分的兑换物品
     */

    /**
     * 下架对应积分的兑换物品
     */

}
