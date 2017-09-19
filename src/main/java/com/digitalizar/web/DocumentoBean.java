/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.web;

import com.digitalizar.documento.Documento;
import com.digitalizar.documento.DocumentoRN;
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
public class DocumentoBean {
    
    Documento documento;
    List<Documento> lista;

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public List<Documento> getLista() {
        ContextoBean contexto = ContextoUtil.getContextoBean();
        DocumentoRN documentoRN = new DocumentoRN();
        return documentoRN.listar(contexto.getEmpresaAtiva(), contexto.getUsuarioLogado());
    }

    
    
    
}
