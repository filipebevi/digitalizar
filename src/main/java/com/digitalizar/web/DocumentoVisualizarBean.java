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
import com.digitalizar.web.util.MensagemUtil;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.Part;

/**
 *
 * @author Flipe
 */
@ManagedBean
@ViewScoped
public class DocumentoVisualizarBean implements Serializable {

    private Documento documento = new Documento();
    private Part file;
    private List<TipoDocumento> listarTipoDocumento;
    private List<Entidade> listarEntidade;
    private List<Documento> litarDocumento;
    
    private String descricao;
    private TipoDocumento tipoDocumento;
    private Entidade entidade;
    private Date dataInicio;
    private Date dataFim;

    public DocumentoVisualizarBean() {
        ContextoBean contexto = ContextoUtil.getContextoBean();
        this.documento=contexto.getDocumento();
    }
    
    public String editar() {

        return "documento";
    }

    public String excluir() {

        return "documento";
    }
    
    public void aprovar(){
        ContextoBean contexto=ContextoUtil.getContextoBean();
        DocumentoRN documentoRN=new DocumentoRN();
        documentoRN.aprovar(this.documento, contexto.getUsuarioLogado());
    }

    public List<TipoDocumento> getListarTipoDocumento() {
        TipoDocumentoRN tipoDocumentoRN = new TipoDocumentoRN();
        ContextoBean contexto = ContextoUtil.getContextoBean();
        this.listarTipoDocumento = tipoDocumentoRN.listar(contexto.getEmpresaAtiva());
        return this.listarTipoDocumento;
    }

    public List<Entidade> getListarEntidade() {
        EntidadeRN entidadeRN = new EntidadeRN();
        ContextoBean contexto = ContextoUtil.getContextoBean();
        this.listarEntidade = entidadeRN.listar(contexto.getEmpresaAtiva());
        return this.listarEntidade;
    }

    public List<Documento> getLitarDocumento() {
        DocumentoRN documentoRN = new DocumentoRN();
        ContextoBean contexto = ContextoUtil.getContextoBean();
        documentoRN.listar(contexto.getEmpresaAtiva(), contexto.getUsuarioLogado(), descricao, tipoDocumento, entidade, dataInicio, dataFim);
        return litarDocumento;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }
}
