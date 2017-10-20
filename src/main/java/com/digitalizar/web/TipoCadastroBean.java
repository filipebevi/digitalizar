/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.web;

import com.digitalizar.tipodocumento.Extensao;
import com.digitalizar.tipodocumento.TipoDocumento;
import com.digitalizar.tipodocumento.TipoDocumentoRN;
import com.digitalizar.web.util.ContextoUtil;
import com.digitalizar.web.util.MensagemUtil;
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
public class TipoCadastroBean implements Serializable {

    TipoDocumento tipoDocumento = new TipoDocumento();
    Extensao extensao = new Extensao();
    List<Extensao> extensoes;
    

    public TipoCadastroBean() {
        ContextoBean contexto = ContextoUtil.getContextoBean();
        this.tipoDocumento=contexto.getTipo();
   
    
    }

    public String salvar() {
        ContextoBean contextoBean = ContextoUtil.getContextoBean();
        this.tipoDocumento.setEmpresa(contextoBean.getEmpresaAtiva());
        TipoDocumentoRN tipoDocumentoRN = new TipoDocumentoRN();
        tipoDocumentoRN.salvar(this.tipoDocumento);
        new MensagemUtil().sendMensagem("info", "Tipo de Documento Cadastrado com sucesso!", "");
        this.tipoDocumento = new TipoDocumento();
        return "tipodedocumento";

    }
    
    public void adicionarExtensao(){
        this.tipoDocumento.getExtensoes().add(this.extensao);
        this.extensao=new Extensao();
    }
    
    public void removerExtensao(){
        this.tipoDocumento.getExtensoes().remove(this.extensao);
        
    }

    public List<Extensao> getExtensoes() {
         TipoDocumentoRN tipoRN=new TipoDocumentoRN();
         extensoes=tipoRN.listarExtensao();
        
        return extensoes;
    }

   
    
    
    
    

   
    public TipoDocumento getTipoDocumento() {
        return this.tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Extensao getExtensao() {
        return extensao;
    }

    public void setExtensao(Extensao extensao) {
        this.extensao = extensao;
    }
    
    

}
