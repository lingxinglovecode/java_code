package my_test; /**
 * @description
 * @author lianxing
 * @create 2021-09-16 17:43
 */

import com.alibaba.druid.sql.dialect.phoenix.ast.PhoenixUpsertStatement;
import org.junit.Test;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class HelloServlet3 extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//       1.获取 web.xml 中配置的上下文参数 context-param
//        ServletContext context = getServletConfig().getServletContext();
        ServletContext context = getServletContext();
        System.out.println(context.getInitParameter("username"));
//        2.获取当前的工程路径，格式:/工程路径
        String path = context.getContextPath();
        System.out.println("当前工程路径："+ path);
//        3.获取工程部署后在服务器磁盘上的绝对路径
//       “/”被服务器解析为 http://ip:port/工程名/
        String realPath = context.getRealPath("/");
        System.out.println("当前工程部署的路径"+realPath);

//        4.存取数据
        context.setAttribute("key1","value1");
        System.out.println("Context中获取域数据key1的值："+context.getAttribute("key1"));//Context中获取域数据key1的值：value1



    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}


