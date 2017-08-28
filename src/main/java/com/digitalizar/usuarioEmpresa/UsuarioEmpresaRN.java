/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.usuarioEmpresa;


import com.digitalizar.empresa.Empresa;
import com.digitalizar.usuario.Usuario;
import com.digitalizar.util.DAOFactory;
import java.util.List;

/**
 *
 * @author filip
 */
public class UsuarioEmpresaRN {
    
    private UsuarioEmpresaDAO usuarioEmpresaDAO;
    
    
    public UsuarioEmpresaRN(){
        this.usuarioEmpresaDAO=DAOFactory.criarUsuarioEmpresaDAO();
    }
    
    public void salvar(UsuarioEmpresa usuarioEmpresa){
        this.usuarioEmpresaDAO.salvar(usuarioEmpresa);
    }
    
    public void excluir(UsuarioEmpresa usuarioEmpresa){
        this.usuarioEmpresaDAO.excluir(usuarioEmpresa);
    }
    
    public List<Empresa> listar(Usuario usuario){
        return this.usuarioEmpresaDAO.listar(usuario);
    }
    
    public Empresa buscarFavorita(Usuario usuario){
        return this.usuarioEmpresaDAO.buscarFavorita(usuario);
    }
    
}
