package my_test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author lianxing
 * @description
 * @create 2021-09-17 16:13
 */
public class RequestServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // i.getRequestURI()获取请求的资源路径
        System.out.println("URI => " + req.getRequestURI());
        //ii.getRequestURL()获取请求的统一资源定位符（绝对路径）
        System.out.println("URL => " + req.getRequestURL());
        // iii.getRemoteHost()获取客户端的ip地址
        /**
         * 在IDEA中，使用localhost访问时，得到的客户端 ip 地址是 ===>>> 127.0.0.1<br/>
         * 在IDEA中，使用127.0.0.1访问时，得到的客户端 ip 地址是 ===>>> 127.0.0.1<br/>
         * 在IDEA中，使用 真实ip 访问时，得到的客户端 ip 地址是 ===>>> 真实的客户端 ip 地址<br/>
         */
        System.out.println("客户端 ip地址 => " + req.getRemoteHost());
        //iv.getHeader()获取请求头
        System.out.println("请求头User-Agent ==>> " + req.getHeader("User-Agent"));
        //vii.getMethod()获取请求的方式GET或POST
        System.out.println( "请求的方式 ==>> " + req.getMethod() );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        System.out.println("用户名："+username);
        String password = req.getParameter("password");
        System.out.println("密码："+password);

        String[] hobbies = req.getParameterValues("hobby");
        System.out.println("俺的爱好："+ Arrays.asList(hobbies));

    }
}
