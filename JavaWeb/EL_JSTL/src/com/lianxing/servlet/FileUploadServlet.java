package com.lianxing.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author lianxing
 * @description
 * @create 2021-09-23 14:25
 */
public class FileUploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //用来处理上传的数据
        System.out.println("文件上传过来了");
        super.doPost(req, resp);

        ServletInputStream inputStream = req.getInputStream();
        byte[] buffer = new byte[102400];
        int read = inputStream.read(buffer);
        System.out.println(new String(buffer,0,read));




        if ( ServletFileUpload.isMultipartContent(req) ){
            DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            try {
                List<FileItem> list = servletFileUpload.parseRequest(req);
                for (FileItem fileItem : list){
                    if ( fileItem.isFormField() ){
                        System.out.println(fileItem.getFieldName());
                        System.out.println(fileItem.getString());
                    }
                    else{
                        fileItem.write(new File("/a.jpg"));


                    }

                }


            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }


        }


    }
}
