/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.connectionFactory;
import model.dao.impl.ClientesDaoJDBC;
import model.dao.impl.DancasDaoJDBC;
import model.dao.impl.MatriculaDaoJDBC;
import model.dao.impl.PagamentoDaoJDBC;
import model.dao.impl.UsuarioDaoJDBC;
import model.dao.impl.aulasMensaisJDBC;

/**
 *
 * @author Cleiton
 */
public class DaoFactory {
 
    
	public static clientesDAO createClientesDao() {
		
		return new ClientesDaoJDBC(connectionFactory.getConnection());
		
	}
        public static dancasDAO createDancasDao()  {
		
		return new DancasDaoJDBC(connectionFactory.getConnection());
		
	}
        public static matriculaDAO createMatriculaDao(){
            
            return new MatriculaDaoJDBC(connectionFactory.getConnection());
        }
        public static pagamentosDAO createPagamentoDao(){
            
            return new PagamentoDaoJDBC(connectionFactory.getConnection());
        }
         public static usuarioDAO createUsuarioDao(){
            
            return new UsuarioDaoJDBC(connectionFactory.getConnection());
        }
             public static aulasMensaisDAO createAulasMensaisDAO(){
            
            return new aulasMensaisJDBC(connectionFactory.getConnection());
        }
}
