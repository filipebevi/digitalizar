/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.web;

import com.digitalizar.empresa.Empresa;
import com.digitalizar.usuario.Usuario;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author Flipe
 */
public class ContextoBean {
    
    private Empresa empresaAtiva=null;
    private Usuario usuarioLogado=null;

    public Empresa getEmpresaAtiva() {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext external = context.getExternalContext();
        String login=external.getRemoteUser();
        
        if(this.usuarioLogado==null || !login.equals(this.usuarioLogado.getEmail())){
            if(login !=null){
                
            }
        }
        
        
        return empresaAtiva;
    }

    public void setEmpresaAtiva(Empresa empresaAtiva) {
        this.empresaAtiva = empresaAtiva;
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }
    
    
    
}
