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
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.Calendar;
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

public class DocumentoCadastroBean implements Serializable {

    private Documento documento = new Documento();
    private Part file;
    private List<TipoDocumento> listarTipoDocumento;
    private List<Entidade> listarEntidade;

    public String salvar() {

        ContextoBean contexto = ContextoUtil.getContextoBean();
        DocumentoRN documentoRN = new DocumentoRN();
        documentoRN.salvar(this.documento, contexto.getEmpresaAtiva(), contexto.getUsuarioLogado(), this.file);
        this.documento=new Documento();
        this.file= null;
        return "principal";
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
