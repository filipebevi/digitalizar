/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.web;

import com.digitalizar.documento.Documento;
import com.digitalizar.empresa.Empresa;
import com.digitalizar.empresa.EmpresaRN;
import com.digitalizar.usuario.Usuario;
import com.digitalizar.usuario.UsuarioRN;
import com.digitalizar.usuarioEmpresa.UsuarioEmpresaRN;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author Flipe
 */
@ManagedBean
@SessionScoped
public class ContextoBean implements Serializable{
    
    private Empresa empresaAtiva=null;
    private Usuario usuarioLogado=null;
    private Usuario usuarioTemporario=null;
    private Documento documento=null;

    public Empresa getEmpresaAtiva() {
        
        if(this.empresaAtiva==null){
            Usuario usuario=this.getUsuarioLogado();
            UsuarioEmpresaRN usuarioEmpresaRN = new UsuarioEmpresaRN();
            this.empresaAtiva=usuarioEmpresaRN.buscarFavorita(usuario);
            if(this.empresaAtiva==null){
                List<Empresa> empresas=usuarioEmpresaRN.listar(usuario);
                if(empresas!=null){
                    for(Empresa empresa : empresas){
                        this.empresaAtiva=empresa;
                        break;
                    }
                }
            }
        }
        return empresaAtiva;
    }

    public void setEmpresaAtiva(ValueChangeEvent event) {
        Integer empresa = (Integer) event.getNewValue();
        EmpresaRN empresaRN=new EmpresaRN();
        this.empresaAtiva=empresaRN.carregar(empresa);
        
    }

    public Usuario getUsuarioLogado() {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext external = context.getExternalContext();
        String email=external.getRemoteUser();
        
        if(this.usuarioLogado==null || !email.equals(this.usuarioLogado.getEmail())){
            if(email !=null){
                
                UsuarioRN usuarioRN=new UsuarioRN();
                this.usuarioLogado=usuarioRN.buscarPorEmail(email);
                this.empresaAtiva=null;
                
            }
        }
        
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public Usuario getUsuarioTemporario() {
        return usuarioTemporario;
    }

    public void setUsuarioTemporario(Usuario usuarioTemporario) {
        this.usuarioTemporario = usuarioTemporario;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }
    
    
    
    
    
}
