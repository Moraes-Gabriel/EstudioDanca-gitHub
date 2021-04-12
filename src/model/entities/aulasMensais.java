/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

import java.util.Objects;

/**
 *
 * @author Cleiton
 */
public class aulasMensais {
    
    private Integer id;
    private usuario usuario;
    private dancas danca;
     private Double valorPorHora;
    private Double valorDaPassagem;
    private Integer aulasMensais;
    private Double valorTotal;

    public aulasMensais(Integer id, usuario usuario, dancas danca, Double valorPorHora, Double valorDaPassagem, Integer aulasMensais, Double valorTotal) {
        this.id = id;
        this.usuario = usuario;
        this.danca = danca;
        this.valorPorHora = valorPorHora;
        this.valorDaPassagem = valorDaPassagem;
        this.aulasMensais = aulasMensais;
        this.valorTotal = valorTotal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(usuario usuario) {
        this.usuario = usuario;
    }

    public dancas getDanca() {
        return danca;
    }

    public void setDanca(dancas danca) {
        this.danca = danca;
    }

    public Double getValorPorHora() {
        return valorPorHora;
    }

    public void setValorPorHora(Double valorPorHora) {
        this.valorPorHora = valorPorHora;
    }

    public Double getValorDaPassagem() {
        return valorDaPassagem;
    }

    public void setValorDaPassagem(Double valorDaPassagem) {
        this.valorDaPassagem = valorDaPassagem;
    }

    public Integer getAulasMensais() {
        return aulasMensais;
    }

    public void setAulasMensais(Integer aulasMensais) {
        this.aulasMensais = aulasMensais;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.id);
        hash = 61 * hash + Objects.hashCode(this.usuario);
        hash = 61 * hash + Objects.hashCode(this.danca);
        hash = 61 * hash + Objects.hashCode(this.valorPorHora);
        hash = 61 * hash + Objects.hashCode(this.valorDaPassagem);
        hash = 61 * hash + Objects.hashCode(this.aulasMensais);
        hash = 61 * hash + Objects.hashCode(this.valorTotal);
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
        final aulasMensais other = (aulasMensais) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.danca, other.danca)) {
            return false;
        }
        if (!Objects.equals(this.valorPorHora, other.valorPorHora)) {
            return false;
        }
        if (!Objects.equals(this.valorDaPassagem, other.valorDaPassagem)) {
            return false;
        }
        if (!Objects.equals(this.aulasMensais, other.aulasMensais)) {
            return false;
        }
        if (!Objects.equals(this.valorTotal, other.valorTotal)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aulasMensais{" + "id=" + id + ", usuario=" + usuario + ", danca=" + danca + ", valorPorHora=" + valorPorHora + ", valorDaPassagem=" + valorDaPassagem + ", aulasMensais=" + aulasMensais + ", valorTotal=" + valorTotal + '}';
    }

    
}