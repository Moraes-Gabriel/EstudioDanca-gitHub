/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.dao.matriculaDAO;
import model.entities.clientes;
import model.entities.dancas;
import model.entities.matricula;
import model.entities.pagamentos;

/**
 *
 * @author Cleiton
 */
public class MatriculaDaoJDBC implements matriculaDAO{
    
      private Connection conn;
    private Object java;
    
    public MatriculaDaoJDBC(Connection connection) {
       conn = connection;
    }

    @Override
    public void create(matricula obj) {
        
      
       
        PreparedStatement st = null;
   
        
        try {
            st = conn.prepareStatement(
                 "INSERT INTO matricula "
                  +"(IdCliente,IdDanca,Data,Valor) "
                  + "VALUES "
                  + "(?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            
                    st.setInt(1, obj.getClientes().getId());
                    st.setInt(2, obj.getDancas().getId());
                    st.setDate(3, new java.sql.Date(obj.getData().getTime()));
                    st.setDouble(4, obj.getValor());
                   
               
                 st.executeUpdate();
                
               
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro ao criar a matricula "+e);
        }
     finally{
            connection.connectionFactory.closeStatment(st);
           
            
    }   
    }

    @Override
    public void update(matricula obj) {
        
        PreparedStatement st = null;
        clientes cli = new clientes();
          try {
              st = conn.prepareStatement(
                      "UPDATE matricula "
                     +"SET Data = ? "
                     +"WHERE IdCliente = ? AND IdDanca = ? "
                       );
                      
              st.setDate(1, new java.sql.Date(obj.getData().getTime()));
              st.setInt(2 , obj.getClientes().getId());
              st.setInt(3, obj.getDancas().getId());
              
                   st.executeUpdate();
              
          } catch (SQLException ex) {
              Logger.getLogger(MatriculaDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

    @Override
    public void deleteById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public matricula findByDanca(String danca) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<matricula> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT matricula.*, clientes.Nome, dancas.Descricao FROM matricula inner join clientes on matricula.IdCliente=clientes.id \n" +
                        "inner JOIN dancas ON matricula.IdDanca=dancas.id ORDER BY DATA"
            );
            rs = st.executeQuery();
            List<matricula> list = new ArrayList<>();
            
             Map<Integer, clientes> mapC = new HashMap<>();
             Map<Integer, dancas> mapD = new HashMap<>();
            while(rs.next()){
               
                dancas dan = mapD.get(rs.getInt("IdDanca"));
                clientes cli = mapC.get(rs.getInt("IdCliente"));
              
                               if (cli == null) {
				cli = InstantiateClientes(rs);
				mapC.put(rs.getInt("IdCliente"), cli);
					}   
				if (dan == null) {
				dan = InstantiateDancas(rs);
				mapD.put(rs.getInt("IdDanca"), dan);
					}
                                
                 matricula obj = InstantiateMatricula(rs, cli, dan);
                 list.add(obj);
            }
          return list;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro ao selecionar o findall "+e);
        }finally{
            connection.connectionFactory.closeResultSet(rs);
            connection.connectionFactory.closeStatment(st);
        }
          return null;
    }

    @Override
    public List<matricula> findByDancas(dancas dancas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<matricula> FindDancasDoAlunoForId(clientes cliente) {
      PreparedStatement st= null;
        ResultSet rs = null;
        
        try {
            st = conn.prepareStatement(
            
           		"SELECT mat.*,dan.Descricao\n" +
"		 FROM matricula mat \n" +
"		 inner join danca.dancas dan ON dan.id = mat.IdDanca\n" +
"		 WHERE mat.IdCliente = ?"
            );
            
            st.setInt(1, cliente.getId());
            
            rs = st.executeQuery();
            List<matricula> list = new ArrayList<>();
            
             Map<Integer, clientes> mapC = new HashMap<>();
             Map<Integer, dancas> mapD = new HashMap<>();
        
            
            while(rs.next()){
                
               
                  dancas dan = mapD.get(rs.getInt("IdDanca"));
                clientes cli = mapC.get(rs.getInt("IdCliente"));
              
                               if (cli == null) {
				cli = InstantiateClientes(rs);
				mapC.put(rs.getInt("IdCliente"), cli);
					}   
				if (dan == null) {
				dan = InstantiateDancas(rs);
				mapD.put(rs.getInt("IdDanca"), dan);
					}
                                
                
                matricula obj = InstantiateMatricula(rs, cli, dan);
                list.add(obj);
            }
                return list;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro ao procurar pelo dancasPeloAluno "+e);
        }
          return null;

    
    }
    
    @Override
    public matricula FindProxPagForIdCliIdDan(clientes cliente, dancas danca) {
    PreparedStatement st= null;
        ResultSet rs = null;
        
        try {
            st = conn.prepareStatement(
            
           		"SELECT Valor, DataProxPag\n" +
                        " FROM matricula mat\n" +
                        " WHERE mat.IdCliente = ? AND mat.IdDanca = ?"
            );
            
         st.setInt(1, cliente.getId());
         st.setInt(2, danca.getId());
            
            rs = st.executeQuery();
            
            
            if(rs.next()){
                
                matricula obj = new matricula();
                
                obj.setClientes(cliente);
                 obj.setValor(rs.getDouble("Valor"));
                 
                 
                 return obj;
            }
               
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro ao procurar pelo prox data pelo aluno "+e);
        }
          return null;

    
    }







private matricula InstantiateMatricula(ResultSet rs, clientes clientes, dancas dancas) throws SQLException{
        
         matricula obj = new matricula();
         matricula FindDataProxPag = new matricula();
         
          
         obj.setId(rs.getInt("id"));
         obj.setClientes(clientes);
         obj.setDancas(dancas);
         obj.setData(rs.getDate("Data"));
         obj.setValor(rs.getDouble("Valor"));
         
         
         
         FindDataProxPag.setValor(rs.getDouble("Valor"));
        
        
        return obj;
       
    }
    private clientes InstantiateClientes(ResultSet rs) throws SQLException{
        
        clientes cli = new clientes();
        
        cli.setId(rs.getInt("IdCliente"));
        
        return cli;
    }
    private dancas InstantiateDancas(ResultSet rs) throws SQLException{
      
      dancas dan = new dancas();
       
        dan.setId(rs.getInt("IdDanca"));
        dan.setDescricao(rs.getString("Descricao"));
      
        
       
        return dan;
}

    
    

 
}