/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import hotelpossystem.dao.DatabaseConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jingshiqing
 */
public class NewClass {
     public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO code application logic here
        String url = "jdbc:my://localhost:1527/pos";
        String user = "app"; 
        String pwd = "missjing";
      // ResultSet rs;
    //Connection conn;
         try(
            Connection conn = new DatabaseConnection().getConnection();
            Statement state = conn.createStatement();
            ResultSet rs = state.executeQuery("select * from room") ){
            while(rs.next()) {
             System.out.println("h");
         }
        
         
         
}
    }
}
    
  

