/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.entities.clientes;
import model.entities.dancas;

/**
 *
 * @author Cleiton
 */
public interface clientesDAO  {
    
        void create(clientes obj);
	void update(clientes obj);
	void deleteById(Integer id);
	clientes findByNome(String Nome);
	List<clientes> findAll();
        List<clientes> findByDancas(dancas dancas);
       
     
	
    
}
