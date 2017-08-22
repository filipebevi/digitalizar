/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.documento;

import com.digitalizar.empresa.Empresa;
import com.digitalizar.entidade.Entidade;
import com.digitalizar.tipodocumento.TipoDocumento;
import com.digitalizar.usuario.Usuario;
import java.io.File;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author filip
 */
@SuppressWarnings("serial")
@Entity
public class Documento implements Serializable{
    @Id
    @GeneratedValue
    private Integer id;
    
    @Temporal(TemporalType.DATE)
    private Calendar data_inclusao;
    
    @ManyToOne
    private Usuario usuario_inclusao;
    
    @ManyToOne
    private Usuario usuario_aprovacao;
    
    @Temporal(TemporalType.DATE)
    private Calendar data_aprovacao;
    
    private File arquivo;
    
    @ManyToOne
    private Empresa empresa;
    
    @ManyToOne
    private TipoDocumento tipo_documento;
    
    private String descricao;
    
    @Temporal(TemporalType.DATE)
    private Calendar periodo_inicial;
    
    @Temporal(TemporalType.DATE)
    private Calendar periodo_final;
    
    private Double valor;
    
    @Temporal(TemporalType.DATE)
    private Calendar vencimento;
    
    @ManyToOne
    private Entidade entidade;
    
    private String numero;
    @Temporal(TemporalType.DATE)
    
    private Calendar ult_alteracao;
    
    @ManyToMany
    private List <Documento> documentos;

    public Documento() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getData_inclusao() {
        return data_inclusao;
    }

    public void setData_inclusao(Calendar data_inclusao) {
        this.data_inclusao = data_inclusao;
    }

    public Usuario getUsuario_inclusao() {
        return usuario_inclusao;
    }

    public void setUsuario_inclusao(Usuario usuario_inclusao) {
        this.usuario_inclusao = usuario_inclusao;
    }

    public Usuario getUsuario_aprovacao() {
        return usuario_aprovacao;
    }

    public void setUsuario_aprovacao(Usuario usuario_aprovacao) {
        this.usuario_aprovacao = usuario_aprovacao;
    }

    public Calendar getData_aprovacao() {
        return data_aprovacao;
    }

    public void setData_aprovacao(Calendar data_aprovacao) {
        this.data_aprovacao = data_aprovacao;
    }

    public File getArquivo() {
        return arquivo;
    }

    public void setArquivo(File arquivo) {
        this.arquivo = arquivo;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public TipoDocumento getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(TipoDocumento tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Calendar getPeriodo_inicial() {
        return periodo_inicial;
    }

    public void setPeriodo_inicial(Calendar periodo_inicial) {
        this.periodo_inicial = periodo_inicial;
    }

    public Calendar getPeriodo_final() {
        return periodo_final;
    }

    public void setPeriodo_final(Calendar periodo_final) {
        this.periodo_final = periodo_final;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Calendar getVencimento() {
        return vencimento;
    }

    public void setVencimento(Calendar vencimento) {
        this.vencimento = vencimento;
    }

    public Entidade getEntidade() {
        return entidade;
    }

    public void setEntidade(Entidade entidade) {
        this.entidade = entidade;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Calendar getUlt_alteracao() {
        return ult_alteracao;
    }

    public void setUlt_alteracao(Calendar ult_alteracao) {
        this.ult_alteracao = ult_alteracao;
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }
    
    @Override
    public String toString() {
        return String.format("%s[id=%d]", getClass().getSimpleName(), getId());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.data_inclusao);
        hash = 79 * hash + Objects.hashCode(this.usuario_inclusao);
        hash = 79 * hash + Objects.hashCode(this.usuario_aprovacao);
        hash = 79 * hash + Objects.hashCode(this.data_aprovacao);
        hash = 79 * hash + Objects.hashCode(this.arquivo);
        hash = 79 * hash + Objects.hashCode(this.empresa);
        hash = 79 * hash + Objects.hashCode(this.tipo_documento);
        hash = 79 * hash + Objects.hashCode(this.descricao);
        hash = 79 * hash + Objects.hashCode(this.periodo_inicial);
        hash = 79 * hash + Objects.hashCode(this.periodo_final);
        hash = 79 * hash + Objects.hashCode(this.valor);
        hash = 79 * hash + Objects.hashCode(this.vencimento);
        hash = 79 * hash + Objects.hashCode(this.entidade);
        hash = 79 * hash + Objects.hashCode(this.numero);
        hash = 79 * hash + Objects.hashCode(this.ult_alteracao);
        hash = 79 * hash + Objects.hashCode(this.documentos);
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
        final Documento other = (Documento) obj;
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.data_inclusao, other.data_inclusao)) {
            return false;
        }
        if (!Objects.equals(this.usuario_inclusao, other.usuario_inclusao)) {
            return false;
        }
        if (!Objects.equals(this.usuario_aprovacao, other.usuario_aprovacao)) {
            return false;
        }
        if (!Objects.equals(this.data_aprovacao, other.data_aprovacao)) {
            return false;
        }
        if (!Objects.equals(this.arquivo, other.arquivo)) {
            return false;
        }
        if (!Objects.equals(this.empresa, other.empresa)) {
            return false;
        }
        if (!Objects.equals(this.tipo_documento, other.tipo_documento)) {
            return false;
        }
        if (!Objects.equals(this.periodo_inicial, other.periodo_inicial)) {
            return false;
        }
        if (!Objects.equals(this.periodo_final, other.periodo_final)) {
            return false;
        }
        if (!Objects.equals(this.valor, other.valor)) {
            return false;
        }
        if (!Objects.equals(this.vencimento, other.vencimento)) {
            return false;
        }
        if (!Objects.equals(this.entidade, other.entidade)) {
            return false;
        }
        if (!Objects.equals(this.ult_alteracao, other.ult_alteracao)) {
            return false;
        }
        if (!Objects.equals(this.documentos, other.documentos)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
