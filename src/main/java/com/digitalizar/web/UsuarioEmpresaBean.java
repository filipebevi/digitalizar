/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.web;

import com.digitalizar.empresa.Empresa;
import com.digitalizar.usuarioEmpresa.UsuarioEmpresaRN;
import com.digitalizar.web.util.ContextoUtil;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author filip
 */
@ManagedBean
@RequestScoped
public class UsuarioEmpresaBean {
    
    private Empresa empresa=new Empresa();
    private List <Empresa> lista = null;
    
    public List<Empresa> getLista(){
        if(this.lista==null){
            ContextoBean contextBean= ContextoUtil.getContextoBean();
            UsuarioEmpresaRN usuarioEmpresaRN=new UsuarioEmpresaRN();
            this.lista=usuarioEmpresaRN.listar(contextBean.getUsuarioLogado());
        }
        return this.lista;
    }
    
    
}
