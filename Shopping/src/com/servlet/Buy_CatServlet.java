package com.servlet;

import com.dao.Buy_CatDAO;
import com.dao.JsonUtils;
import com.vo.Buy_Cat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Buy_CatServlet")
public class Buy_CatServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Buy_CatDAO dao = new Buy_CatDAO();
        String action = request.getParameter("action");
        if (action.equals("insert")) {
            int pId = Integer.parseInt(request.getParameter("pId"));
            int buy_num = Integer.parseInt(request.getParameter("buy_num"));
            int cState = Integer.parseInt(request.getParameter("cState"));
            if (request.getSession().getAttribute("user") != null) {
                int uId = (int) request.getSession().getAttribute("user");
                int cId = dao.getPid(pId,uId);
                if(cId > 0){
                    dao.update(cId,uId);
                }else {
                    dao.insert(new Buy_Cat(pId, buy_num, cState, uId));
                }
                response.getWriter().print("{\"msg\":\"添加成功\",\"code\":\"1\"}");
            } else {
                response.getWriter().print("{\"msg\":\"请先登录，再进行操作\",\"code\":\"0\"}");
            }
        } else if (action.equals("getCount")) {
            if (request.getSession().getAttribute("user") != null) {
                int uId = (int) request.getSession().getAttribute("user");
                int count = dao.getBuyCatCount(uId);
                response.getWriter().print("{\"count\":\"" + count + "\"}");
            } else {
                response.getWriter().print("{\"count\":\"0\"}");
            }
        }else if(action.equals("del")){
            int uId = (int) request.getSession().getAttribute("user");
            int cId = Integer.parseInt(request.getParameter("cId"));
            if(dao.delete(cId,uId)){
                response.getWriter().print("{\"msg\":\"删除成功\"}");
            }else{
                response.getWriter().print("{\"msg\":\"删除失败\"}");
            }
        }else if(action.equals("join")){
            if (request.getSession().getAttribute("user") != null) {
                response.getWriter().print("{\"bool\":\"true\",\"userName\":\""+request.getSession().getAttribute("userName")+"\"}");
            } else {
                response.getWriter().print("{\"bool\":\"false\"}");
            }
        }else if(action.equals("updateBuyNum")){
            int uId = (int) request.getSession().getAttribute("user");
            int cId = Integer.parseInt(request.getParameter("cId"));
            int buy_num = Integer.parseInt(request.getParameter("buy_num"));

            if(dao.updateCat(buy_num,cId,uId))
                response.getWriter().print("{\"bool\":\"true\"}");
            else
                response.getWriter().print("{\"bool\":\"false\"}");
        }else if(action.equals("pinList")){
            String[] cIds = request.getParameterValues("cIds");
            int uId = (int) request.getSession().getAttribute("user");
            boolean bool = false;
            for (int i = 0; i < cIds.length; i++) {
                bool = dao.pinList(Integer.parseInt(cIds[i]),uId);
            }
            response.getWriter().print("{\"msg\":\""+bool+"\"}");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Buy_CatDAO dao = new Buy_CatDAO();
        int uId = (int) request.getSession().getAttribute("user");
        List<Buy_Cat> buy_catList = dao.findAll(uId);
        response.getWriter().print(JsonUtils.toJson(buy_catList));
    }
}
