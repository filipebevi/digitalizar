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

public class TipoDocumento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String descricao;

    @ManyToOne
    private Empresa empresa;

    @Column(name = "campo_valor")
    private Boolean campoValor;

    @Column(name = "campo_vencimento")
    private Boolean campoVencimento;

    @Column(name = "campo_periodo")
    private Boolean campoPeriodo;

    @Column(name = "campo_competencia")
    private Boolean campoCompetencia;

    @Column(name = "campo_numero")
    private Boolean campoNumero;

    @Column(name = "campo_entidade")
    private Boolean campoEntidade;

    @Column(name = "vinculado")
    private Boolean vinculado;

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

   

    public Boolean getCampoNumero() {
        return campoNumero;
    }

    public void setCampoNumero(Boolean campoNumero) {
        this.campoNumero = campoNumero;
    }

   

    public Boolean getCampoCompetencia() {
        return campoCompetencia;
    }

    public void setCampoCompetencia(Boolean campoCompetencia) {
        this.campoCompetencia = campoCompetencia;
    }

    public Boolean getVinculado() {
        return vinculado;
    }

    public void setVinculado(Boolean vinculado) {
        this.vinculado = vinculado;
    }

    public Boolean getCampoEntidade() {
        return campoEntidade;
    }

    public void setCampoEntidade(Boolean campoEntidade) {
        this.campoEntidade = campoEntidade;
    }

    public Boolean getCampoPeriodo() {
        return campoPeriodo;
    }

    public void setCampoPeriodo(Boolean campoPeriodo) {
        this.campoPeriodo = campoPeriodo;
    }
    
    

    @Override
    public String toString() {
        return String.format("%s[id=%d]", getClass().getSimpleName(), getId());
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.descricao);
        hash = 67 * hash + Objects.hashCode(this.empresa);
        hash = 67 * hash + Objects.hashCode(this.campoValor);
        hash = 67 * hash + Objects.hashCode(this.campoVencimento);
        hash = 67 * hash + Objects.hashCode(this.campoPeriodo);
        hash = 67 * hash + Objects.hashCode(this.campoCompetencia);
        hash = 67 * hash + Objects.hashCode(this.campoNumero);
        hash = 67 * hash + Objects.hashCode(this.campoEntidade);
        hash = 67 * hash + Objects.hashCode(this.vinculado);
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
        if (!Objects.equals(this.campoPeriodo, other.campoPeriodo)) {
            return false;
        }
        if (!Objects.equals(this.campoCompetencia, other.campoCompetencia)) {
            return false;
        }
        if (!Objects.equals(this.campoNumero, other.campoNumero)) {
            return false;
        }
        if (!Objects.equals(this.campoEntidade, other.campoEntidade)) {
            return false;
        }
        if (!Objects.equals(this.vinculado, other.vinculado)) {
            return false;
        }
        return true;
    }
    
    

}
