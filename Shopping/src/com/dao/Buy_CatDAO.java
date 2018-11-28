package com.dao;

import com.vo.Buy_Cat;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Buy_CatDAO {
    public List<Buy_Cat> findAll(int uId) {
        List<Buy_Cat> buy_catList = new ArrayList<>();
        Buy_Cat buy_cat = null;
        String sql = "select cId,p.pId,p.photo,p.detailed,p.price,buy_num from buy_cat b inner join product p on b.pId = p.pId where uId = ? and cState = 0;";
        Object[]in = {uId};
        ResultSet rs = DBUtil.executeQuery(sql,in);
        try {
            while (rs.next()) {
                buy_cat = new Buy_Cat(
                        rs.getInt("cId"),
                        rs.getInt("pId"),
                        rs.getString("photo"),
                        rs.getString("detailed"),
                        rs.getDouble("price"),
                        rs.getInt("buy_num")
                );
                buy_catList.add(buy_cat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return buy_catList;
    }

    public Buy_Cat findById(int uId,int cId){
        Buy_Cat buy_cat = null;
        String sql = "select p.photo,p.detailed,p.price,buy_num from buy_cat b inner join product p on b.pId = p.pId where uId = ? and cState = 0 and cId = ?;";
        Object[] in = {uId,cId};
        ResultSet rs = DBUtil.executeQuery(sql,in);
        try {
            while (rs.next()) {
                buy_cat = new Buy_Cat(
                        rs.getInt("cId"),
                        rs.getInt("pId"),
                        rs.getString("photo"),
                        rs.getString("detailed"),
                        rs.getDouble("price"),
                        rs.getInt("buy_num")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return buy_cat;
    }

    public int getBuyCatCount(int uId){
        int count = 0;
        String sql = "select count(*) count from buy_cat where uId = ? and cState = 0;";
        Object [] in = {uId};
        ResultSet rs = DBUtil.executeQuery(sql,in);
        try {
            while (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public int getPid(int pId,int uId){
        String sql = "select cId from buy_cat where pId = ? and uId = ? and cState = 0;";
        Object[] in = {pId,uId};
        int cId = 0;
        ResultSet rs = DBUtil.executeQuery(sql,in);
        try {
            while (rs.next()) {
                cId = rs.getInt("cId");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cId;
    }

    public boolean insert(Buy_Cat buy_cat){
        Object [] in = {buy_cat.getpId(),buy_cat.getBuy_num(),buy_cat.getcState(),buy_cat.getuId()};
        String sql = "insert into buy_cat(pId,buy_num,cState,uId) value(?,?,?,?);";
        return curr(sql,in);
    }

    public boolean update(int cId, int uId){
        Object [] in = {cId,uId};
        String sql = "update buy_cat set buy_num = buy_num+1 where cId = ? and uId = ?;";
        return curr(sql,in);
    }

    public boolean updateCat(int buy_num, int cId, int uId){
        Object [] in = {buy_num,cId,uId};
        String sql = "update buy_cat set buy_num = ? where cId = ? and uId = ?;";
        return curr(sql,in);
    }

    public boolean pinList(int cId,int uId){
        Object [] in = {cId,uId};
        String sql = "update buy_cat set cState = 1 where cId = ? and uId = ?;";
        return curr(sql,in);
    }

    public boolean delete(int cId,int uId){
        Object [] in = {cId,uId};
        String sql = "delete from buy_cat where cId = ? and uId = ?";
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

}
