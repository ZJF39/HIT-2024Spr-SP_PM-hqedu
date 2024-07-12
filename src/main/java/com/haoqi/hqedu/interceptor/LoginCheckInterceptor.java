package com.haoqi.hqedu.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.haoqi.hqedu.pojo.Result;
import com.haoqi.hqedu.util.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoginCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {

        // 获取URL
        String url = req.getRequestURL().toString();

        // 如果是login请求，直接放行
        if(url.contains("login")){
            return true;
        }

        // 从请求头中获取token
        String jwt = req.getHeader("token");

        // 如果没有token(jwt无长度)，返回错误信息
        if(!StringUtils.hasLength(jwt)){
            Result error = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(error);
            res.getWriter().write(notLogin);
            return false;
        }

        // 如果有token，则进行解析,解释失败则返回错误信息
        try{
            JwtUtils.parseJwt(jwt);
        } catch (Exception e) {
            e.printStackTrace();
            Result error = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(error);
            res.getWriter().write(notLogin);
            return false;
        }

        // 放行
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
    }
}
