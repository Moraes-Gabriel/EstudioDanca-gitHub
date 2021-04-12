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
public interface dancasDAO {
    
        void create(dancas obj);
	void update(dancas obj);
	void deleteById(Integer id);
	dancas findById(Integer id);
        dancas findByDesc(String Desce);
	List<dancas> findAll();
        List<dancas> findByClientes(clientes clientes);
}
