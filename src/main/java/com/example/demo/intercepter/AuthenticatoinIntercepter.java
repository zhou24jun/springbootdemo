package com.example.demo.intercepter;

import com.example.demo.common.TokenRequired;
import com.example.demo.common.UnauthorizedException;
import com.example.demo.database.UserService;
import com.example.demo.util.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @className: AuthenticatoinIntercepter
 * @description: TODO 类描述
 * @author: junZhou
 * @date: 2020/7/10
 **/
@Slf4j
public class AuthenticatoinIntercepter implements HandlerInterceptor {

    @Autowired
    private UserService userService;
    @Autowired
    private JWTUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) return true;
        HandlerMethod hm = (HandlerMethod) handler;
        Method method = hm.getMethod();
        if (method.isAnnotationPresent(TokenRequired.class)) {
            TokenRequired tokenRequired = method.getAnnotation(TokenRequired.class);
            if (tokenRequired.required()) {
                String authHeader = request.getHeader("token");
                if (authHeader == null) throw new UnauthorizedException();
                String usernameReq = request.getParameter("username");
                String username = jwtUtil.getUsername(authHeader);
                log.info(usernameReq+" try to log in ");

                if (StringUtils.isEmpty(username)) throw new UnauthorizedException();
                if (!usernameReq.equals(username)) throw new UnauthorizedException();
                if (userService.getUser(username) == null) throw new UnauthorizedException();
                log.info(username+" log in now");
            }
            return true;
        }
        return true;
    }
}

