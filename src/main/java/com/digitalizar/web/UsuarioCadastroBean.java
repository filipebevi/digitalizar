/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.web;

import com.digitalizar.empresa.Empresa;
import com.digitalizar.empresa.EmpresaRN;
import com.digitalizar.usuario.Usuario;
import com.digitalizar.usuario.UsuarioRN;
import com.digitalizar.usuarioEmpresa.UsuarioEmpresa;
import com.digitalizar.web.util.ContextoUtil;
import java.util.Calendar;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author filip
 */
@ManagedBean
@ViewScoped
public class UsuarioCadastroBean {
    
    Usuario usuario;
    Empresa empresa = new Empresa();
    UsuarioEmpresa usuarioEmpresa = new UsuarioEmpresa();
    List<Empresa> listaEmpresa;
    
    
    
    public void novaEmpresa() {

        this.empresa = new Empresa();
        this.usuarioEmpresa = new UsuarioEmpresa();
    }
    
    public String salvar() {
        ContextoBean contextoBean = ContextoUtil.getContextoBean();
        if (this.usuario.getUsuarioInclusao() == null) {
            this.usuario.setUsuarioInclusao(contextoBean.getUsuarioLogado());
            this.usuario.setData_inclusao(Calendar.getInstance());
        }
        this.usuario.setUsuarioAlteracao(contextoBean.getUsuarioLogado());
        this.usuario.setData_ult_alteracao(Calendar.getInstance());
        UsuarioRN usuarioRN = new UsuarioRN();
        usuarioRN.salvar(this.usuario);
        usuario = new Usuario();
        

        return "usuario";

    }
    
    public void adicionarEmpresa() {
        UsuarioEmpresa.Id id = new UsuarioEmpresa.Id();
        id.setEmpresa(this.empresa.getId());
        id.setUsuario(this.usuario.getId());
        this.usuarioEmpresa.setId(id);
        this.usuarioEmpresa.setUsuario(this.usuario);
        this.usuarioEmpresa.setEmpresa(this.empresa);

        this.usuario.getUsuarioEmpresa().add(usuarioEmpresa);
        

        this.empresa = new Empresa();
        this.usuarioEmpresa = new UsuarioEmpresa();


    }
    
    
    public List<Empresa> getListaEmpresa() {
        if (this.listaEmpresa == null) {
            EmpresaRN empresaRN = new EmpresaRN();
            this.listaEmpresa = empresaRN.listar();
        }

        return this.listaEmpresa;
    }
    
    
    
    
    

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public UsuarioEmpresa getUsuarioEmpresa() {
        return usuarioEmpresa;
    }

    public void setUsuarioEmpresa(UsuarioEmpresa usuarioEmpresa) {
        this.usuarioEmpresa = usuarioEmpresa;
    }
    
    
    
    
    
}
