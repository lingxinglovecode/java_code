package com.atguigu.pojo;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

public class Dom4jTest {


    @Test
    public void test1() throws Exception {
        // 创建一个SaxReader输入流，去读取 xml配置文件，生成Document对象
        SAXReader saxReader = new SAXReader();

        Document document = saxReader.read("05_xml/books.xml");

        System.out.println(document);
    }

    //注意在junit测试中，相对路径是从module开始的
    @Test
    public void test2() throws DocumentException {
        //1.读取XML文件
        SAXReader saxReader = new SAXReader();
        //2.通过Document对象获取根元素
        Document document = saxReader.read("05_xml/books.xml");
        Element rootElement = document.getRootElement();
        //3.通过根元素获取book标签对象
        //element()和elements两者都是通过标签名查找子元素
        List<Element> books = rootElement.elements();
        //4.遍历 处理每个book标签为book类
        for (Element book : books){
//            System.out.println(book.asXML());
            Element name = book.element("name");
            String nameText = name.getText();

            String price = book.elementText("price");
            String author = book.elementText("author");
            String sn = book.attributeValue("sn");

            System.out.println(new Book(sn,nameText,Double.parseDouble(price),author));
        }



    }

}
