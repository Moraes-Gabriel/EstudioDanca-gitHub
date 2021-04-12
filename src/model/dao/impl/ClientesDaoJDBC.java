/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.impl;

import connection.connectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.dao.clientesDAO;
import model.entities.clientes;
import model.entities.dancas;

/**
 *
 * @author Cleiton
 */
public class ClientesDaoJDBC implements clientesDAO{
    
      private Connection conn;
    
    public ClientesDaoJDBC(Connection connection) {
       conn = connection;
    }

    @Override
    public void create(clientes obj) {
        PreparedStatement st = null;
    
 
          try {
              st =  conn.prepareStatement("INSERT INTO clientes(nome,cpf,idade,sexo)VALUES(?,?,?,?)"
            );
                      
           
              
                st.setString(1, obj.getNome());
		st.setString(2, obj.getCpf());
		st.setDate(3, (Date) obj.getIdade());
                st.setString(4, obj.getSexo());
                            
                 st.executeUpdate();
                 
                      } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null, "Erro ao criar um cliente! Mensagem: "+ex.getMessage());
          }finally{
              connectionFactory.closeStatment(st);
          }
        
     
    }

    @Override
    public void update(clientes obj) {
     	PreparedStatement st = null;
		
	
		try {		
			
			st = conn.prepareStatement(
					"UPDATE seller "
					 + "SET Nome = ?, CPF = ?, idade = ?, sexo = ? "
					 + "WHERE Id = ?");
				
			st.setString(1, obj.getNome());
			st.setString(2, obj.getCpf());
			st.setDate(3, new java.sql.Date(obj.getIdade().getTime()));
			
						
			st.executeUpdate();
			
		}
		catch(SQLException e){
			JOptionPane.showMessageDialog(null, "erro ao update o cliente "+e);
		}finally{
			connectionFactory.closeStatment(st);
		}
	}

    
    public void deleteById(Integer id) {
     PreparedStatement st = null;
     
        try {
            st = conn.prepareStatement(
           
                    "DELETE FROM clientes WHERE id = ?"          
            );
             st.setInt(1, id);
                    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null," erro ao deletar o cliente "+e);
        }
    finally{
             connectionFactory.closeStatment(st);
}
    }

    

    @Override
    public List<clientes> findAll() {
       
        PreparedStatement st = null;
        ResultSet rs = null;
        
        try {
            
       
        st = conn.prepareStatement(
        
               "SELECT * FROM clientes ORDER BY Nome" );
                
               rs = st.executeQuery();
               
               List<clientes> list = new ArrayList<clientes>();
        
               while(rs.next()){
                   
                   clientes obj = InstantiateClientes(rs);
                   
                   list.add(obj);
                   
               }
                    return list;   
                       
                     
                       
               
                       
    }catch (Exception e) {
        JOptionPane.showMessageDialog(null, "erro ao findAll"+e);
        }finally{
            connection.connectionFactory.closeStatment(st);
            connection.connectionFactory.closeResultSet(rs);
        }
          return null;
    } 
    
    @Override
    public List<clientes> findByDancas(dancas dancas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    
    
    private clientes InstantiateClientes(ResultSet rs) throws SQLException{
        
        clientes obj = new clientes();
        
        obj.setId(rs.getInt("id"));
        obj.setNome(rs.getString("Nome"));
        obj.setCpf(rs.getString("CPF"));
        obj.setIdade(rs.getDate("Idade"));
        obj.setSexo(rs.getString("Sexo"));
        
        return obj;
        
 
   
    
    
    }

    @Override
    public clientes findByNome(String Nome) {
        
        PreparedStatement st = null;
        ResultSet rs = null;
        
          try {
              st = conn.prepareStatement(
                      
                      "SELECT * FROM clientes WHERE Nome = ?");
              
              st.setString(1, Nome);
              rs = st.executeQuery();
              
              if (rs.next()) {
                  clientes obj = new clientes();
                  
                  obj.setId(rs.getInt("id"));
                  obj.setCpf(rs.getString("Cpf"));
                  obj.setIdade(rs.getDate("Idade"));
                  obj.setSexo(rs.getString("Sexo"));
                  
                  return obj;
              }
             
          } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro ao procurar um cliente pelo Nome"+ex);
          }
                
        
                
          return null;
        
    }
}
