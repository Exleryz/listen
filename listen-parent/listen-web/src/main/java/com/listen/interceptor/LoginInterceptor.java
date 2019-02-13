package com.listen.interceptor;

import com.listen.common.utils.CookieUtils;
import com.listen.common.utils.ListenResult;
import com.listen.pojo.User;
import com.listen.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Exler
 * @create 2018/8/4
 * @time 12:24
 * @describe: 用户登录处理拦截器
 **/

public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;
    @Value("${TOKEN_KEY}")
    private String TOKEN_KEY;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1. 从cookie中取token
        String token = CookieUtils.getCookieValue(request, TOKEN_KEY);
        // 2. 如果没有token 未登录状态 跳转到登录页面 登录成功后 跳转到当前请求的url
        if (StringUtils.isBlank(token)) {
            response.sendRedirect(request.getContextPath() + "/page/login.html?redirect=" + request.getRequestURL());
            // 拦截
            return false;
        }
        // 3. 取到token 根据token取用户信息
        ListenResult result = userService.getUserByToken(token);
        if (!result.getFlag()) {
            // 4. 没有取到用户信息 登录过期 重新登录
            response.sendRedirect(request.getContextPath() + "/page/login.html?redirect=" + request.getRequestURL());
            return false;
        }
        // 5. 取到用户信息 登录状态
        User user = (User) result.getData();
        // 6. 把用户信息放到request中 只需要在controller中判断request中是否包含user信息 放行
        request.setAttribute("user", user);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // handler执行之后 返回modeandview之前
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 完成处理 返回modelandview之后
        // 处理异常
    }
}
