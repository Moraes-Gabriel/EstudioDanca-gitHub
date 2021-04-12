/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.entities.clientes;
import model.entities.dancas;
import model.entities.matricula;

/**
 *
 * @author Cleiton
 */
public interface matriculaDAO {
    
       void create(matricula obj);
	void update(matricula obj);
	void deleteById(Integer id);
	matricula findByDanca(String danca);
        List<matricula> FindDancasDoAlunoForId(clientes cliente);
        matricula FindProxPagForIdCliIdDan(clientes cliente, dancas danca);
	List<matricula> findAll();
        List<matricula> findByDancas(dancas dancas);
}
