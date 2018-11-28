package com.servlet;

import com.dao.JsonUtils;
import com.dao.TypeDAO;
import com.vo.Type;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Type.do")
public class TypeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        TypeDAO dao = new TypeDAO();

        String action = request.getParameter("action");
        if(action.equals("update")){
            int tId = Integer.parseInt(request.getParameter("tId"));
            String tName = request.getParameter("tName");
            if(dao.update(new Type(tId,tName))){
                response.getWriter().print("{\"msg\":\"修改成功\"}");
            }else
                response.getWriter().print("{\"msg\":\"修改失败\"}");
        }else if(action.equals("del")){
            int tId = Integer.parseInt(request.getParameter("tId"));
            if(dao.delete(tId)){
                response.getWriter().print("{\"msg\":\"删除成功\"}");
            }else
                response.getWriter().print("{\"msg\":\"删除失败\"}");
        }else if(action.equals("insert")){
            String tName = request.getParameter("tName");
            if(dao.insert(new Type(tName))){
                response.getWriter().print("{\"msg\":\"添加成功\"}");
            }else
                response.getWriter().print("{\"msg\":\"添加失败\"}");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TypeDAO dao = new TypeDAO();

        List<Type> typeList = dao.findAll();
        String result = JsonUtils.toJson(typeList);
        response.getWriter().println(result);
    }
}
