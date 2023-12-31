/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.TrackItem;

/**
 *
 * @author ToanPham
 */
public class TrackItemDAO extends DBContext {
    public TrackItem getTrackItem(int orderID, String emailOrPhone) throws SQLException {
        String sql = "SELECT * FROM Customer JOIN [Order] ON Customer.CustomerID=[Order].CustomerID JOIN [Status] ON [Status].StatusID=[Order].StatusID WHERE [Order].OrderID=? AND (Customer.Email=? OR Customer.Phone=?);";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, orderID);
        statement.setString(2, emailOrPhone);
        statement.setString(3, emailOrPhone);
        
        ResultSet rs = statement.executeQuery();
        
        while (rs.next()) {
            return new TrackItem(rs.getInt("OrderID"), rs.getString("Fullname"), rs.getString("Address"), rs.getDate("CreatedDate"), rs.getString("Status"));
        }
        
        return null;
        
    }
    
    public ArrayList<TrackItem> getAll() throws SQLException {
        ArrayList<TrackItem> list = new ArrayList<>();
        String sql = "SELECT * FROM Customer JOIN [Order] ON Customer.CustomerID=[Order].CustomerID JOIN [Status] ON [Status].StatusID=[Order].StatusID ORDER BY CreatedDate DESC;";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        ResultSet rs = statement.executeQuery();
        
        while (rs.next()) {
            list.add(new TrackItem(rs.getInt("OrderID"), rs.getString("Fullname"), rs.getString("Address"), rs.getDate("CreatedDate"), rs.getString("Status")));
        }
        
        return list;
    }
}

