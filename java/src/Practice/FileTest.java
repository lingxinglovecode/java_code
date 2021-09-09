package Practice;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author lianxing
 * @create 2021-09-07 11:09
 */
public class FileTest<pv> {


    @Test
    public void newFileTest() throws IOException {

        File dir1 = new File("D:\\code\\java\\src\\file");
        if (!dir1.exists()){
            dir1.mkdir();
        }

        File file1 = new File(dir1.getAbsolutePath()+"\\test1.txt");
        File file2 = new File(dir1.getAbsolutePath()+"\\test2.txt");
        File file3 = new File(dir1.getAbsolutePath()+"\\test3.txt");

        file1.createNewFile();
        file2.createNewFile();
        file3.createNewFile();

        if(file1.exists()){
            file1.delete();
        }

    }


    @Test
    public void jpgTest(){
        File dir = new File("C:\\Users\\zs\\Pictures\\粘贴的图片\\");
        File[] files = dir.listFiles();
        if(dir.exists()){
            for(File i : files){
                if (i.getName().endsWith("png")){
                    System.out.println(i.getName());
                }
            }


        }


    }

    public long readAllFiles(File file){
        long size = 0;
        if (file.isFile()){
            return file.length();
        }
        else {
            File[] files  = file.listFiles();
            for (File f : files){
                size = size + readAllFiles(f);
            }
            return size;
        }

    }

    @Test
    public void readAll(){
      String  fileDir = "E:\\Develop\\1.尚硅谷全套JAVA教程--基础必备（67.32GB）\\尚硅谷宋红康Java核心基础_好评如潮（30天入门）";
      File file = new File(fileDir);
        long size =readAllFiles(file);

        System.out.println(size);


    }



}
