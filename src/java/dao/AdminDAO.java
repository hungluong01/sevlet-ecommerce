/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Admin;

/**
 *
 * @author ToanPham
 */
public class AdminDAO extends DBContext {
    public Admin getAdmin(String username, String password) throws SQLException {
        String sql = "SELECT * FROM Admin WHERE Username=? AND Password=?;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, username);
        statement.setString(2, password);
        ResultSet rs = statement.executeQuery();
        
        while (rs.next()) {
            return new Admin(rs.getString("Username"), rs.getString("Password"), rs.getString("Fullname"));
            
        }
        
        return null;
    }
    public Admin getAdmin(String username) throws SQLException {
        String sql = "SELECT * FROM Admin WHERE Username=?;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, username);
        ResultSet rs = statement.executeQuery();
        
        while (rs.next()) {
            return new Admin(rs.getString("Username"), rs.getString("Password"), rs.getString("Fullname"));
            
        }
        
        return null;
    }
}
