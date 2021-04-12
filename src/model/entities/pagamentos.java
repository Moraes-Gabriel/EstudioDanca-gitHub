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
public class pagamentos implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
     private Integer id;
    private Date dataPagamento;
    private Date DataProxPag;
    private Double valor;
 
    
    private clientes clientes;
    private dancas dancas;
    
    public pagamentos(){
        
    }

    public pagamentos(clientes clientes) {
        this.clientes = clientes;
    }

    public pagamentos(Integer id, Date dataPagamento, Date DataProxPag, Double valor, clientes clientes, dancas dancas) {
        this.id = id;
        this.dataPagamento = dataPagamento;
        this.DataProxPag = DataProxPag;
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

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
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

    public Date getDataProxPag() {
        return DataProxPag;
    }

    public void setDataProxPag(Date DataProxPag) {
        this.DataProxPag = DataProxPag;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.dataPagamento);
        hash = 17 * hash + Objects.hashCode(this.DataProxPag);
        hash = 17 * hash + Objects.hashCode(this.valor);
        hash = 17 * hash + Objects.hashCode(this.clientes);
        hash = 17 * hash + Objects.hashCode(this.dancas);
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
        final pagamentos other = (pagamentos) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.dataPagamento, other.dataPagamento)) {
            return false;
        }
        if (!Objects.equals(this.DataProxPag, other.DataProxPag)) {
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
        return "pagamentos{" + "id=" + id + ", dataPagamento=" + dataPagamento + ", DataProxPag=" + DataProxPag + ", valor=" + valor + ", clientes=" + clientes + ", dancas=" + dancas + '}';
    }

   
    
}
