package com.lianxing.web;

import com.lianxing.pojo.Book;
import com.lianxing.pojo.Page;
import com.lianxing.service.BookService;
import com.lianxing.service.impl.BookServiceImpl;
import com.lianxing.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author lianxing
 * @description
 * @create 2021-10-13 15:49
 */
public class ClientBookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),0);
        pageNo +=1;


        Book book = WebUtils.copyParamToBean(req.getParameterMap(),new Book());
        bookService.addBook(book);
        //请求转发是一次请求，用户刷新之后上面添加操作也会重复执行，所以使用重定向
//        req.getRequestDispatcher("/manager/bookServlet?action=list").forward(req,resp);
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNo="+pageNo);

    }
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int i = WebUtils.parseInt(req.getParameter("id"),0);
        bookService.deleteBookById(i);
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));
    }

    protected void  list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Book> books = bookService.queryBooks();
        //全部图书并保存到request域中
        req.setAttribute("books",books);
        //请求转发
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);



    }


    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1获取请求参数图书编号
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        //2查询图书
        Book book = bookService.queryBookById(id);
        //3保存到域中
        req.setAttribute("book",book);
        //4请求转发
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req,resp);

    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        bookService.updateBook(book);
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));

    }

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1 获取请求的参数
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //2 调用BookService获取page对象
        Page<Book> page = bookService.page(pageNo, pageSize);

        page.setUrl("client/clientBookServlet?action=page");

        //3 保存配置对象到request域中
        req.setAttribute("page",page);
        //4 请求转发到book_manange页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }

    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1 获取请求的参数
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        int min = WebUtils.parseInt(req.getParameter("min"),0);
        int max = WebUtils.parseInt(req.getParameter("max"), Integer.MAX_VALUE);

        //2 调用BookService获取page对象
        Page<Book> page = bookService.pageByPrice(pageNo, pageSize,min,max);

        StringBuilder sb = new StringBuilder("client/clientBookServlet?action=pageByPrice");
        if (req.getParameter("min")!=null){
            sb.append("&min=").append(req.getParameter("min"));
        }
        if (req.getParameter("max")!=null){
            sb.append("&max=").append(req.getParameter("max"));
        }
        page.setUrl(sb.toString());

        //3 保存配置对象到request域中
        req.setAttribute("page",page);
        //4 请求转发到book_manange页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }

}
