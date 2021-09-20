package my_test;

import org.apache.commons.beanutils.BeanPropertyValueChangeClosure;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author lianxing
 * @description
 * @create 2021-09-16 15:21
 */
public class HelloServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println(servletConfig.getServletName());
        System.out.println("初始化参数值："+servletConfig.getInitParameter("username"));
        System.out.println("初始化url："+servletConfig.getInitParameter("url"));
        System.out.println("context对象"+servletConfig.getServletContext());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Servlet被访问到了");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String method = httpServletRequest.getMethod();
//        System.out.println(method);
        if ("GET".equals(method)){
            doGet();
        }
        else if ("POST".equals(method)){
            doPost();
        }
    }

    public void doGet(){
        System.out.println("Get请求");

    }

    public void doPost(){
        System.out.println("Post请求");

    }


    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
