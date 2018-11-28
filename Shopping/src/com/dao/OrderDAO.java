package com.dao;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.vo.Order;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {

    public List<Order> findAll(int uId) {
        List<Order> orderList = new ArrayList<Order>();
        Order order = null;
        String sql = "select p.photo,p.detailed,p.price,buy_num from `order` o \n" +
                "inner join buy_cat b on o.cId = b.cId\n" +
                "inner join product p on b.pId = p.pId where o.uId = ? and o.oState = 0;";
        Object[]in = {uId};
        ResultSet rs = DBUtil.executeQuery(sql,in);
        try {
            while (rs.next()) {
                order = new Order(
                        rs.getString("photo"),
                        rs.getString("detailed"),
                        rs.getDouble("price"),
                        rs.getInt("buy_num")
                );
                orderList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }

    public Order findById(int uId,int oId){
        Order order = null;
        String sql = "";
        Object[] in = {uId,oId};
        ResultSet rs = DBUtil.executeQuery(sql,in);
        try {
            while (rs.next()) {

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    public boolean insert(String oNum, int cId, double sumPrice, int uId){
        Object [] in = {oNum,cId,sumPrice,uId};
        String sql = "insert into `order`(oNum,cId,sumPrice,uId) values(?,?,?,?);";
        return curr(sql,in);
    }

    public boolean update(int aId, int uId, String oNum){
        Object [] in = {aId,uId,oNum};
        String sql = "update `order` set oState = 1,aId = ? where uId = ? and oNum = ?";
        return curr(sql,in);
    }

    public boolean delete(int oId,int uId){
        Object [] in = {oId,uId};
        String sql = "delete from order where oId = ? and uId = ?";
        return curr(sql,in);
    }

    public boolean curr(String sql,Object[]in){
        int count = 0;
        count = DBUtil.executeUpdate(sql,in);
        if(count>0){
            return true;
        }else{
            return false;
        }
    }

    public double getSumPrice(int uId){
        String sql = "select sum(sumPrice)sumPrice from `order` where uId = ? and oState = 0;";
        double sumPrice = 0;
        Object[] in = {uId};
        ResultSet rs = DBUtil.executeQuery(sql,in);
        try {
            while (rs.next()){
                sumPrice = rs.getDouble("sumPrice");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return sumPrice;
    }
}
