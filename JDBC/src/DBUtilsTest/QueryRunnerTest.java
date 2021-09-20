package DBUtilsTest;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.jupiter.api.Test;
import util.Customer;
import util.JDBCUtils;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lianxing
 * @description
 * @create 2021-09-13 9:48
 */
public class QueryRunnerTest {

    @Test
    void runnerTest() throws Exception {
        Connection connection = JDBCUtils.getConnectionFromPool();
        QueryRunner runner = new QueryRunner();
        String sql = "insert into customers(name,email,birth)values(?,?,?)";
        int count = runner.update(connection,sql, "何成飞", "he@qq.com", "1992-09-08");

        JDBCUtils.closeResource(connection,null);

    }
    @Test
    void runnerQueryTest2() throws Exception {
        Connection connection = JDBCUtils.getConnectionFromPool();
        QueryRunner runner = new QueryRunner();
        String sql = "select * from customers where id>4 and id<10";
        ArrayListHandler listHandler = new ArrayListHandler();
        List<Object[]> arrayList = new ArrayList<>();
        ArrayHandler handler = new ArrayHandler();
        Object[] list = new Object[1];


        BeanHandler<Customer> beanHandler = new BeanHandler<>(Customer.class);

//        System.out.println(customer);

        BeanListHandler<Customer> beanListHandler = new BeanListHandler<>(Customer.class);
        List<Customer> objectArrayList = new ArrayList<>();
        objectArrayList = runner.query(connection,sql,beanListHandler);

        JDBCUtils.closeResource(connection,null);

    }


}
