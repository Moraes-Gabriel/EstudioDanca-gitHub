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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.dao.usuarioDAO;
import model.entities.dancas;
import model.entities.usuario;

/**
 *
 * @author Cleiton
 */
public class UsuarioDaoJDBC implements usuarioDAO {
    
     private Connection conn;
    
    public UsuarioDaoJDBC(Connection connection) {
       conn = connection;
    }

    @Override
    public void create(usuario obj) {
        PreparedStatement st = null;
        
         try {
             st = conn.prepareStatement(
                         "INSERT INTO usuario "
                           + "(Nome,IdDanca,Idade,CPF,Sexo) "
                             + "VALUES "
                             + "(?, ?, ?, ?,?)",
                            java.sql.Statement.RETURN_GENERATED_KEYS);
             
                 st.setString(1, obj.getNome());
                 st.setInt(2, obj.getDanca().getId());
                 st.setDate(3, new java.sql.Date(obj.getIdade().getTime()));
                 st.setString(4, obj.getCpf());
                 st.setString(5, obj.getSexo());
                
                 
                 
                 st.executeUpdate();
             
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "erro ao criar a professora: "+ex);
         }
      
       
    }

    @Override
    public void update(usuario obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public usuario findByNome(String Nome) {
       PreparedStatement st = null;
        ResultSet rs = null;
        
          try {
              st = conn.prepareStatement(
                      
                      "SELECT * FROM usuario WHERE Nome = ?");
                      
              st.setString(1, Nome);
              
              rs = st.executeQuery();
              
              if (rs.next()) {
                  usuario obj = new usuario();
                  
                  obj.setId(rs.getInt("id"));
                  
                  return obj;
              }
              
              
                    
                      } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"problema ao procurar id pela descricao dance" +ex);
          }finally{
              connection.connectionFactory.closeStatment(st);
              connection.connectionFactory.closeResultSet(rs);
          }
          return null;
                
    }

    @Override
    public List<usuario> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
