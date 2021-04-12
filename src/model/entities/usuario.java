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
public class usuario implements Serializable{
    
     private Integer id;
    private String nome;
    private dancas danca;
     private Date idade;
    private String cpf;
    private String sexo;

    public usuario(Integer id) {
        this.id = id;
    }

    public usuario() {
    }
    
    

    public usuario(Integer id, String nome, dancas danca, Date idade, String cpf, String sexo) {
        this.id = id;
        this.nome = nome;
        this.danca = danca;
        this.idade = idade;
        this.cpf = cpf;
        this.sexo = sexo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public dancas getDanca() {
        return danca;
    }

    public void setDanca(dancas danca) {
        this.danca = danca;
    }

    public Date getIdade() {
        return idade;
    }

    public void setIdade(Date idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.nome);
        hash = 67 * hash + Objects.hashCode(this.danca);
        hash = 67 * hash + Objects.hashCode(this.idade);
        hash = 67 * hash + Objects.hashCode(this.cpf);
        hash = 67 * hash + Objects.hashCode(this.sexo);
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
        final usuario other = (usuario) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.sexo, other.sexo)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.danca, other.danca)) {
            return false;
        }
        if (!Objects.equals(this.idade, other.idade)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "usuario{" + "id=" + id + ", nome=" + nome + ", danca=" + danca + ", idade=" + idade + ", cpf=" + cpf + ", sexo=" + sexo + '}';
    }
   
 
    
}
