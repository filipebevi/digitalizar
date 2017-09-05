/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.web;


import com.digitalizar.usuario.Usuario;
import com.digitalizar.usuario.UsuarioRN;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


/**
 *
 * @author filip
 */
@ManagedBean
@RequestScoped
public class UsuarioBean implements Serializable {

    Usuario usuario = new Usuario();
    List<Usuario> listaUsuario;
    

    public String novo() {
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
        if (this.listaUsuario == null) {
            UsuarioRN usuarioRN = new UsuarioRN();
            this.listaUsuario = usuarioRN.listar();
        }

        return this.listaUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

   

    

}
