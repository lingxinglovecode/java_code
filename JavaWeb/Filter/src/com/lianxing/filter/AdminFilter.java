package com.lianxing.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author lianxing
 * @description
 * @create 2021-10-24 10:38
 */
public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * @Description: 专门用于拦截请求，权限检查
     * @param: servletRequest
     * @param: servletResponse
     * @param: filterChain
     * @return void
     * @author lianxing
     * @date 2021/10/24 10:39
    */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpServletRequest.getSession();

        Object user = session.getAttribute("user");
        if ( user==null ) {
            servletRequest.getRequestDispatcher("/admin/login.jsp").forward(servletRequest,servletResponse);
            return;
        }else{
            //让程序继续往下访问目标资源
            filterChain.doFilter(servletRequest,servletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}
