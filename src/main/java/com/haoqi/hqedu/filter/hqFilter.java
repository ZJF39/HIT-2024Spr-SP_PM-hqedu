package com.haoqi.hqedu.filter;

import com.alibaba.fastjson.JSONObject;
import com.haoqi.hqedu.pojo.Result;
import com.haoqi.hqedu.util.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StringUtils;

import java.io.IOException;

//@WebFilter(urlPatterns = "/*")
public class hqFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 获取请求和相应数据
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        // 获取URL
        String url = req.getRequestURL().toString();

        // 如果是login请求，直接放行
        if(url.contains("login")){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }

        // 从请求头中获取token
        String jwt = req.getHeader("token");

        // 如果没有token(jwt无长度)，返回错误信息
        if(!StringUtils.hasLength(jwt)){
            Result error = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(error);
            res.getWriter().write(notLogin);
            return;
        }

        // 如果有token，则进行解析,解释失败则返回错误信息
        try{
            JwtUtils.parseJwt(jwt);
        } catch (Exception e) {
            e.printStackTrace();
            Result error = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(error);
            res.getWriter().write(notLogin);
            return;
        }

        // 放行
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
