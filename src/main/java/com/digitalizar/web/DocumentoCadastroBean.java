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

    public void salvar() {

        ContextoBean contexto = ContextoUtil.getContextoBean();
        if (this.documento.getId() == null) {
            this.documento.setData_inclusao(Calendar.getInstance());
            this.documento.setUsuario_inclusao(contexto.getUsuarioLogado());
        }
        this.documento.setTamanho(file.getSize());
        this.documento.setEmpresa(contexto.getEmpresaAtiva());
        this.documento.setUlt_alteracao(Calendar.getInstance());
        this.documento.setUsuarioAlteracao(contexto.getUsuarioLogado());
        this.documento.setPeriodo_final(Calendar.getInstance());
        int ano=this.documento.getPeriodo_final().getTime().getYear()+1900;
        int mes=this.documento.getPeriodo_final().getTime().getMonth()+1;
        String path = "C:" + File.separator
                + "UPLOAD" + File.separator
                + contexto.getEmpresaAtiva().getNome() + File.separator
                + this.documento.getTipo_documento().getDescricao()+ File.separator
                + ano+ File.separator
                + mes;
        String nomeArquivo = contexto.getEmpresaAtiva().getNome() + " - "
                + this.documento.getTipo_documento().getDescricao() + " - "
                + this.documento.getEntidade().getNome()+file.getSubmittedFileName().substring(file.getSubmittedFileName().indexOf("."));
        System.out.println("nome do arquivo"+this.file.getName());
        System.out.println("submited "+this.file.getSubmittedFileName());
        System.out.println("tipo "+this.file.getContentType());
         this.documento.setPath(path);
        this.documento.setNome(nomeArquivo);
        File diretorio = new File(path);
        if (!diretorio.exists()) {
            boolean success=diretorio.mkdirs();
        }
        try (InputStream input = file.getInputStream()){
            Files.copy(input, new File(path, nomeArquivo).toPath());
            DocumentoRN documentoRN = new DocumentoRN();
            documentoRN.salvar(this.documento);

        } catch (Exception e) {
            System.out.println("o erro é:"+e.getMessage());
            
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
