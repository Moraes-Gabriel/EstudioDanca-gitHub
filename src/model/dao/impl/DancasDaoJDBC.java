/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.dao.dancasDAO;
import model.entities.clientes;
import model.entities.dancas;

/**
 *
 * @author Cleiton
 */
public class DancasDaoJDBC implements dancasDAO {

      private Connection conn;
    
    public DancasDaoJDBC(Connection connection) {
       conn = connection;
    }

    @Override
    public void create(dancas obj) {
       
        PreparedStatement st = null;
        
        try {
            st = conn.prepareStatement(
           " INSERT INTO dancas (Descricao,Valor,Ativo) VALUES (?,?,?)"
            );
            
            st.setString(1, obj.getDescricao());
            st.setDouble(2, obj.getValor());
            st.setInt(3, obj.getAtivo());
            
            st.executeUpdate();
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erro ao salvar a dança " +e);
        }finally{
            connection.connectionFactory.closeStatment(st);
    }
    }
    
    @Override
    public void update(dancas obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
     public dancas findById(Integer id) {
         
          PreparedStatement st = null;
        ResultSet rs = null;
        
          try {
              st = conn.prepareStatement(
                      
                      "SELECT * FROM dancas WHERE id = ?");
                      
              st.setInt(1, id);
              
              rs = st.executeQuery();
              
              if (rs.next()) {
                  dancas obj = InstantiateDancas(rs);            
                  return obj;
              }
              
              
                    
                      } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"problema ao procurar pela FindById" +ex);
          }finally{
              connection.connectionFactory.closeStatment(st);
              connection.connectionFactory.closeResultSet(rs);
          }
          return null;
                
         
     }

    @Override
    public dancas findByDesc(String Desce) {
       
        PreparedStatement st = null;
        ResultSet rs = null;
        
          try {
              st = conn.prepareStatement(
                      
                      "SELECT * FROM dancas WHERE Descricao = ?");
                      
              st.setString(1, Desce);
              
              rs = st.executeQuery();
              
              if (rs.next()) {
                  dancas obj = new dancas();
                  
                  obj.setId(rs.getInt("id"));
                  
                  return obj;
              }
              
              
                    
                      } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"problema ao procurar id pela descricao dance " +ex);
          }finally{
              connection.connectionFactory.closeStatment(st);
              connection.connectionFactory.closeResultSet(rs);
          }
          return null;
                
    }

    @Override
    public List<dancas> findAll() {
         
        PreparedStatement st = null;
        ResultSet rs = null;
        
        
        try {
            st = conn.prepareStatement(
            "SELECT * FROM dancas ORDER BY Descricao"
            );
              
            rs = st.executeQuery();
            
            List<dancas> list = new ArrayList<>();
            while(rs.next()){
                
                dancas obj = InstantiateDancas(rs);
                
                list.add(obj);
            }
            return list;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erro ao listarall da danca" +e);
        }finally{
            connection.connectionFactory.closeStatment(st);
            connection.connectionFactory.closeResultSet(rs);
        }
        
        
          return null;
        
        
    }
      

    @Override
    public List<dancas> findByClientes(clientes clientes) {
          return null;
       
//        PreparedStatement st = null;
//        ResultSet rs = null;
//        
//        
//        try {
//            st = conn.prepareStatement(
//            "SELECT * FROM dancas ORDER BY NAME"
//            );
//              
//            rs = st.executeQuery();
//            
//            List<dancas> list = new ArrayList<>();
//            while(rs.next()){
//                
//                dancas obj = InstantiateDancas(rs);
//                
//                list.add(obj);
//            }
//        } catch (Exception e) {
//        }
//        
//        
//          return null;
//        
//        
//    }
    }
    
    
    private dancas InstantiateDancas(ResultSet rs) throws SQLException{
      
      dancas obj = new dancas();
       
         obj.setId(rs.getInt("ID"));
        obj.setDescricao(rs.getString("Descricao"));
        obj.setValor(rs.getDouble("Valor"));
        obj.setAtivo(rs.getInt("Ativo"));
      
        
        return obj;
        
 
   
}
}
