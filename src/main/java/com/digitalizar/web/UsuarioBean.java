/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.web;

import com.digitalizar.usuario.Usuario;
import com.digitalizar.usuario.UsuarioRN;
import com.digitalizar.web.util.ContextoUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author filip
 */
@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable {

    Usuario usuario = new Usuario();
    List<Usuario> listaUsuario;
    String texto;

    public String novo() {
        ContextoBean contexto = ContextoUtil.getContextoBean();
        contexto.setUsuarioTemporario(null);
        return "usuario-cadastro";

    }

    public void excluir() {
        UsuarioRN usuarioRN = new UsuarioRN();
        usuarioRN.excluir(this.usuario);
        listaUsuario = null;
    }

    public String editar() {

        return "usuario-cadastro";
    }

    public List<Usuario> getListaUsuario() {
        UsuarioRN usuarioRN = new UsuarioRN();
        this.listaUsuario = usuarioRN.listar(this.texto);
        return this.listaUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

}
