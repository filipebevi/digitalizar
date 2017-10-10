/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.web;

import com.digitalizar.empresa.Empresa;
import com.digitalizar.empresa.EmpresaRN;
import com.digitalizar.web.util.MensagemUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
/**
 *
 * @author filip
 */
@ManagedBean
@RequestScoped
public class EmpresaBean{

    private Empresa empresa = new Empresa();
    private List<Empresa> listaEmpresa;

    public void salvar() {
        EmpresaRN empresaRN = new EmpresaRN();
        empresaRN.salvar(this.empresa);
        new MensagemUtil().sendMensagem("info","Empresa Cadastrada", "A empresa: "+empresa.getNome()+" foi cadastrada com sucesso!");
        this.empresa = new Empresa();
        this.listaEmpresa=null;
    }
    
    public String excluir(){
       EmpresaRN empresaRN=new EmpresaRN();
       empresaRN.excluir(this.empresa);
       this.listaEmpresa=null;
       return null;
   }
    
    public List<Empresa> getListaEmpresa() {
        if(this.listaEmpresa==null){
            EmpresaRN empresaRN= new EmpresaRN();
            this.listaEmpresa=empresaRN.listar();
        }
        
        return listaEmpresa;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

}
