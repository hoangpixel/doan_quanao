/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author Vinh
 */
public class DBConnect {
    
     public static Connection getConnection() {
        Connection conn = null;
        try {
            String user = "root";
            String pass = "";
            String url = "jdbc:mysql://localhost:3306/java_quanao";
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn =  DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi kết nối cơ sở dữ liệu!\n",
                    "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        return conn;
     }
     
     public static void closeConnection(Connection conn) {
        try {
            if (conn != null && !conn.isClosed())
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
