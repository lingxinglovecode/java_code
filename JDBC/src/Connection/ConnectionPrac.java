package Connection;

import org.testng.annotations.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

/**
 * @author lianxing
 * @create 2021-09-11 22:33
 */
public class ConnectionPrac {


    @Test
    public void Connection() throws Exception {
        //加载配置文件
        InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(stream);
        String password = properties.getProperty("password");
        String user = properties.getProperty("user");
        String url = properties.getProperty("url");


        //加载driver
        Class.forName("com.mysql.jdbc.Driver");

        //获取连接
        Connection connection = DriverManager.getConnection(url, user, password);
//      System.out.println(connection);


//        PreparedStatement statement = new PreparedStatement();

        String s = "select * from myemployees.employees";
        PreparedStatement ps = connection.prepareStatement(s);
        ps.execute();
        
        
        
    }





}
