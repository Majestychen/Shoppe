package com.servlet;

import com.Util.R;
import com.dao.JsonUtils;
import com.dao.UserDAO;
import com.vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        UserDAO dao = new UserDAO();
        if (action.equals("login")) {
            String userName = request.getParameter("userName");
            String pwd = request.getParameter("pwd");
            int uId = dao.login(userName, pwd);
            if (uId > 0) {
                response.getWriter().print("{\"userName\":\"" + userName + "\",\"code\":\"1\"}");
                request.getSession().setAttribute("user", uId);
                request.getSession().setAttribute("userName", userName);
            } else {
                response.getWriter().print("{\"msg\":\"登录失败,请检查密码是否正确\",\"code\":\"0\"}");
            }
        } else if (action.equals("insert")) {
            String userName = request.getParameter("userName");
            String pwd = request.getParameter("pwd");
            String phone = request.getParameter("phone");
            String idCard = request.getParameter("idCard");
            String email = request.getParameter("email");
            if (dao.insert(new User(userName, pwd, phone, idCard, email))) {
                response.getWriter().print("{\"msg\":\"注册成功,欢迎您:" + userName + "\",\"code\":\"1\"}");
                int uId = dao.login(userName, pwd);
                request.getSession().setAttribute("user", uId);
                request.getSession().setAttribute("userName", userName);
            } else {
                response.getWriter().print("{\"msg\":\"注册失败\",\"code\":\"0\"}");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO dao = new UserDAO();
        String action = request.getParameter("action");

        if ("getPage".equals(action)) {
            int page = Integer.parseInt(request.getParameter("page"));
            int limit = Integer.parseInt(request.getParameter("limit"));
            String result = "";
            R r = new R();
            r.setCode(0);
            r.setCount(dao.findAll().size());
            r.setData(dao.getPager(page, limit));
            r.setMsg("sljkfs");
            result = JsonUtils.toJson(r);
            response.getWriter().println(result);
        } else {
            List<User> userList = dao.findAll();
            response.getWriter().println(JsonUtils.toJson(userList));
        }
    }
}
