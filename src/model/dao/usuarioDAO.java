/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.entities.clientes;
import model.entities.usuario;

/**
 *
 * @author Cleiton
 */
public interface usuarioDAO {
    
    void create(usuario obj);
	void update(usuario obj);
	void deleteById(Integer id);
	usuario findByNome(String Nome);
	List<usuario> findAll();
}
