package com.listen.controller;

import com.listen.common.utils.CookieUtils;
import com.listen.common.utils.ListenResult;
import com.listen.pojo.User;
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
import java.util.Map;

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

    /**
     * 登录
     *
     * @param user
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ListenResult login(User user, HttpServletRequest request, HttpServletResponse response) {
        // 参数检查
        if (StringUtils.isEmpty(user.getAccount()) || StringUtils.isEmpty(user.getPassword())) {
            return ListenResult.error("账号/密码不可为空");
        }
        ListenResult result = userService.login(user);
        if (result.getCode() == 200) {
            // 用户登录成功
            Map<String, String> session = (Map<String, String>) result.getData();
            String token = session.get("token");
            // 如果登录成功把token写入cookie
            CookieUtils.setCookie(request, response, TOKEN_KEY, token);
        }
        return result;
    }

    /**
     * 注册
     *
     * @param user
     * @return
     */
    @RequestMapping("/register")
    @ResponseBody
    public ListenResult register(User user) {
        // 参数检查
        if (StringUtils.isEmpty(user.getAccount()) || StringUtils.isEmpty(user.getPassword()) || StringUtils.isEmpty(user.getUsername())) {
            return ListenResult.error("账号/密码不可为空");
        }
        ListenResult result = userService.register(user);
        return result;
    }

    /**
     * 登出
     *
     * @param request
     * @param response
     * @return
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
