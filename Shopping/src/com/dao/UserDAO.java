package com.dao;

import com.vo.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public int login(String userName, String pwd) {
        int uId = 0;
        String sql = "select uId from user where userName = ? and pwd = ?";
        Object[] in = {userName, pwd};
        ResultSet rs = DBUtil.executeQuery(sql, in);
        try {
            while (rs.next()) {
                uId = rs.getInt("uId");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return uId;
    }

    public List<User> findAll(){
        List<User> userList = new ArrayList<User>();
        User user = null;
        String sql = "select * from user";
        ResultSet rs = DBUtil.executeQuery(sql);
        try {
            while(rs.next()){
                user = new User(
                        rs.getInt("uId"),
                        rs.getString("userName"),
                        rs.getString("pwd"),
                        rs.getString("phone"),
                        rs.getString("idCard"),
                        rs.getString("email")
                );
                userList.add(user);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return userList;
    }

    public List<User> getPager(int page,int limit) {

        int start = (page - 1) * limit;
        int end = page * limit;
        String sql = "select * from user order by uId limit ?,?;";
        Object[] in={start,end};
        ResultSet rs = DBUtil.executeQuery(sql,in);
        List<User> modelList = new ArrayList<User>();
        User model = null;
        try {
            while(rs.next()) {
                model = new User(
                        rs.getInt("uId"),
                        rs.getString("userName"),
                        rs.getString("pwd"),
                        rs.getString("phone"),
                        rs.getString("idCard"),
                        rs.getString("email")
                );
                modelList.add(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return modelList;
    }


    public boolean insert(User user) {
        Object[] in = {user.getUserName(),user.getPwd(),user.getPhone(),user.getIdCard(),user.getEmail()};
        String sql = "insert into user(userName,pwd,phone,idCard,email) values(?,?,?,?,?);";
        return curr(sql, in);
    }

    public boolean updatePwd(User user) {
        Object[] in = {user.getPwd(),user.getuId()};
        String sql = "update user set pwd = ? where uId =?";
        return curr(sql, in);
    }

    public boolean update(User user) {
        Object[] in = {user.getPwd(),user.getuId()};
        String sql = "update user set pwd = ? where uId =?";
        return curr(sql, in);
    }

    public boolean curr(String sql, Object[] in) {
        int count = 0;
        count = DBUtil.executeUpdate(sql, in);
        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }
}
