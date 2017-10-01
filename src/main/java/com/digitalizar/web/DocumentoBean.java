/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.web;

import com.digitalizar.documento.Documento;
import com.digitalizar.documento.DocumentoRN;
import com.digitalizar.entidade.Entidade;
import com.digitalizar.entidade.EntidadeRN;
import com.digitalizar.tipodocumento.TipoDocumento;
import com.digitalizar.tipodocumento.TipoDocumentoRN;
import com.digitalizar.web.util.ContextoUtil;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;


/**
 *
 * @author filip
 */

@ManagedBean
@ViewScoped
public class DocumentoBean implements Serializable{
    
    Documento documento;
    List<Documento> lista;
    List<TipoDocumento> listaTipo;
    List<Entidade> listaEntidade;
    
    String descricao;
    TipoDocumento tipoDocumento;
    Entidade entidade;
    Date dataInicial;
    Date dataFinal;
    
    public List<Documento> getLista(){
        ContextoBean contexto = ContextoUtil.getContextoBean();
        DocumentoRN documentoRN=new DocumentoRN();
        this.lista=documentoRN.listar(contexto.getEmpresaAtiva(), contexto.getUsuarioLogado(),this.descricao,this.tipoDocumento, this.entidade, this.dataInicial, this.dataFinal);
        return this.lista;
    }

    public List<TipoDocumento> getListaTipo() {
        ContextoBean contexto=ContextoUtil.getContextoBean();
        TipoDocumentoRN tipoDocumentoRN=new TipoDocumentoRN();
        listaTipo=tipoDocumentoRN.listar(contexto.getEmpresaAtiva());
        return listaTipo;
    }

    public List<Entidade> getListaEntidade() {
        ContextoBean contexto=ContextoUtil.getContextoBean();
        EntidadeRN entidadeRN=new EntidadeRN();
        listaEntidade=entidadeRN.listar(contexto.getEmpresaAtiva());
        return listaEntidade;
    }
     
    
    public String visualizar(){
        
        return "documento-visualizar";
    }

   

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Entidade getEntidade() {
        return entidade;
    }

    public void setEntidade(Entidade entidade) {
        this.entidade = entidade;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
