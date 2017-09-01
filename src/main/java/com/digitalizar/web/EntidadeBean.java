/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.web;

import com.digitalizar.entidade.Entidade;
import com.digitalizar.entidade.EntidadeRN;
import com.digitalizar.web.util.ContextoUtil;
import com.digitalizar.web.util.MensagemUtil;
import java.util.Calendar;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author filip
 */
@ManagedBean
@RequestScoped
public class EntidadeBean {

    Entidade entidade = new Entidade();
    List<Entidade> listaEntidade;

    public void salvar() {
        ContextoBean contextoBean = ContextoUtil.getContextoBean();
        this.entidade.setEmpresa(contextoBean.getEmpresaAtiva());
        this.entidade.setUltima_alteracao(Calendar.getInstance());
        EntidadeRN entidadeRN = new EntidadeRN();
        entidadeRN.salvar(this.entidade);
        new MensagemUtil().sendMensagem("Tipo de Documento Cadastrado com sucesso!", "");
        this.entidade = new Entidade();
        this.listaEntidade = null;
    }

    public void excluir() {
        EntidadeRN entidadeRN = new EntidadeRN();
        entidadeRN.excluir(this.entidade);
        this.entidade = null;
    }

    public Entidade getEntidade() {
        return entidade;
    }

    public void setEntidade(Entidade entidade) {
        this.entidade = entidade;
    }

    public List<Entidade> getListaEntidade() {
        if (this.listaEntidade == null) {
            ContextoBean contextoBean = ContextoUtil.getContextoBean();
            EntidadeRN entidadeRN = new EntidadeRN();
            this.listaEntidade = entidadeRN.listar(contextoBean.getEmpresaAtiva());
        }
        return this.listaEntidade;
    }

}
