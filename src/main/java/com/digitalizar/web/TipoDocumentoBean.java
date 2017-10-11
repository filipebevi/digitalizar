/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.web;

import com.digitalizar.empresa.Empresa;
import com.digitalizar.tipodocumento.Extensao;
import com.digitalizar.tipodocumento.TipoDocumento;
import com.digitalizar.tipodocumento.TipoDocumentoRN;
import com.digitalizar.web.util.ContextoUtil;
import com.digitalizar.web.util.MensagemUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.DualListModel;

/**
 *
 * @author filip
 */
@ManagedBean
@ViewScoped
public class TipoDocumentoBean implements Serializable {

    TipoDocumento tipoDocumento = new TipoDocumento();
    List<TipoDocumento> listarTipo;
    private DualListModel<Extensao> listModel;

    @PostConstruct
    public void init() {
        TipoDocumentoRN tipoRN=new TipoDocumentoRN();

        listModel = new DualListModel<Extensao>(tipoRN.listarExtensoes(), new ArrayList<Extensao>());
    }

    public void salvar() {
        ContextoBean contextoBean = ContextoUtil.getContextoBean();
        this.tipoDocumento.setEmpresa(contextoBean.getEmpresaAtiva());
        TipoDocumentoRN tipoDocumentoRN = new TipoDocumentoRN();
        tipoDocumentoRN.salvar(this.tipoDocumento);
        new MensagemUtil().sendMensagem("info", "Tipo de Documento Cadastrado com sucesso!", "");
        this.tipoDocumento = new TipoDocumento();
        this.listarTipo = null;
    }

    public void excluir() {
        TipoDocumentoRN tipoDocumentoRN = new TipoDocumentoRN();
        tipoDocumentoRN.excluir(this.tipoDocumento);
        this.listarTipo = null;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public List<TipoDocumento> getListarTipo() {
        if (this.listarTipo == null) {
            ContextoBean contextoBean = ContextoUtil.getContextoBean();
            TipoDocumentoRN tipoDocumentoRN = new TipoDocumentoRN();
            this.listarTipo = tipoDocumentoRN.listar(contextoBean.getEmpresaAtiva());
        }

        return listarTipo;
    }

    public DualListModel<Extensao> getListModel() {
        return listModel;
    }

    public void setListModel(DualListModel<Extensao> listModel) {
        this.listModel = listModel;
    }

}
