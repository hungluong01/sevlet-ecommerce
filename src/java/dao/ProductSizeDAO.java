/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ToanPham
 */
public class ProductSizeDAO extends DBContext {
    public void add(int productID, int sizeID) throws SQLException {
        String sql = "INSERT INTO ProductSize VALUES (?, ?);";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, productID);
        statement.setInt(2, sizeID);
        statement.executeUpdate();
    }
    
    public void delete(int productID, int sizeID) throws SQLException {
        String sql = "DELETE FROM ProductSize WHERE ProductID=? AND SizeID=?;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, productID);
        statement.setInt(2, sizeID);
        statement.executeUpdate();
    }
}
