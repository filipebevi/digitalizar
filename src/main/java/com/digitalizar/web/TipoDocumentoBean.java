/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.web;

import com.digitalizar.empresa.Empresa;
import com.digitalizar.tipodocumento.TipoDocumento;
import com.digitalizar.tipodocumento.TipoDocumentoRN;
import com.digitalizar.web.util.ContextoUtil;
import com.digitalizar.web.util.MensagemUtil;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


/**
 *
 * @author filip
 */
@ManagedBean
@RequestScoped
public class TipoDocumentoBean {
    
    TipoDocumento tipoDocumento=new TipoDocumento();
    List<TipoDocumento> listarTipo;
    
    
    public void salvar(){
        ContextoBean contextoBean = ContextoUtil.getContextoBean();
        this.tipoDocumento.setEmpresa(contextoBean.getEmpresaAtiva());
        TipoDocumentoRN tipoDocumentoRN=new TipoDocumentoRN();
        tipoDocumentoRN.salvar(this.tipoDocumento);
        new MensagemUtil().sendMensagem("info","Tipo de Documento Cadastrado com sucesso!", "");
        this.tipoDocumento = new TipoDocumento();
        this.listarTipo=null;
    }
    
    public void excluir(){
        TipoDocumentoRN tipoDocumentoRN=new TipoDocumentoRN();
       tipoDocumentoRN.excluir(this.tipoDocumento);
       this.listarTipo=null;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public List<TipoDocumento> getListarTipo() {
        if(this.listarTipo==null){
            ContextoBean contextoBean = ContextoUtil.getContextoBean();
            TipoDocumentoRN tipoDocumentoRN= new TipoDocumentoRN();
            this.listarTipo=tipoDocumentoRN.listar(contextoBean.getEmpresaAtiva());
        }
        
        return listarTipo;
    }

    
    
    
    
    
    
}
