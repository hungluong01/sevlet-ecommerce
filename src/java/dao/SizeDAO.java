/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Size;

/**
 *
 * @author ToanPham
 */
public class SizeDAO extends DBContext {
    public ArrayList<Size> getSizesByProductID(int ID) throws SQLException {
        ArrayList<Size> sizeList = new ArrayList<>();
        String sql = "SELECT * FROM Size WHERE SizeID IN (SELECT SizeID FROM ProductSize WHERE ProductID=?);";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, ID);
        
        ResultSet rs = statement.executeQuery();
        
        while (rs.next()) {
            sizeList.add(new Size(rs.getInt("SizeID"), rs.getString("Size")));
        }
        
        return sizeList;
    }
    
    public ArrayList<Size> getAllSizes() throws SQLException {
        ArrayList<Size> sizeList = new ArrayList<>();
        String sql = "SELECT * FROM Size;";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        ResultSet rs = statement.executeQuery();
        
        while (rs.next()) {
            sizeList.add(new Size(rs.getInt("SizeID"), rs.getString("Size")));
        }
        
        return sizeList;
    }
    
    public Size getSizeByID(int ID) throws SQLException {
        String sql = "SELECT Size FROM Size WHERE SizeID=?;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, ID);
        
        ResultSet rs = statement.executeQuery();
        
        while (rs.next()) {
            return new Size(ID, rs.getString("Size"));
        }
        
        return null;
    }
}