package com.dao;

import com.vo.Type;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class TypeDAO {
    public List<Type> findAll() {
        List<Type> typeList = new ArrayList<>();
        Type type = null;
        String sql = "select * from type;";
        ResultSet rs = DBUtil.executeQuery(sql);
        try {
            while (rs.next()) {
                type = new Type(
                        rs.getInt("tId"),
                        rs.getString("tName"));
                typeList.add(type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typeList;
    }

    public Type findById(int tId){
        Type type = null;
        String sql = "select * from type where tId = ?;";
        Object[] in = {tId};
        ResultSet rs = DBUtil.executeQuery(sql,in);
        try {
            while (rs.next()) {
                type = new Type(
                        rs.getInt("tId"),
                        rs.getString("tName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return type;
    }

    public boolean insert(Type type){
        int count = 0;
        Object [] in = {type.gettName()};
        String sql = "insert into type(tName) values(?);";
        count = DBUtil.executeUpdate(sql,in);
        if(count>0){
            return true;
        }else{
            return false;
        }
    }

    public boolean update(Type type){
        int count = 0;
        Object [] in = {type.gettName(),type.gettId()};
        String sql = "update set type set tName = ? where tId = ?";
        count = DBUtil.executeUpdate(sql,in);
        if(count>0){
            return true;
        }else{
            return false;
        }
    }

    public boolean delete(int tId){
        int count = 0;
        Object [] in = {tId};
        String sql = "delete from type where tId = ?;";
        count = DBUtil.executeUpdate(sql,in);
        if(count>0){
            return true;
        }else{
            return false;
        }
    }
}
