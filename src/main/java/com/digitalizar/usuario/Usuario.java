/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.usuario;

import com.digitalizar.usuarioDocumento.UsuarioDocumento;
import com.digitalizar.usuarioEmpresa.UsuarioEmpresa;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author filip
 */

@Entity
public class Usuario implements Serializable{
    
    @Id
    @GeneratedValue
    private Integer id;
    private String nome;
    private String email;
    private String telefone;
    private String senha;
    private boolean ativo;
    private boolean funcionario;
    private boolean administrador;
    private Date data_inclusao;
    private Date data_ult_alteracao;
    @ManyToOne
    private Usuario usuario;
    @OneToMany
    private List <UsuarioDocumento> listaTipoDocumentos;
    @OneToMany
    private List<UsuarioEmpresa> listaEmpresas;
    
    
    
}
