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
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author filip
 */
@Entity
public class Documento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar data_inclusao;

    @ManyToOne
    private Usuario usuario_inclusao;

    @ManyToOne
    private Usuario usuario_aprovacao;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar data_aprovacao;

    private String path;

    @ManyToOne
    private Empresa empresa;

    @ManyToOne
    private TipoDocumento tipo_documento;

    @Column(nullable = false)

    private String descricao;

    @Temporal(TemporalType.DATE)
    private Date periodo_inicial;

    @Temporal(TemporalType.DATE)
    private Date periodo_final;

    private Double valor;

    @Temporal(TemporalType.DATE)
    private Date vencimento;

    @ManyToOne
    private Entidade entidade;

    private String numero;

    @ManyToOne
    private Usuario usuarioAlteracao;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar ult_alteracao;

    @ManyToMany
    @JoinTable(name = "documento_documento",
            joinColumns = @JoinColumn(name = "documentos_id"),
            inverseJoinColumns = @JoinColumn(name = "Documento_id")
    )
    private List<Documento> documentos;
    
    @ManyToMany
    @JoinTable(name = "documento_documento",
            joinColumns = @JoinColumn(name = "Documento_id"),
            inverseJoinColumns = @JoinColumn(name = "documentos_id")
    )
    private List<Documento> documentosOf;

    private Long tamanho;

    private String nome;

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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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

    public Date getPeriodo_inicial() {
        return periodo_inicial;
    }

    public void setPeriodo_inicial(Date periodo_inicial) {
        this.periodo_inicial = periodo_inicial;
    }

    public Date getPeriodo_final() {
        return periodo_final;
    }

    public void setPeriodo_final(Date periodo_final) {
        this.periodo_final = periodo_final;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
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

    public Usuario getUsuarioAlteracao() {
        return usuarioAlteracao;
    }

    public void setUsuarioAlteracao(Usuario usuarioAlteracao) {
        this.usuarioAlteracao = usuarioAlteracao;
    }

    public Long getTamanho() {
        return tamanho;
    }

    public void setTamanho(Long tamanho) {
        this.tamanho = tamanho;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Documento> getDocumentosOf() {
        return documentosOf;
    }

    public void setDocumentosOf(List<Documento> documentosOf) {
        this.documentosOf = documentosOf;
    }
    
    

    @Override
    public String toString() {
        return String.format("%s[id=%d]", getClass().getSimpleName(), getId());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.data_inclusao);
        hash = 47 * hash + Objects.hashCode(this.usuario_inclusao);
        hash = 47 * hash + Objects.hashCode(this.usuario_aprovacao);
        hash = 47 * hash + Objects.hashCode(this.data_aprovacao);
        hash = 47 * hash + Objects.hashCode(this.path);
        hash = 47 * hash + Objects.hashCode(this.empresa);
        hash = 47 * hash + Objects.hashCode(this.tipo_documento);
        hash = 47 * hash + Objects.hashCode(this.descricao);
        hash = 47 * hash + Objects.hashCode(this.periodo_inicial);
        hash = 47 * hash + Objects.hashCode(this.periodo_final);
        hash = 47 * hash + Objects.hashCode(this.valor);
        hash = 47 * hash + Objects.hashCode(this.vencimento);
        hash = 47 * hash + Objects.hashCode(this.entidade);
        hash = 47 * hash + Objects.hashCode(this.numero);
        hash = 47 * hash + Objects.hashCode(this.usuarioAlteracao);
        hash = 47 * hash + Objects.hashCode(this.ult_alteracao);
        hash = 47 * hash + Objects.hashCode(this.documentos);
        hash = 47 * hash + Objects.hashCode(this.documentosOf);
        hash = 47 * hash + Objects.hashCode(this.tamanho);
        hash = 47 * hash + Objects.hashCode(this.nome);
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
        if (!Objects.equals(this.path, other.path)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
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
        if (!Objects.equals(this.usuarioAlteracao, other.usuarioAlteracao)) {
            return false;
        }
        if (!Objects.equals(this.ult_alteracao, other.ult_alteracao)) {
            return false;
        }
        if (!Objects.equals(this.documentos, other.documentos)) {
            return false;
        }
        if (!Objects.equals(this.documentosOf, other.documentosOf)) {
            return false;
        }
        if (!Objects.equals(this.tamanho, other.tamanho)) {
            return false;
        }
        return true;
    }

    

}
