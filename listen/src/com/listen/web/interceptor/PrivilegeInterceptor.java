package com.listen.web.interceptor;

import com.listen.domain.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import java.util.Map;

/**
 * FileName PrivilegeInterceptor
 * Created by Exler
 * Time 2018-08-30 14:29
 * Description:
 */

public class PrivilegeInterceptor extends MethodFilterInterceptor {

    @Override    // 不校验登录和注册方法
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        // 1. 获得Session
        Map<String, Object> session = ActionContext.getContext().getSession();
        // 2. 获得登录标识
        Student student = (Student) session.get("student");
        // 3. 判断标识是否存在
        if (student != null) {
            // 存在=>放行
            return actionInvocation.invoke();
        } else {
            // 不存在 => 重定向到登录页面
            Student admin = (Student) session.get("admin");
            if (admin != null) {
                return actionInvocation.invoke();
            } else {
                return "toLogin";
            }
        }
    }
}
