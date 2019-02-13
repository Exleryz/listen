package com.listen.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 *  * **************************************************************
 *  * 公司名称    :杭州大猷网络科技有限公司
 *  * 系统名称    :大猷金融平台-spring cloud2 最新架构版 v1.10
 *  * 类 名 称    :
 *  * 功能描述    :
 *  * 业务描述    :
 *  * 作 者 名    :@Author Exleryz(叶舟)
 *  * 开发日期    :2019/2/13 9:42
 *  * Created     :IntelliJ IDEA
 *  * **************************************************************
 *  * 修改日期    :
 *  * 修 改 者    :
 *  * 修改内容    :
 *  * **************************************************************
 *  
 */

@Controller
@RequestMapping("/page")
public class RedirectController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/{folderName}/{pageName}")
    public ModelAndView page(@PathVariable String folderName, @PathVariable String pageName, ModelAndView modelAndView, HttpServletRequest request) {
        String path;
        if (StringUtils.isEmpty(pageName) || "".equals(pageName)) {
            path = folderName;
        } else {
            path = folderName + "/" + pageName;
        }
        modelAndView.addObject("user", request.getAttribute("user"));
        modelAndView.setViewName(path);
        return modelAndView;
    }

}
