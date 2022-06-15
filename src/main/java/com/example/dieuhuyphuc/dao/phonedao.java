package com.example.dieuhuyphuc.dao;

import com.example.dieuhuyphuc.database.ConnecttionUtil;
import com.example.dieuhuyphuc.model.phone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class phonedao {


    Connection connection = ConnecttionUtil.getConnection();



    public List<phone> getListPhone() {
        List<phone> list = new ArrayList<>();
        String sql = "SELECT * FROM  phone";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                phone p = new phone();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setPrice(rs.getString("price"));
                p.setBrand(rs.getString("brand"));
                p.setDescription(rs.getString("decription"));
                list.add(p);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
    public String updatePhone(phone p){
        String sql="UPDATE product SET name = ?,price = ?, brand = ?, decription = ? WHERE id=?";
        try{
            PreparedStatement ps =  connection.prepareStatement(sql);
            ps.setString(1, p.getName());
            ps.setString(2, p.getPrice());
            ps.setString(3, p.getBrand());
            ps.setString(4, p.getDescription());
            int isSuccess=ps.executeUpdate();
            if(isSuccess>0){
                return"Success";
            }
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }
        return"Fail";
    }
    public String deleteUser(int id){
        String sql="DELETE FROM product WHERE id=?";
        try{
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setInt(1, id);
            int isSuccess=ps.executeUpdate();
            if(isSuccess>0){
                return"Success";
            }
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }
        return"Fail";
    }

    public String insertUser(phone p){
        String sql="INSERT INTO product(name,price,brand, description)VALUES(?,?,?,?)";
        try{
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setString(1, p.getName());
            ps.setString(2, p.getPrice());
            ps.setString(3, p.getBrand());
            ps.setString(4, p.getDescription());
            int isSuccess = ps.executeUpdate();
            if(isSuccess > 0){
                return "Success";
            }
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }
        return"Fail";
    }
}
