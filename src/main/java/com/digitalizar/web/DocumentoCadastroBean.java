/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.web;

import com.digitalizar.documento.Documento;
import com.digitalizar.documento.DocumentoRN;
import com.digitalizar.web.util.ContextoUtil;
import java.io.File;
import java.util.Calendar;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Flipe
 */
@ManagedBean
@ViewScoped
public class DocumentoCadastroBean {

    Documento documentoVinculado;
    Documento documento;
    UploadedFile file;

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
        String path = "c:"+File.separator+"Upload"+contexto.getEmpresaAtiva().getNome()+File.separator+this.documento.getTipo_documento().getDescricao()+File.separator+this.documento.getPeriodo_final().getTime().getYear()+File.separator+this.documento.getPeriodo_final().getTime().getMonth();
        String nomeArquivo = contexto.getEmpresaAtiva().getNome()+" - "+this.documento.getTipo_documento().getDescricao()+" - "+this.documento.getEntidade().getNome()+file.getContentType();
        File diretorio = new File(path);
        if(!diretorio.exists()){
            diretorio.mkdir();
        }
        try {
            file.write(path+File.separator+nomeArquivo);
            DocumentoRN documentoRN=new DocumentoRN();
            documentoRN.salvar(this.documento);
            
        } catch (Exception e) {
        }
    }

}
