/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Cleiton
 */
public class connectionFactory {
    
    private static final   String DRIVER ="com.mysql.jdbc:Driver";
    private static final String URL = "jdbc:mysql://localhost/danca";
    private static final String USER = "root";
    private static final String PASS = "1234";
    
    public static Connection getConnection(){
        try {
        
          //  Class.forName(DRIVER);
          Connection conexao = DriverManager.getConnection(URL,USER,PASS);
        
            
            return conexao;
        } catch (SQLException ex) {
            throw new RuntimeException("Error na conexao: ",ex);
        }
    }
    public static void closeConnection(Connection con){
  
            try {
                   if(con != null){
                con.close();
                   }
            } catch (SQLException ex) {
                Logger.getLogger(connectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
         public static void closeStatment(PreparedStatement st){
   
            try {
                   if(st != null){
                st.close();
                   }
            } catch (SQLException ex) {
                Logger.getLogger(connectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         

     public static void closeResultSet(ResultSet rs){
     
            try {
                   if(rs != null){
                rs.close();
                   }
            } catch (SQLException ex) {
                Logger.getLogger(connectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}
    

