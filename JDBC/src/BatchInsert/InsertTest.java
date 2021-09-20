package BatchInsert;

import org.junit.jupiter.api.Test;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author lianxing
 * @description
 * @create 2021-09-13 9:30
 */
public class InsertTest {


    @Test
    void insertTest() throws Exception {

        Connection connection = JDBCUtils.getConnectionFromPool();
        String sql = "insert into `order`(order_name)values(?)";
        PreparedStatement ps = connection.prepareStatement(sql);

        connection.setAutoCommit(false);

        for (int i = 0; i < 100000; i++) {
            ps.setString(1,"num"+i);
            ps.addBatch();

            if (i%500 == 0){
                ps.executeBatch();
                ps.clearBatch();
            }
        }

        connection.commit();

        JDBCUtils.closeResource(connection,ps);


    }



}
