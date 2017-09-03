/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.web;

import com.digitalizar.empresa.Empresa;
import com.digitalizar.usuario.Usuario;
import com.digitalizar.usuario.UsuarioRN;
import com.digitalizar.usuarioEmpresa.UsuarioEmpresa;
import com.digitalizar.web.util.ContextoUtil;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author filip
 */
@ManagedBean
@RequestScoped
public class UsuarioBean implements Serializable{

    Usuario usuario = new Usuario();
    List<Usuario> listaUsuario;
    
    public void novo(){
        this.usuario=new Usuario();
    }

    public void salvar() {
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
        listaUsuario = null;

    }

    public void excluir() {
        UsuarioRN usuarioRN = new UsuarioRN();
        usuarioRN.excluir(this.usuario);
        listaUsuario = null;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getListaUsuario() {
        if (this.listaUsuario == null) {
            UsuarioRN usuarioRN = new UsuarioRN();
            this.listaUsuario=usuarioRN.listar();
        }

        return this.listaUsuario;
    }

}
