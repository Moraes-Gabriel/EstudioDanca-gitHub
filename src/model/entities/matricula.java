/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Cleiton
 */
public class matricula implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private Date data;
    private Double valor;
   
    
    private clientes clientes;
    private dancas dancas;
    
    
    public matricula(){
        
    }

    public matricula(clientes clientes) {
        this.clientes = clientes;
    }

    public matricula(Date data, clientes clientes, dancas dancas) {
        this.data = data;
        this.clientes = clientes;
        this.dancas = dancas;
    }
    
    
    public matricula(Integer id, Date data, Double valor, Date DataProxPag, clientes clientes, dancas dancas) {
        this.id = id;
        this.data = data;
        this.valor = valor;
      
        this.clientes = clientes;
        this.dancas = dancas;
    }

    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    

    public clientes getClientes() {
        return clientes;
    }

    public void setClientes(clientes clientes) {
        this.clientes = clientes;
    }

    public dancas getDancas() {
        return dancas;
    }

    public void setDancas(dancas dancas) {
        this.dancas = dancas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.data);
        hash = 53 * hash + Objects.hashCode(this.valor);
     
        hash = 53 * hash + Objects.hashCode(this.clientes);
        hash = 53 * hash + Objects.hashCode(this.dancas);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final matricula other = (matricula) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (!Objects.equals(this.valor, other.valor)) {
            return false;
        }   
       
        if (!Objects.equals(this.clientes, other.clientes)) {
            return false;
        }
        if (!Objects.equals(this.dancas, other.dancas)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "matricula{" + "id=" + id + ", data=" + data + ", valor=" + valor +  ", clientes=" + clientes + ", dancas=" + dancas + '}';
    }

    public void setInt(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
