/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.web;

import com.digitalizar.documento.Documento;
import com.digitalizar.documento.DocumentoRN;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import org.primefaces.component.media.Media;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author filip
 */
@ManagedBean
@ApplicationScoped
public class ArquivoBean implements Serializable{//classe de teste porem não esta sendo usada
    

    public StreamedContent getStream() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();

        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            // So, we're rendering the HTML. Return a stub StreamedContent so that it will generate right URL.
            return new DefaultStreamedContent();
        } else {
            // So, browser is requesting the media. Return a real StreamedContent with the media bytes.
            String id = context.getExternalContext().getRequestParameterMap().get("id");
            DocumentoRN docRN = new DocumentoRN();
            int a = Integer.getInteger(id);
            Documento documento = docRN.carregar(a);
            InputStream stream = new FileInputStream(new File(documento.getDiretorio(), documento.getNomeArquivo()));
            return new DefaultStreamedContent(stream, "application/pdf", documento.getNomeArquivo());
            
        }
    }
}
