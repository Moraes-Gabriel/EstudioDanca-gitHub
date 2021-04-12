/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.dao.aulasMensaisDAO;
import model.entities.aulasMensais;
import model.entities.pagamentos;

/**
 *
 * @author Cleiton
 */
public class aulasMensaisJDBC implements aulasMensaisDAO {
    
     
     private Connection conn;
    
    public aulasMensaisJDBC(Connection connection) {
       conn = connection;
    }

    @Override
    public void create(aulasMensais obj) {
        PreparedStatement st = null;
        
        try {
            
            st = conn.prepareStatement(
            
            "INSERT into aulasMensais "
            + "(idProfessora,idDanca,Valor_Por_Hora,Valor_Da_Passagem,AulasMensais,valorTotal)"
            + "VALUES "
            + "(?,?,?,?,?,?)",
            java.sql.Statement.RETURN_GENERATED_KEYS);
            
            st.setInt(1, obj.getUsuario().getId());
            st.setInt(2, obj.getDanca().getId());
            st.setDouble(3, obj.getValorPorHora());
            st.setDouble(4, obj.getValorDaPassagem());
            st.setInt(5, obj.getAulasMensais());
            st.setDouble(6, obj.getValorTotal());
            
            st.executeUpdate();
            
            
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "erro ao criar as aulasMensais"+e);
        }finally{
            connection.connectionFactory.closeStatment(st);
        }
        
    }

    @Override
    public void update() {
      PreparedStatement st = null;
              
         try {
             st = conn.prepareStatement(
                     
                     "UPDATE aulasmensais AM "
                     +"SET valorTotal = ((AM.Valor_Por_Hora * AM.aulasMensais) + AM.Valor_Da_Passagem) "
                     
             );
             
               st.executeUpdate();
         } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro ao update aulasMenSais"+ex);
         }
              
                
    }

    @Override
    public void deleteById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<pagamentos> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
}
