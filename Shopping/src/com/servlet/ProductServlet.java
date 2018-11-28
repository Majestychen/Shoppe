package com.servlet;

import com.Util.R;
import com.dao.JsonUtils;
import com.dao.ProductDAO;
import com.vo.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDAO dao = new ProductDAO();

        String action = request.getParameter("action");
        if(action.equals("findByTypeId")){
            int tId = Integer.parseInt(request.getParameter("tId"));
            List<Product> productList = dao.findByTypeId(tId);
            String result = JsonUtils.toJson(productList);
            response.getWriter().println(result);
        }else if(action.equals("findByName")){
            String pName = request.getParameter("pName");
            List<Product> productList = dao.findByName(pName);
            String result = JsonUtils.toJson(productList);
            response.getWriter().println(result);
        }else if(action.equals("insert")){
            String pName = request.getParameter("pName");
            int tId = Integer.parseInt(request.getParameter("tId"));
            double price = Double.parseDouble(request.getParameter("price"));
            String photo = request.getParameter("photo");
            int pStock = Integer.parseInt(request.getParameter("pStock"));
            String detailed = request.getParameter("detailed");
            int pState = Integer.parseInt(request.getParameter("pState"));
            if (dao.insert(new Product(pName,tId,price,photo,pStock,detailed,pState))) {
                response.getWriter().print("{\"msg\":\"添加成功\"}");
            } else {
                response.getWriter().print("{\"msg\":\"添加失败\"}");
            }
        }else if(action.equals("del")){
            int pId = Integer.parseInt(request.getParameter("pId"));
            if (dao.delete(pId)) {
                response.getWriter().print("{\"msg\":\"删除成功\"}");
            } else {
                response.getWriter().print("{\"msg\":\"删除失败\"}");
            }
        }else if(action.equals("update")){
            int pId = Integer.parseInt(request.getParameter("pId"));
            String pName = request.getParameter("pName");
            int tId = Integer.parseInt(request.getParameter("tId"));
            double price = Double.parseDouble(request.getParameter("price"));
            String photo = request.getParameter("photo");
            int pStock = Integer.parseInt(request.getParameter("pStock"));
            String detailed = request.getParameter("detailed");
            int pState = Integer.parseInt(request.getParameter("pState"));
            if (dao.update(new Product(pId,pName,tId,price,photo,pStock,detailed,pState))) {
                response.getWriter().print("{\"msg\":\"修改成功\"}");
            } else {
                response.getWriter().print("{\"msg\":\"修改失败\"}");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDAO dao = new ProductDAO();
        String action = request.getParameter("action");
        if(action.equals("list")){
            List<Product> productList = dao.findAll();
            response.getWriter().println(JsonUtils.toJson(productList));
        }else if(action.equals("getPage")){
            int page=Integer.parseInt(request.getParameter("page"));
            int limit=Integer.parseInt(request.getParameter("limit"));
            String result="";
            R r = new R();
            r.setCode(0);
            r.setCount(dao.findAll().size());
            r.setData(dao.getPager(page, limit));
            r.setMsg("sljkfs");
            result = JsonUtils.toJson(r);
            response.getWriter().println(result);
        }
    }
}
