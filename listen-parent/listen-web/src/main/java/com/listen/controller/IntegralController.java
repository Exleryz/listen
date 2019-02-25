package com.listen.controller;

import com.listen.common.utils.ListenResult;
import com.listen.pojo.Integral;
import com.listen.service.IntegralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *  * **************************************************************
 *  * 公司名称    :杭州大猷网络科技有限公司
 *  * 系统名称    :大猷金融平台-spring cloud2 最新架构版 v1.10
 *  * 类 名 称    :
 *  * 功能描述    :
 *  * 业务描述    :
 *  * 作 者 名    :@Author Exleryz(叶舟)
 *  * 开发日期    :2019/2/11 13:51
 *  * Created     :IntelliJ IDEA
 *  * **************************************************************
 *  * 修改日期    :
 *  * 修 改 者    :
 *  * 修改内容    :
 *  * **************************************************************
 *  
 */

@RestController
@RequestMapping("/integral")
public class IntegralController {

    @Autowired
    IntegralService integralService;

    /**
     * 积分操作
     *
     * @param integral
     * @return
     */
    @RequestMapping("/operate")
    public ListenResult operate(Integral integral) {
        return integralService.operateIntegral(integral) ? ListenResult.success(null)
                : ListenResult.error("参数错误");
    }

    @RequestMapping("/getSumIntegral")
    public ListenResult getSumIntegral(Integer userId) {
        if (null == userId) {
            return ListenResult.error("用户不存在");
        }
        Integer sum = integralService.getUserSumIntegral(userId);
        return ListenResult.success(sum);
    }

    @RequestMapping("/queryAll")
    public ListenResult queryAll(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize) {
        return integralService.queryAll(pageNum, pageSize);
    }

    @RequestMapping("/getHistory")
    public ListenResult getIntegralHistory(Integer userId, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize) {
        return integralService.getIntegralHistory(userId, pageNum, pageSize);
    }

}
