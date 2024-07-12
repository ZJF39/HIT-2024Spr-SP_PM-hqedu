package com.haoqi.hqedu.filter;

import jakarta.servlet.*;

import java.io.IOException;

// @WebFilter(urlPatterns = "/*")
public class DemoFilter implements Filter {
    @Override// 初始化方法，只会在创建时被调用一次
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化方法已执行");
        Filter.super.init(filterConfig);
    }

    @Override// 过滤方法，每次拦截到请求都会被调用
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("请求已拦截");
        filterChain.doFilter(servletRequest,servletResponse);// 放行请求
    }

    @Override// 销毁方法，只会在销毁时被调用一次
    public void destroy() {
        System.out.println("销毁方法已执行");
        Filter.super.destroy();
    }
}
