package org.jypj.dev.intercept;

import org.jypj.dev.constant.BaseConstant;
import org.jypj.dev.model.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor extends HandlerInterceptorAdapter {

    private static final String BACK_LOGIN_URL = "/back/login";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        User user = (User) request.getSession().getAttribute(BaseConstant.BACK_SESSION_USER);
        if (user == null) {
            response.sendRedirect(BACK_LOGIN_URL);
        }
        return true;
    }
}
