/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.tipodocumento;

import com.digitalizar.empresa.Empresa;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author filip
 */

@Entity

public class TipoDocumento implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable=false) 
    private String descricao;
    
    @ManyToOne
    private Empresa empresa;
    
    @Column(name = "campo_valor")
    private Boolean campoValor;
    
    @Column(name = "campo_vencimento")
    private Boolean campoVencimento;
    
    @Column(name = "campo_data_inicio")
    private Boolean campoDataInicio;
    
    @Column(name = "campo_numero")
    private Boolean campoNumero;

    public TipoDocumento() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Boolean getCampoValor() {
        return campoValor;
    }

    public void setCampoValor(Boolean campoValor) {
        this.campoValor = campoValor;
    }

    public Boolean getCampoVencimento() {
        return campoVencimento;
    }

    public void setCampoVencimento(Boolean campoVencimento) {
        this.campoVencimento = campoVencimento;
    }

    public Boolean getCampoDataInicio() {
        return campoDataInicio;
    }

    public void setCampoDataInicio(Boolean campoDataInicio) {
        this.campoDataInicio = campoDataInicio;
    }

    public Boolean getCampoNumero() {
        return campoNumero;
    }

    public void setCampoNumero(Boolean campoNumero) {
        this.campoNumero = campoNumero;
    }
    
    
    
    @Override
    public String toString() {
        return String.format("%s[id=%d]", getClass().getSimpleName(), getId());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.id);
        hash = 43 * hash + Objects.hashCode(this.descricao);
        hash = 43 * hash + Objects.hashCode(this.empresa);
        hash = 43 * hash + Objects.hashCode(this.campoValor);
        hash = 43 * hash + Objects.hashCode(this.campoVencimento);
        hash = 43 * hash + Objects.hashCode(this.campoDataInicio);
        hash = 43 * hash + Objects.hashCode(this.campoNumero);
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
        final TipoDocumento other = (TipoDocumento) obj;
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.empresa, other.empresa)) {
            return false;
        }
        if (!Objects.equals(this.campoValor, other.campoValor)) {
            return false;
        }
        if (!Objects.equals(this.campoVencimento, other.campoVencimento)) {
            return false;
        }
        if (!Objects.equals(this.campoDataInicio, other.campoDataInicio)) {
            return false;
        }
        if (!Objects.equals(this.campoNumero, other.campoNumero)) {
            return false;
        }
        return true;
    }

    

    
    
    
    
}
