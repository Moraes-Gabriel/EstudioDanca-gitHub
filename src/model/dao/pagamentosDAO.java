/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;



import java.util.List;
import model.entities.valorPorDanca;
import model.entities.clientes;
import model.entities.dancas;
import model.entities.pagamentos;

/**
 *
 * @author Cleiton
 */
public interface pagamentosDAO {
    
        void create(pagamentos obj);
	void update(pagamentos obj);
	void deleteById(Integer id);
        List<pagamentos> findAll();
        List<pagamentos> findForIdCliente(clientes cliente);
        List<valorPorDanca> valorTotalDasDanças(Integer mes, Integer Ano);
        List<pagamentos> dataProxPag(clientes clientes);
        
       
}
