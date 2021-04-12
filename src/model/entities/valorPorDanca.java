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
public class valorPorDanca implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private dancas dancaDesc;
    private String mes_ano;;
    private Double lucroDanca;
    private Double DespesasDanca;
    private Double LucroTotal;

   
    
    public valorPorDanca(){
        
    }

    public valorPorDanca(dancas dancaDesc, String mes_ano, Double lucroDanca, Double DespesasDanca, Double LucroTotal) {
        this.dancaDesc = dancaDesc;
        this.mes_ano = mes_ano;
        this.lucroDanca = lucroDanca;
        this.DespesasDanca = DespesasDanca;
        this.LucroTotal = LucroTotal;
    }

    public dancas getDancaDesc() {
        return dancaDesc;
    }

    public void setDancaDesc(dancas dancaDesc) {
        this.dancaDesc = dancaDesc;
    }

    public String getMes_ano() {
        return mes_ano;
    }

    public void setMes_ano(String mes_ano) {
        this.mes_ano = mes_ano;
    }

    public Double getLucroDanca() {
        return lucroDanca;
    }

    public void setLucroDanca(Double lucroDanca) {
        this.lucroDanca = lucroDanca;
    }

    public Double getDespesasDanca() {
        return DespesasDanca;
    }

    public void setDespesasDanca(Double DespesasDanca) {
        this.DespesasDanca = DespesasDanca;
    }

    public Double getLucroTotal() {
        return LucroTotal;
    }

    public void setLucroTotal(Double LucroTotal) {
        this.LucroTotal = LucroTotal;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.dancaDesc);
        hash = 53 * hash + Objects.hashCode(this.mes_ano);
        hash = 53 * hash + Objects.hashCode(this.lucroDanca);
        hash = 53 * hash + Objects.hashCode(this.DespesasDanca);
        hash = 53 * hash + Objects.hashCode(this.LucroTotal);
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
        final valorPorDanca other = (valorPorDanca) obj;
        if (!Objects.equals(this.dancaDesc, other.dancaDesc)) {
            return false;
        }
        if (!Objects.equals(this.mes_ano, other.mes_ano)) {
            return false;
        }
        if (!Objects.equals(this.lucroDanca, other.lucroDanca)) {
            return false;
        }
        if (!Objects.equals(this.DespesasDanca, other.DespesasDanca)) {
            return false;
        }
        if (!Objects.equals(this.LucroTotal, other.LucroTotal)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "valorPorDanca " + "dancaDesc=" + dancaDesc.getDescricao() + ", mes_ano=" + mes_ano + ", lucroDanca=" + lucroDanca + ", DespesasDanca=" + DespesasDanca + ", LucroTotal=" + LucroTotal + '}';
    }

    

   
}
    

   