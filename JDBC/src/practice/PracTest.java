package practice;

import org.testng.annotations.Test;
import util.JDBCUtils;
import util.Student;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author lianxing
 * @description
 * @create 2021-09-12 12:02
 */
public class PracTest {
    public static void main(String[] args) {
        PracTest pracTest = new PracTest();
        pracTest.StudentInsertTest();
    }



    @Test
    public void CustomTest() throws Exception {
        Connection conn = JDBCUtils.getConnection();
        String sql = "insert into customers(name,email,birth) values(?,?,?)";
//        PreparedStatement ps = conn.prepareStatement(sql);
//        ps.execute();
        JDBCUtils CustJDBC = new JDBCUtils();

        String name = "lianxing";
        String email = "ling@163.com";

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse("2001-2-3");
        java.sql.Date date1 = new java.sql.Date(date.getTime());


        CustJDBC.customUpdate(sql,name,email,date1);




    }



    public void StudentInsertTest(){


//        System.out.println("请输入考生的详细信息：");
//        int floatID = 1;
        System.out.print("Type：");
        Scanner scanner = new Scanner(System.in);
        int type = scanner.nextInt();
        System.out.print("IDCard:");
        String idCard = scanner.next();
        System.out.print("ExamCard:");
        String examCard = scanner.next();
        System.out.print("StudenName:");
        String name = scanner.next();
        System.out.print("Location:");
        String location = scanner.next();
        System.out.print("Grade");
        int grade = scanner.nextInt();

        String sql = "insert into students.examstudent(Type,IDCard,ExamCard,StudentName,Location,Grade) values(?,?,?,?,?,?)";


        JDBCUtils stuJDBC = new JDBCUtils();
        int data_proced = stuJDBC.studentUpdate(sql,type,idCard,examCard,name,location,grade);
        if (data_proced > 0 ){
            System.out.println("信息录入成功");
        }
        else {
            System.out.println("插入失败");
        }


    }


    @Test
    public void queryStudentTest() throws Exception {
        String sql = "select StudentName name,Grade grade from students.examstudent where FlowID = 1";

        JDBCUtils stuQuery = new JDBCUtils();
        Student stu = stuQuery.query(Student.class,sql);


    }

    @Test
    public void numTest(){
        String name = "12";
        int num =12;
        System.out.println(name+num);


    }


}
