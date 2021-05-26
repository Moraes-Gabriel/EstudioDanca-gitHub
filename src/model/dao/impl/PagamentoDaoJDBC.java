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


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.dao.pagamentosDAO;
import model.entities.valoresMeA;
import model.entities.clientes;
import model.entities.dancas;
import model.entities.pagamentos;
import model.entities.valorPorDanca;

/**
 *
 * @author Cleiton
 */
public class PagamentoDaoJDBC implements pagamentosDAO {
    
      private Connection conn;
    
    public PagamentoDaoJDBC(Connection connection) {
       conn = connection;
    }


    @Override
    public void create(pagamentos obj) {
        PreparedStatement st = null;
          try {
              st = conn.prepareStatement(
                      
                    "INSERT INTO pagamentos "
                  +"(IdCliente,IdDanca,Valor,DataPagamento,DataProxPag) "
                  + "VALUES "
                  + "(?, ?, ?, ?,?)",
                    java.sql.Statement.RETURN_GENERATED_KEYS);
                      
                     st.setInt(1, obj.getClientes().getId());
                    st.setInt(2, obj.getDancas().getId());
                    st.setDouble(3, obj.getValor());
                    st.setDate(4, new java.sql.Date(obj.getDataPagamento().getTime()));
                    st.setDate(5,new java.sql.Date(obj.getDataProxPag().getTime()));
                   
                    
                      st.executeUpdate();
          } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null,"Erro ao criar o pagamento" +ex);
          }
    }
    
    @Override
    public void update(pagamentos obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteById(Integer id) {
      
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "DELETE * FROM pagamentos WHERE IdCliente = ?");
            
              st.setInt(1, id);
              
              st.executeUpdate();
              
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erro ao deletar um pagamento byId"  +e);
        }
    }
    @Override
    public List<pagamentos> findAll() {
         
        PreparedStatement st = null;
        ResultSet rs = null;
                
          try {
              st = conn.prepareStatement(
                      "SELECT pagamentos.*, clientes.Nome, dancas.Descricao FROM pagamentos inner join clientes on pagamentos.IdCliente=clientes.id \n" +
                        "inner JOIN dancas ON pagamentos.IdDanca=dancas.id " );
                      
             
              rs = st.executeQuery();
            List<pagamentos> list = new ArrayList<>();
            
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
                                
                 pagamentos obj = InstantiatePagamento(rs, cli, dan);
                 list.add(obj);
            }
             return list; 
          } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null, "erro ao findall pagamento "+ex);
          }
          return null;
    }
    @Override
    public List<pagamentos> dataProxPag(clientes clintes) {
          
        PreparedStatement st = null;
        ResultSet rs = null;
                
          try {
              st = conn.prepareStatement(
                    	"SELECT pag.*, clientes.Nome, dancas.Descricao "
			+"FROM pagamentos pag  "
			+"inner join clientes on pag.IdCliente=clientes.id " 
			+"inner JOIN dancas ON pag.IdDanca=dancas.id "  
			+"WHERE pag.IdCliente = ?");
                      
             st.setInt(1, clintes.getId());
             
              rs = st.executeQuery();
            List<pagamentos> list = new ArrayList<>();
            
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
                                
                 pagamentos obj = InstantiatePagamento(rs, cli, dan);
                 list.add(obj);
            }
        return list;
        
    }     catch (SQLException ex) {
              JOptionPane.showMessageDialog(null, "Erro ao procurar a proxDataPag"+ex);
          }
          return null;
    }
   
     
    @Override
    public List<pagamentos> findForIdCliente(clientes cliente) {
        PreparedStatement st= null;
        ResultSet rs = null;
        
        try {
            st = conn.prepareStatement(
            
            "SELECT pagamentos.*, clientes.Nome, dancas.Descricao FROM pagamentos inner join clientes on pagamentos.IdCliente=clientes.id \n" +
                        "inner JOIN dancas ON pagamentos.IdDanca=dancas.id WHERE IdCliente = ? "
            );
            
            st.setInt(1, cliente.getId());
            
            rs = st.executeQuery();
            List<pagamentos> list = new ArrayList<>();
            
             Map<Integer, clientes> mapC = new HashMap<>();
             Map<String, dancas> mapD = new HashMap<>();
            
            while(rs.next()){
                
                  dancas dan = mapD.get(rs.getString("Descricao"));
                clientes cli = mapC.get(rs.getInt("IdCliente"));
              
                               if (cli == null) {
				cli = InstantiateClientes(rs);
				mapC.put(rs.getInt("IdCliente"), cli);
					}   
				if (dan == null) {
				dan = InstantiateDancas(rs);
				
					}
                
                pagamentos obj = InstantiatePagamento(rs, cli, dan);
                list.add(obj);
            }
                return list;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao procurar a dança pelo id "+e);
        }
          return null;
    }
      @Override
    public List<valorPorDanca> valorTotalDasDanças(Integer mes, Integer ano) {
            
       PreparedStatement st = null;
       ResultSet rs = null;
       
          try {
              st = conn.prepareStatement(
                      
               


		"SELECT CONCAT(CONVERT(MONTHNAME(pag.dataPagamento), CHAR) , '/' , "
		+"CONVERT(year(pag.dataPagamento), CHAR)) as mes_ano, "
                +"dan.Descricao, "
                +" SUM(pag.Valor) AS LucroDancas, "
                +"AM.valorTotal AS DespesasDanca, "
		+"SUM(pag.Valor) - AM.valorTotal AS LucroTotal "
		+"FROM pagamentos pag "
		+"INNER JOIN danca.dancas dan ON pag.IdDanca = dan.id " 
                +"INNER JOIN aulasmensais AM ON pag.IdDanca = AM.idDanca "
		+"WHERE MONTH(pag.DataPagamento) = ? AND YEAR(pag.DataPagamento) = ? "
		+"GROUP BY pag.IdDanca, dan.Descricao ");


		
              
              
              
                st.setInt(1, mes);
                st.setInt(2, ano);
                
                rs = st.executeQuery();
                
             List<valorPorDanca> list = new ArrayList<>();
              Map<String, dancas> mapDesc = new HashMap<>();
              
               while(rs.next()){
                    dancas danDesc = mapDesc.get(rs.getString("Descricao"));
                     if (danDesc == null) {
			danDesc = InstantiateDancas(rs);
			mapDesc.put(rs.getString("Descricao"), danDesc);
                     }
                     
                   valorPorDanca vm = InstantiateValorPerDanca(rs, danDesc);
                   
                 
                  list.add(vm);
                   
               
                  
               }
               return list;
          } catch (SQLException ex) {
             JOptionPane.showConfirmDialog(null, "erro ao pegar o lucro Total " +ex);
                  }
          return null;
    }
    
    
    
    
    
        
    
    
    
    
    
    private pagamentos InstantiatePagamento(ResultSet rs, clientes clientes, dancas dancas) throws SQLException{
        
         pagamentos obj = new pagamentos();
         
         
         obj.setId(rs.getInt("id"));
         obj.setDataPagamento(rs.getDate("DataPagamento"));
         obj.setValor(rs.getDouble("Valor"));
         obj.setDataProxPag(rs.getDate("DataProxPag"));
         
         
         obj.setClientes(clientes);
         obj.setDancas(dancas);
         
        return obj;
    }
    private clientes InstantiateClientes(ResultSet rs) throws SQLException{
        
        clientes cli = new clientes();
        
        cli.setId(rs.getInt("IdCliente"));
        
        return cli;
    }
    private dancas InstantiateDancas(ResultSet rs) throws SQLException{
      
      dancas dan = new dancas();
       
      
        dan.setDescricao(rs.getString("Descricao"));
        
       
        return dan;
}
    private valorPorDanca InstantiateValorPerDanca(ResultSet rs, dancas danDesc) throws SQLException{
    
      valorPorDanca vd = new valorPorDanca();
      
       
        vd.setMes_ano(rs.getString("mes_ano"));
        vd.setDancaDesc(danDesc);
        vd.setLucroDanca(rs.getDouble("LucroDancas"));
        vd.setDespesasDanca(rs.getDouble("DespesasDanca"));
        vd.setLucroTotal(rs.getDouble("LucroTotal"));
       
        return vd;
}
}