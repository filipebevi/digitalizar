/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.usuario;


import com.digitalizar.util.DAOFactory;
import java.util.List;

/**
 *
 * @author filip
 */
public class UsuarioRN {
    
    private UsuarioDAO usuarioDAO;
    
    
    public UsuarioRN(){
        this.usuarioDAO=DAOFactory.criarUsuarioDAO();
    }
    
    public void salvar(Usuario usuario){
        this.usuarioDAO.salvar(usuario);
    }
    
    public void excluir(Usuario usuario){
        this.usuarioDAO.excluir(usuario);
    }
    
    public List<Usuario> listar(String texto){
        return this.usuarioDAO.listar(texto);
    }
    
    public Usuario buscarPorEmail(String email){
        return this.usuarioDAO.buscarPorEmail(email);
    }
    
}
