package com.dao;

import com.vo.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        Product product = null;
        String sql = "select * from product;";
        ResultSet rs = DBUtil.executeQuery(sql);
        try {
            while (rs.next()) {
                product = new Product(
                        rs.getInt("pId"),
                        rs.getString("pName"),
                        rs.getInt("tId"),
                        rs.getDouble("price"),
                        rs.getString("photo"),
                        rs.getInt("pStock"),
                        rs.getString("detailed"),
                        rs.getInt("pState"),
                        rs.getInt("pOther"));
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    public List<Product> getPager(int page,int limit) {

        int start = (page - 1) * limit;
        int end = page * limit;
        String sql = "select pId,pName,tName,price,photo,pStock,detailed,pState from product p inner join type t on p.tId = t.tId order by pId limit ?,?;";
        Object[] in={start,end};
        ResultSet rs = DBUtil.executeQuery(sql,in);
        List<Product> modelList = new ArrayList<Product>();
        Product model = null;
        try {
            while(rs.next()) {
                model = new Product(
                        rs.getInt("pId"),
                        rs.getString("pName"),
                        rs.getString("tName"),
                        rs.getDouble("price"),
                        rs.getString("photo"),
                        rs.getInt("pStock"),
                        rs.getString("detailed"),
                        rs.getInt("pState"));
                modelList.add(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return modelList;
    }

    public Product findById(int pId) {
        Product product = null;
        String sql = "select * from product where pId = ?;";
        Object[] in = {pId};
        ResultSet rs = DBUtil.executeQuery(sql, in);
        try {
            while (rs.next()) {
                product = new Product();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    public List<Product> findByName(String name){
        List<Product> productList = new ArrayList<>();
        Product product = null;
        String sql = "select * from product where pName like '%"+name+"%';";
        ResultSet rs = DBUtil.executeQuery(sql);
        try {
            while (rs.next()) {
                product = new Product(
                        rs.getInt("pId"),
                        rs.getString("pName"),
                        rs.getInt("tId"),
                        rs.getDouble("price"),
                        rs.getString("photo"),
                        rs.getInt("pStock"),
                        rs.getString("detailed"),
                        rs.getInt("pState"),
                        rs.getInt("pOther"));
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    public List<Product> findByTypeId(int tId) {
        List<Product> productList = new ArrayList<>();
        Product product = null;
        String sql = "select * from product where tId = ?;";
        Object[] in = {tId};
        ResultSet rs = DBUtil.executeQuery(sql, in);
        try {
            while (rs.next()) {
                product = new Product(
                        rs.getInt("pId"),
                        rs.getString("pName"),
                        rs.getInt("tId"),
                        rs.getDouble("price"),
                        rs.getString("photo"),
                        rs.getInt("pStock"),
                        rs.getString("detailed"),
                        rs.getInt("pState"),
                        rs.getInt("pOther"));
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    public boolean insert(Product product) {
        int count = 0;
        Object[] in = {product.getpName(),product.gettId(),product.getPrice(),product.getPhoto(),product.getpStock(),product.getDetailed(),product.getpState()};
        String sql = "insert into product(pName,tId,price,photo,pStock,detailed,pState) values(?,?,?,?,?,?,?)";
        count = DBUtil.executeUpdate(sql, in);
        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean update(Product product) {
        int count = 0;
        Object[] in = {product.getpName(),product.gettId(),product.getPrice(),product.getPhoto(),product.getpStock(),product.getDetailed(),product.getpState(),product.getpId()};
        String sql = "update product set pName = ?,tId = ?,price = ?,photo = ?,pStock = ?,detailed = ?,pState = ? where pId = ?;";
        count = DBUtil.executeUpdate(sql, in);
        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(int pId) {
        int count = 0;
        Object[] in = {pId};
        String sql = "delete from product where pId = ?;";
        count = DBUtil.executeUpdate(sql, in);
        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }

}
