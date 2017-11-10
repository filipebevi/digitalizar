/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.usuario;



import com.digitalizar.tipodocumento.TipoDocumento;
import com.digitalizar.usuarioEmpresa.UsuarioEmpresa;
import com.digitalizar.usuarioTipoDocumento.UsuarioTipoDocumento;
import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;

import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;


import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.NaturalId;

/**
 *
 * @author filip
 */

@Entity
public class Usuario implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable=false, unique = true) 
    private String nome;
    @NaturalId
    @Column(nullable=false, unique = true) 
    private String email;
    private String telefone;
    @Column(nullable=false, length = 18) 
    private String senha;
    private Boolean ativo;
    private Boolean funcionario;
    private Boolean administrador;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar data_inclusao;
    
    @ManyToOne
    private Usuario usuarioInclusao;
    
    
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar data_ult_alteracao;
    
    @ManyToOne
    private Usuario usuarioAlteracao;
    
    @OneToMany(mappedBy = "usuario", targetEntity=UsuarioEmpresa.class, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UsuarioEmpresa> usuarioEmpresa;
    
    @OneToMany(mappedBy = "usuario", targetEntity=UsuarioTipoDocumento.class, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UsuarioTipoDocumento> usuarioTipoDocumento;
    
    @ElementCollection(targetClass=String.class)
    @JoinTable(
    name="usuario_permissao",
            uniqueConstraints = {@UniqueConstraint(columnNames = {"usuario","permissao"})},
            joinColumns = @JoinColumn(name = "usuario")
    )
    @Column(name="permissao", length = 50)    
    private Set<String> permissao=new HashSet<String>();
   

    public Usuario() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Boolean getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Boolean funcionario) {
        this.funcionario = funcionario;
    }

    public Boolean getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Boolean administrador) {
        this.administrador = administrador;
    }

    public Calendar getData_inclusao() {
        return data_inclusao;
    }

    public void setData_inclusao(Calendar data_inclusao) {
        this.data_inclusao = data_inclusao;
    }

    public Usuario getUsuarioInclusao() {
        return usuarioInclusao;
    }

    public void setUsuarioInclusao(Usuario usuarioInclusao) {
        this.usuarioInclusao = usuarioInclusao;
    }

    public Calendar getData_ult_alteracao() {
        return data_ult_alteracao;
    }

    public void setData_ult_alteracao(Calendar data_ult_alteracao) {
        this.data_ult_alteracao = data_ult_alteracao;
    }

    public Usuario getUsuarioAlteracao() {
        return usuarioAlteracao;
    }

    public void setUsuarioAlteracao(Usuario usuarioAlteracao) {
        this.usuarioAlteracao = usuarioAlteracao;
    }

    public List<UsuarioEmpresa> getUsuarioEmpresa() {
        return usuarioEmpresa;
    }

    public void setUsuarioEmpresa(List<UsuarioEmpresa> usuarioEmpresa) {
        this.usuarioEmpresa = usuarioEmpresa;
    }

    public List<UsuarioTipoDocumento> getUsuarioTipoDocumento() {
        return usuarioTipoDocumento;
    }

    public void setUsuarioTipoDocumento(List<UsuarioTipoDocumento> usuarioTipoDocumento) {
        this.usuarioTipoDocumento = usuarioTipoDocumento;
    }

    public Set<String> getPermissao() {
        return permissao;
    }

    public void setPermissao(Set<String> permissao) {
        this.permissao = permissao;
    }
    
    
    @Override
    public String toString() {
        return String.format("%s[id=%d]", getClass().getSimpleName(), getId());
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.id);
        hash = 11 * hash + Objects.hashCode(this.nome);
        hash = 11 * hash + Objects.hashCode(this.email);
        hash = 11 * hash + Objects.hashCode(this.telefone);
        hash = 11 * hash + Objects.hashCode(this.senha);
        hash = 11 * hash + Objects.hashCode(this.ativo);
        hash = 11 * hash + Objects.hashCode(this.funcionario);
        hash = 11 * hash + Objects.hashCode(this.administrador);
        hash = 11 * hash + Objects.hashCode(this.data_inclusao);
        hash = 11 * hash + Objects.hashCode(this.usuarioInclusao);
        hash = 11 * hash + Objects.hashCode(this.data_ult_alteracao);
        hash = 11 * hash + Objects.hashCode(this.usuarioAlteracao);
        hash = 11 * hash + Objects.hashCode(this.usuarioEmpresa);
        hash = 11 * hash + Objects.hashCode(this.usuarioTipoDocumento);
        hash = 11 * hash + Objects.hashCode(this.permissao);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.ativo, other.ativo)) {
            return false;
        }
        if (!Objects.equals(this.funcionario, other.funcionario)) {
            return false;
        }
        if (!Objects.equals(this.administrador, other.administrador)) {
            return false;
        }
        if (!Objects.equals(this.data_inclusao, other.data_inclusao)) {
            return false;
        }
        if (!Objects.equals(this.usuarioInclusao, other.usuarioInclusao)) {
            return false;
        }
        if (!Objects.equals(this.data_ult_alteracao, other.data_ult_alteracao)) {
            return false;
        }
        if (!Objects.equals(this.usuarioAlteracao, other.usuarioAlteracao)) {
            return false;
        }
        if (!Objects.equals(this.usuarioEmpresa, other.usuarioEmpresa)) {
            return false;
        }
        if (!Objects.equals(this.usuarioTipoDocumento, other.usuarioTipoDocumento)) {
            return false;
        }
        if (!Objects.equals(this.permissao, other.permissao)) {
            return false;
        }
        return true;
    }

    
    
    
}
