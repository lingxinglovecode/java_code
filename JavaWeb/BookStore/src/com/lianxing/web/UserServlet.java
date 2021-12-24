package com.lianxing.web;

import com.google.gson.Gson;
import com.lianxing.pojo.User;
import com.lianxing.service.UserService;
import com.lianxing.service.impl.UserServiceImpl;
import com.lianxing.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @author lianxing
 * @description
 * @create 2021-09-24 15:48
 */
public class UserServlet extends BaseServlet {

    private UserService userService = new UserServiceImpl();


    /**
     * @Description: 处理登录的功能
     * @param: req
     * @param: resp
     * @return void
     * @author lianxing
     * @date 2021/9/24 16:15
    */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


//        System.out.println("处理登录需求");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User loginUser = userService.login(new User(null,username,password,null));
        if ( loginUser==null ){
            System.out.println("登录失败");
            req.setAttribute("msg","用户名或密码错误");
            req.setAttribute("username",username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }else {
            //保存用户登录之后的信息到session域中
            req.getSession().setAttribute("user",loginUser);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }



}
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //销毁session中的用户登录信息
        req.getSession().invalidate();
        //重定向向首页
        resp.sendRedirect(req.getContextPath());


    }


    /**
     * @Description: 处理注册的功能
     * @param: req
     * @param: resp
     * @return void
     * @author lianxing
     * @date 2021/9/24 16:15
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String token = (String)req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        // 删除 Session 中的验证码
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        User user = WebUtils.copyParamToBean(req.getParameterMap(),new User());
        String code = req.getParameter("code");
        if (token!=null && token.equalsIgnoreCase(code) ){
            if ( userService.existsUsername(username) ){
//                System.out.println("用户名"+username+"已存在！");
                req.setAttribute("msg","用户名"+username+"已存在！");
                req.setAttribute("email",email);
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);


            }else {
                userService.registerUser(new User(null,username,password,email));
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
            }



        }else {
            //回显信息保存到requset域之中
            req.setAttribute("msg","验证码错误");
            req.setAttribute("username",username);
            req.setAttribute("email",email);


            System.out.println("验证码"+code+"错误！");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }

    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String action = req.getParameter("action");
//        try {
//            //获取action业务鉴别字符串，利用反射的方式调用方法
//            Method method = this.getClass().getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);
//            method.invoke(this,req,resp);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
////        if ( "login".equals(action) ){
////           login(req,resp);
////
////        }else if("regist".equals(action)){
////            regist(req,resp);
////
////        }
//
//
//
//    }
    protected void ajaxExistUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        boolean existsUsername = userService.existsUsername(username);

        //返回结果封装为map对象
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("existsUsername", existsUsername);

        Gson gson = new Gson();
        String json = gson.toJson(resultMap);
        resp.getWriter().write(json);



    }

}
