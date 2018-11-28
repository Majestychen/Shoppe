package com.servlet;

import com.dao.AddressDAO;
import com.dao.JsonUtils;
import com.vo.Address;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/AddressServlet")
public class AddressServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AddressDAO dao = new AddressDAO();
        String action = request.getParameter("action");
        if (action.equals("insert")) {
            String aName = request.getParameter("aName");
            String aPhone = request.getParameter("aPhone");
            String address = request.getParameter("address");
            int uId = (int) request.getSession().getAttribute("user");
            Address addrs = dao.insert(new Address(aName,aPhone,address,uId));
            System.out.println(addrs);
            if(addrs != null){
                response.getWriter().print(JsonUtils.toJson(addrs));
            }else{
                response.getWriter().print("{\"msg\":\"添加失败\"}");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AddressDAO dao = new AddressDAO();
        int uId = (int) request.getSession().getAttribute("user");
        List<Address> addressList = dao.findAll(uId);
        response.getWriter().print(JsonUtils.toJson(addressList));
    }
}
