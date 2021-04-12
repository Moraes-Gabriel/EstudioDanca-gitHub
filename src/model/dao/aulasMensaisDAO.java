/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.entities.aulasMensais;
import model.entities.pagamentos;

/**
 *
 * @author Cleiton
 */
public interface aulasMensaisDAO {
    
    
      void create(aulasMensais obj);
	void update();
	void deleteById(Integer id);
        List<pagamentos> findAll();
}
