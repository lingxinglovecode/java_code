package Practice;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author lianxing
 * @create 2021-09-08 10:10
 */
public class TCPTest {


    @Test
    public void ClientTest()  {
        Socket socket = null;
        OutputStream os = null;

        try {
            //1.创建socket
            InetAddress address = InetAddress.getLocalHost();
            socket = new Socket(address,8899);

            //2.获取输出流
            os = socket.getOutputStream();

            //3.写出数据
            os.write("Helle!Sever!".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os!=null){
                //4.关闭资源
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }
    }


    @Test
    public void ServerTest()   {

        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            ss = new ServerSocket(8899);
            socket = ss.accept();

            is = socket.getInputStream();

//        byte[] data = new byte[10];
//        int len;
//        while ( (len = is.read(data))!=-1){
//            String str = new String(data,0,len);
//            System.out.println(str);
//
//        }

            baos = new ByteArrayOutputStream();
            byte[] data = new byte[10];
            int len;
            while ((len=is.read(data))!=-1){
                baos.write(data,0,len);
            }
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


    }



}
