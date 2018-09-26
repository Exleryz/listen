package com.listen.controller;

import com.listen.common.utils.CookieUtils;
import com.listen.common.utils.ListenResult;
import com.listen.pojo.vo.UserVo;
import com.listen.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Exler
 */
@Controller
@RequestMapping(value = "/sso")
public class SsoController {

    @Autowired
    private UserService userService;
    @Value("${TOKEN_KEY}")
    private String TOKEN_KEY;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ListenResult login(UserVo userVo, HttpServletRequest request, HttpServletResponse response) {
        // 参数检查
        if (StringUtils.isEmpty(userVo.getAccount()) || StringUtils.isEmpty(userVo.getPassword())) {
            return ListenResult.error("账号/密码不可为空");
        }
        ListenResult result = userService.login(userVo);
        if (result.getCode() == 200) {
            // 用户登录成功
            String token = result.getData().toString();
            // 如果登录成功把token写入cookie
            CookieUtils.setCookie(request, response, TOKEN_KEY, token);
        }
        return result;
    }

    /**
     * 注册
     *
     * @param userVo
     * @return
     */
    @RequestMapping("/register")
    @ResponseBody
    public ListenResult register(UserVo userVo) {
        // 参数检查
        if (StringUtils.isEmpty(userVo.getAccount()) || StringUtils.isEmpty(userVo.getPassword()) || StringUtils.isEmpty(userVo.getUsername())) {
            return ListenResult.error("账号/密码不可为空");
        }
        ListenResult result = userService.register(userVo);
        return result;
    }

    /**
     * 登出
     */
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        // 获取 token
        String token = CookieUtils.getCookieValue(request, TOKEN_KEY);
        // 登出
        userService.logout(token);
        // 删除cookie
        CookieUtils.deleteCookie(request, response, TOKEN_KEY);
        return "index";
    }
}
