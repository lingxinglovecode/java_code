package com.lianxing.filter;

import com.lianxing.utils.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author lianxing
 * @description
 * @create 2021-10-24 15:53
 */
public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        try {
            filterChain.doFilter(servletRequest, servletResponse);
            JdbcUtils.commitAndClose();
        } catch (Exception e) {
            JdbcUtils.rollbackAndClose();
            e.printStackTrace();
            throw new RuntimeException(e);  //抛异常给tomcat用于展示友好错误界面
        }


    }

    @Override
    public void destroy() {

    }
}
