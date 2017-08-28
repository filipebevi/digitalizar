/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.usuarioTipoDocumento;


import com.digitalizar.util.DAOFactory;
import java.util.List;

/**
 *
 * @author filip
 */
public class UsuarioTipoDocumentoRN {
    
    private UsuarioTipoDocumentoDAO usuarioTipoDocumentoDAO;
    
    
    public UsuarioTipoDocumentoRN(){
        this.usuarioTipoDocumentoDAO=DAOFactory.criarUsuarioTipoDocumentoDAO();
    }
    
    public void salvar(UsuarioTipoDocumento usuarioTipoDocumento){
        this.usuarioTipoDocumentoDAO.salvar(usuarioTipoDocumento);
    }
    
    public void excluir(UsuarioTipoDocumento usuarioTipoDocumento){
        this.usuarioTipoDocumentoDAO.excluir(usuarioTipoDocumento);
    }
    
    public List<UsuarioTipoDocumento> listar(){
        return this.usuarioTipoDocumentoDAO.listar();
    }
    
}
