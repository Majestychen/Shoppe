package com.dao;

import com.vo.Address;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressDAO {

    public List<Address> findAll(int uId) {
        List<Address> addressList = new ArrayList<Address>();
        Address address = null;
        String sql = "select * from address where uId = ?";
        Object[]in = {uId};
        ResultSet rs = DBUtil.executeQuery(sql,in);
        try {
            while (rs.next()) {
                address = new Address(
                        rs.getInt("aId"),
                        rs.getString("aName"),
                        rs.getString("aPhone"),
                        rs.getString("address"),
                        rs.getInt("uId")
                );
                addressList.add(address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addressList;
    }

    public Address insert(Address address){
        Object [] in = {address.getaName(),address.getaPhone(),address.getAddress(),address.getuId()};
        String sql = "insert into address(aName,aPhone,address,uId) values(?,?,?,?);";
        int count = 0;
        count = DBUtil.executeUpdate(sql,in);
        if(count>0){
            return address;
        }else{
            return null;
        }
    }

    public boolean update(Address address){
        Object [] in = {address.getaName(),address.getaPhone(),address.getAddress(),address.getuId(),address.getaId()};
        String sql = "update address set aName=?,aPhone=?,address=? where uId = ? and aId = ?;";
        return curr(sql,in);
    }

    public boolean delete(int aId,int uId){
        Object [] in = {aId,uId};
        String sql = "delete from address where aId = ? and uId =?;";
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
