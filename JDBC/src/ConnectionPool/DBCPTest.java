package ConnectionPool;

import org.apache.commons.dbcp.BasicDataSource;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author lianxing
 * @description
 * @create 2021-09-12 19:53
 */
public class DBCPTest {




    public void testGetConnection() throws SQLException {

        BasicDataSource source = new BasicDataSource();

        source.setDriverClassName("com.mysql.jdbc.Driver");
        source.setUrl("jdbc:mysql://localhost:3305/test");
        source.setUsername("root");
        source.setPassword("123151");

        Connection connection = source.getConnection();
        System.out.println(connection);
    }



    @Test
    public void testGetConnection1(){
        ClassLoader.getSystemClassLoader().getResourceAsStream("");

//        FileInputStream stream = new FileInputStream();


    }



}
