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
public class OrderDetailDAO extends DBContext {
    public void add(int orderID, int productID, int quantity, int sizeID) throws SQLException {
        String sql = "INSERT INTO OrderDetail VALUES (?, ?, ?, ?);";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, orderID);
        statement.setInt(2, productID);
        statement.setInt(3, quantity);
        statement.setInt(4, sizeID);
        statement.executeUpdate();
    }
}