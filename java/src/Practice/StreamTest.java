package Practice;

import java.io.*;

/**
 * @author lianxing
 * @create 2021-09-07 18:17
 */
public class StreamTest {
    public static void main(String[] args) {
        File f1 = new File("D:\\code\\java\\1.png");
        File f2 = new File("D:\\code\\java\\copy1.png");
        StreamTest st =new StreamTest();
        long n1 = System.currentTimeMillis();
        st.copy1(f1,f2);
        long n2 = System.currentTimeMillis();
        System.out.println("标准节点流复制时间："+(n2-n1));

        long n3 = System.currentTimeMillis();
        st.copyWithBuffer(f1,f2);
        long n4 = System.currentTimeMillis();
        System.out.println("使用buffer缓冲流后的复制时间"+(n4-n3));

        st.enCryptImg(f1,f2);
        st.deCryptImg("D:\\code\\java\\copy1.png");
    }




    public void copy1(File f1,File f2) {

        InputStream is = null;
        OutputStream out = null;
        try {
            is = new FileInputStream(f1);
            out = new FileOutputStream(f2);

            byte[] charBf = new byte[10];
            int len;
            while ( (len=is.read(charBf))!=-1){
//                for (int i=0;i<len;i++){
//                    out.write(charBf[i]);
//                }
                out.write(charBf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (out!=null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }


        }







    }

    public void copyWithBuffer(File f1,File f2)   {

        BufferedInputStream inputStream = null;
        BufferedOutputStream outputStream = null;
        try {
            inputStream = new BufferedInputStream(new FileInputStream(f1));
            outputStream = new BufferedOutputStream(new FileOutputStream(f2));

            byte[] buffer =new byte[10];
            int len;
            while ((len=inputStream.read(buffer))!=-1){
                outputStream.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }



        }







    }

    public void enCryptImg(File f1,File f2){

        BufferedInputStream inputStream = null;
        BufferedOutputStream outputStream = null;
        try {
            inputStream = new BufferedInputStream(new FileInputStream(f1));
            outputStream = new BufferedOutputStream(new FileOutputStream(f2));

            byte[] buffer =new byte[10];
            int len;
            while ((len=inputStream.read(buffer))!=-1){
                for (int i = 0; i < len; i++) {
                    outputStream.write(buffer[i]^5);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }



        }







    }

    public void deCryptImg(String filePath){

        File file = new File(filePath);
        File fileCopy = new File(file.getParentFile()+"//deCryptImg.png");

        BufferedInputStream inputStream = null;
        BufferedOutputStream outputStream = null;
        try {
            inputStream = new BufferedInputStream(new FileInputStream(file));
            outputStream = new BufferedOutputStream(new FileOutputStream(fileCopy));

            byte[] buffer =new byte[10];
            int len;
            while ((len=inputStream.read(buffer))!=-1){
                for (int i = 0; i < len; i++) {
                    outputStream.write(buffer[i]^5);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }



        }







    }


}


