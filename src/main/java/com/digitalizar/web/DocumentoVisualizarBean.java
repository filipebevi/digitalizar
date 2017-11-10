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
import com.digitalizar.usuario.UsuarioRN;
import com.digitalizar.web.util.ContextoUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Flipe
 */
@ManagedBean
@ViewScoped
public class DocumentoVisualizarBean implements Serializable {

    private Documento documento = new Documento();
    private Documento docVinculado = new Documento();
    private StreamedContent arquivo;
    private List<TipoDocumento> listarTipoDocumento;
    private List<Entidade> listarEntidade;
    private List<Documento> listarDocumento;
    private List<Documento> vinculados = null;

    private Integer codigo;

    public DocumentoVisualizarBean() {
        ContextoBean contexto = ContextoUtil.getContextoBean();
        if (contexto.getDocumento() != null) {
            this.documento = contexto.getDocumento();
        }

    }

    public String editar() {
        ContextoBean contexto = ContextoUtil.getContextoBean();
        DocumentoRN documentoRN = new DocumentoRN();
        documentoRN.editar(this.documento, contexto.getUsuarioLogado());
        this.documento = new Documento();

        return "documento";
    }

    public String excluir() {

        DocumentoRN documentoRN = new DocumentoRN();
        UsuarioRN usuarioRN = new UsuarioRN();
        ContextoBean contexto = ContextoUtil.getContextoBean();
        try {
            arquivo.getStream().close();
            System.gc();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        documentoRN.excluir(this.documento, usuarioRN.buscarPorEmail(contexto.getUsuarioLogado().getEmail()));

        return "documento";
    }

    public void aprovar() {
        ContextoBean contexto = ContextoUtil.getContextoBean();
        DocumentoRN documentoRN = new DocumentoRN();
        documentoRN.aprovar(this.documento, contexto.getUsuarioLogado());
    }

    public void vincular() {
        this.documento.getDocumentos().add(this.docVinculado);
        this.vinculados = null;
    }

    public void desvincular() {
        this.documento.getDocumentos().remove(this.docVinculado);
    }

    public void download() {
        try {
            InputStream stream = new FileInputStream(new File(this.documento.getDiretorio(), this.documento.getNomeArquivo()));
            arquivo = new DefaultStreamedContent(stream, "application/pdf", this.documento.getNomeArquivo());

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado, não foi possivel efetuar o download");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Algum erro ao fazer o download");
            e.printStackTrace();
        }
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

    public List<Documento> getVinculados() {
        if (vinculados == null) {
            vinculados = new ArrayList<>();
            vinculados.addAll(documento.getDocumentos());
            vinculados.addAll(documento.getDocumentosOf());
        }

        return vinculados;
    }

    public List<Documento> getListarDocumento() {
        DocumentoRN docRN = new DocumentoRN();
        ContextoBean contexto = ContextoUtil.getContextoBean();
        listarDocumento=docRN.listarCodigo(contexto.getEmpresaAtiva(), contexto.getUsuarioLogado(), codigo);
        return listarDocumento;
    }
    
    public String visualizar(){
        
        return "documento-visualizar";
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public StreamedContent getArquivo() {

        return arquivo;
    }

    public Documento getDocVinculado() {
        return docVinculado;
    }

    public void setDocVinculado(Documento docVinculado) {
        this.docVinculado = docVinculado;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

}
