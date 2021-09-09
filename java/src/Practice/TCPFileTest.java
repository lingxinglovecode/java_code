package Practice;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author lianxing
 * @create 2021-09-08 10:46
 */
public class TCPFileTest {

    @Test
    public void clientFile()   {

        InputStream is = null;
        BufferedInputStream bis = null;
        Socket socket = null;
        OutputStream sos = null;
        try {
            File direct = new File("");
            String curDir = direct.getAbsolutePath();

            File file = new File(curDir+ "//1.png");
            is = new FileInputStream(file);

            bis = new BufferedInputStream(is);


            InetAddress address = InetAddress.getLocalHost();
            socket = new Socket(address,8765);

            sos = socket.getOutputStream();

            byte[] data = new byte[10];
            int len;
            while ((len=bis.read(data))!=-1){
                sos.write(data,0,len);
            }
//            socket.shutdownOutput();

            InputStream ins = socket.getInputStream();
            byte[] data1 = new byte[10];
            int len1;
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            while ((len1=ins.read(data1))!=-1){
                bos.write(data1,0,len1);
            }


            System.out.println(bos.toString());


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sos != null) {
                try {
                    sos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if ( socket!= null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (bis != null) {
                try {
                    bis.close();
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


        }



    }




    @Test
    public void serverFile()   {

        FileOutputStream fos = null;
        ServerSocket ss = null;
        Socket socket = null;
        ByteArrayOutputStream bos = null;
        try {
            File curDir = new File("");
            String curPath = curDir.getAbsolutePath();
            File file = new File(curPath+"//new.png");
            fos = new FileOutputStream(file);


            ss = new ServerSocket(8765);
            socket = ss.accept();

            InputStream sis = socket.getInputStream();


            byte[] data = new byte[10];
            int len;
            while ((len=sis.read(data))!=-1){
                fos.write(data,0,len);
            }

            OutputStream os = socket.getOutputStream();
            os.write("图片接收完成！".getBytes());




        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
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




