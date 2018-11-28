package com.servlet;

import com.Util.RandomNumber;
import com.dao.JsonUtils;
import com.dao.OrderDAO;
import com.vo.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        OrderDAO dao = new OrderDAO();
        if(action.equals("insert")){
            String[] cIds = request.getParameterValues("cIds");
            String oNum = RandomNumber.randomNum();
            int uId = (int) request.getSession().getAttribute("user");
            String[] sumPrice = request.getParameterValues("sumPrice");
            boolean bool = false;
            for (int i = 0; i < cIds.length; i++) {
                bool = dao.insert(oNum,Integer.parseInt(cIds[i]), Double.parseDouble(sumPrice[i]),uId);
            }
            request.getSession().setAttribute("rand",oNum);
            response.getWriter().print("{\"msg\":\""+bool+"\"}");
        }else if(action.equals("getsumPrice")){
            int uId = (int) request.getSession().getAttribute("user");
            double sumPrice = dao.getSumPrice(uId);
            response.getWriter().print("{\"sumMoney\":\""+sumPrice+"\"}");
        }else if(action.equals("update")){
            int uId = (int) request.getSession().getAttribute("user");
            int aId = Integer.parseInt(request.getParameter("aId"));
            String rand = String.valueOf(request.getSession().getAttribute("rand"));
            if(dao.update(aId,uId,rand)){
                response.getWriter().print("{\"msg\":\"购买成功\"}");
            }else{
                response.getWriter().print("{\"msg\":\"系统繁忙,请重新下单\"}");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderDAO dao = new OrderDAO();
        int uId = (int) request.getSession().getAttribute("user");
        List<Order> orderList = dao.findAll(uId);
        response.getWriter().print(JsonUtils.toJson(orderList));
    }
}
