/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.web;

import com.digitalizar.documento.Documento;
import com.digitalizar.documento.DocumentoRN;
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
public class PrincipalBean implements Serializable{
    
    public List<Documento> naoAprovados;
    public List<Documento> naoVinculados;
    
    public Integer totalDoc;
    public Integer mesAnterior;
    public Integer mesAtual;
    public Integer porUsuario;
    
    
    
    public String visualizar(){
        return "documento-visualizar";
    }

    public List<Documento> getNaoAprovados() {
        ContextoBean contexto = ContextoUtil.getContextoBean();
        DocumentoRN documentoRN= new DocumentoRN();
        this.naoAprovados=documentoRN.naoAprovados(contexto.getEmpresaAtiva(), contexto.getUsuarioLogado());
        
        return this.naoAprovados;
    }

    public List<Documento> getNaoVinculados() {
        return naoVinculados;
    }

    public Integer getTotalDoc() {
        DocumentoRN documentoRN=new DocumentoRN();
        ContextoBean contexto = ContextoUtil.getContextoBean();
        this.totalDoc=documentoRN.totalDoc(contexto.getEmpresaAtiva());
        if(this.totalDoc==null){
            this.totalDoc=0;
        }
        return this.totalDoc;
    }
    
    public Integer getMesAnterior() {
        DocumentoRN documentoRN=new DocumentoRN();
        ContextoBean contexto = ContextoUtil.getContextoBean();
        this.mesAnterior=documentoRN.mesAnterior(contexto.getEmpresaAtiva());
        if(this.mesAnterior==null){
            this.mesAnterior=0;
        }
        return mesAnterior;
    }

    public Integer getMesAtual() {
        DocumentoRN documentoRN=new DocumentoRN();
        ContextoBean contexto = ContextoUtil.getContextoBean();
        this.mesAtual=documentoRN.mesAtual(contexto.getEmpresaAtiva());
        if(this.mesAtual==null){
            this.mesAtual=0;
        }
        return mesAtual;
    }

    public Integer getPorUsuario() {
        DocumentoRN documentoRN=new DocumentoRN();
        ContextoBean contexto = ContextoUtil.getContextoBean();
        this.porUsuario=documentoRN.porUsuario(contexto.getEmpresaAtiva(), contexto.getUsuarioLogado());
        if(this.porUsuario==null){
            this.porUsuario=0;
        }
        return porUsuario;
    }

   
    
    
    
    
    
    
}
