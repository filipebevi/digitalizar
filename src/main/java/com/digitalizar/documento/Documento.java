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

    @Column(nullable = false)
    private String descricao;

    @Temporal(TemporalType.DATE)
    @Column(name = "periodo_inicial")
    private Date periodoInicial;

    @Temporal(TemporalType.DATE)
    @Column(name = "periodo_final")
    private Date periodoFinal;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "competencia")
    private Date competencia;

    private Double valor;

    private String numero;

    @Temporal(TemporalType.DATE)
    private Date vencimento;

    private String diretorio;

    @Column(name = "nome_arquivo")
    private String nomeArquivo;

    private Long tamanho;

    @ManyToOne
    private Empresa empresa;

    @ManyToOne
    private TipoDocumento tipoDocumento;

    @ManyToOne
    private Entidade entidade;

    @ManyToOne
    private Usuario usuarioEdicao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_edicao")
    private Calendar dataEdicao;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_inclusao")
    private Calendar dataInclusao;

    @ManyToOne
    private Usuario usuarioInclusao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_aprovacao")
    private Calendar dataAprovacao;

    @ManyToOne
    private Usuario usuarioAprovacao;

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
    
    

    public Documento() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Calendar dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public Usuario getUsuarioInclusao() {
        return usuarioInclusao;
    }

    public void setUsuarioInclusao(Usuario usuarioInclusao) {
        this.usuarioInclusao = usuarioInclusao;
    }

    public Usuario getUsuarioAprovacao() {
        return usuarioAprovacao;
    }

    public void setUsuarioAprovacao(Usuario usuarioAprovacao) {
        this.usuarioAprovacao = usuarioAprovacao;
    }

    public Calendar getDataAprovacao() {
        return dataAprovacao;
    }

    public void setDataAprovacao(Calendar dataAprovacao) {
        this.dataAprovacao = dataAprovacao;
    }

    public String getDiretorio() {
        return diretorio;
    }

    public void setDiretorio(String diretorio) {
        this.diretorio = diretorio;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getPeriodoInicial() {
        return periodoInicial;
    }

    public void setPeriodoInicial(Date periodoInicial) {
        this.periodoInicial = periodoInicial;
    }

    public Date getPeriodoFinal() {
        return periodoFinal;
    }

    public void setPeriodoFinal(Date periodoFinal) {
        this.periodoFinal = periodoFinal;
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

    public Calendar getDataEdicao() {
        return dataEdicao;
    }

    public void setDataEdicao(Calendar dataEdicao) {
        this.dataEdicao = dataEdicao;
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }

    public Usuario getUsuarioEdicao() {
        return usuarioEdicao;
    }

    public void setUsuarioEdicao(Usuario usuarioEdicao) {
        this.usuarioEdicao = usuarioEdicao;
    }

    public Long getTamanho() {
        return tamanho;
    }

    public void setTamanho(Long tamanho) {
        this.tamanho = tamanho;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public List<Documento> getDocumentosOf() {
        return documentosOf;
    }

    public void setDocumentosOf(List<Documento> documentosOf) {
        this.documentosOf = documentosOf;
    }

    public Date getCompetencia() {
        return competencia;
    }

    public void setCompetencia(Date competencia) {
        this.competencia = competencia;
    }
    
    

    @Override
    public String toString() {
        return String.format("%s[id=%d]", getClass().getSimpleName(), getId());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.descricao);
        hash = 79 * hash + Objects.hashCode(this.periodoInicial);
        hash = 79 * hash + Objects.hashCode(this.periodoFinal);
        hash = 79 * hash + Objects.hashCode(this.competencia);
        hash = 79 * hash + Objects.hashCode(this.valor);
        hash = 79 * hash + Objects.hashCode(this.numero);
        hash = 79 * hash + Objects.hashCode(this.vencimento);
        hash = 79 * hash + Objects.hashCode(this.diretorio);
        hash = 79 * hash + Objects.hashCode(this.nomeArquivo);
        hash = 79 * hash + Objects.hashCode(this.tamanho);
        hash = 79 * hash + Objects.hashCode(this.empresa);
        hash = 79 * hash + Objects.hashCode(this.tipoDocumento);
        hash = 79 * hash + Objects.hashCode(this.entidade);
        hash = 79 * hash + Objects.hashCode(this.usuarioEdicao);
        hash = 79 * hash + Objects.hashCode(this.dataEdicao);
        hash = 79 * hash + Objects.hashCode(this.dataInclusao);
        hash = 79 * hash + Objects.hashCode(this.usuarioInclusao);
        hash = 79 * hash + Objects.hashCode(this.dataAprovacao);
        hash = 79 * hash + Objects.hashCode(this.usuarioAprovacao);
        hash = 79 * hash + Objects.hashCode(this.documentos);
        hash = 79 * hash + Objects.hashCode(this.documentosOf);
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
        if (!Objects.equals(this.diretorio, other.diretorio)) {
            return false;
        }
        if (!Objects.equals(this.nomeArquivo, other.nomeArquivo)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.periodoInicial, other.periodoInicial)) {
            return false;
        }
        if (!Objects.equals(this.periodoFinal, other.periodoFinal)) {
            return false;
        }
        if (!Objects.equals(this.competencia, other.competencia)) {
            return false;
        }
        if (!Objects.equals(this.valor, other.valor)) {
            return false;
        }
        if (!Objects.equals(this.vencimento, other.vencimento)) {
            return false;
        }
        if (!Objects.equals(this.tamanho, other.tamanho)) {
            return false;
        }
        if (!Objects.equals(this.empresa, other.empresa)) {
            return false;
        }
        if (!Objects.equals(this.tipoDocumento, other.tipoDocumento)) {
            return false;
        }
        if (!Objects.equals(this.entidade, other.entidade)) {
            return false;
        }
        if (!Objects.equals(this.usuarioEdicao, other.usuarioEdicao)) {
            return false;
        }
        if (!Objects.equals(this.dataEdicao, other.dataEdicao)) {
            return false;
        }
        if (!Objects.equals(this.dataInclusao, other.dataInclusao)) {
            return false;
        }
        if (!Objects.equals(this.usuarioInclusao, other.usuarioInclusao)) {
            return false;
        }
        if (!Objects.equals(this.dataAprovacao, other.dataAprovacao)) {
            return false;
        }
        if (!Objects.equals(this.usuarioAprovacao, other.usuarioAprovacao)) {
            return false;
        }
        if (!Objects.equals(this.documentos, other.documentos)) {
            return false;
        }
        if (!Objects.equals(this.documentosOf, other.documentosOf)) {
            return false;
        }
        return true;
    }

    

}
