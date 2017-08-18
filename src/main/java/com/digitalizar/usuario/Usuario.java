/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.usuario;

import com.digitalizar.usuarioDocumento.UsuarioDocumento;
import com.digitalizar.usuarioEmpresa.UsuarioEmpresa;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
    private Boolean ativo;
    private Boolean funcionario;
    private Boolean administrador;
    
    @Temporal(TemporalType.DATE)
    private Calendar data_inclusao;
    
    @Temporal(TemporalType.DATE)
    private Calendar data_ult_alteracao;
    
    @ManyToOne
    private Usuario usuario;
    
    @OneToMany
    private List <UsuarioDocumento> listaTipoDocumentos;
    
    @OneToMany
    private List<UsuarioEmpresa> listaEmpresas;
    
    
    
}
