/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.web;

import com.digitalizar.empresa.Empresa;
import com.digitalizar.empresa.EmpresaRN;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author filip
 */
@ManagedBean
@RequestScoped
public class EmpresaBean {

    private Empresa empresa = new Empresa();
    private List<Empresa> listaEmpresa;

    public String novo() {

        this.empresa = new Empresa();

        return "empresa";
    }

    public String salvar() {
        EmpresaRN empresaRN = new EmpresaRN();
        empresaRN.salvar(this.empresa);
        this.empresa = null;

        return "empresa";

    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Empresa> getListaEmpresa() {
        if(this.listaEmpresa==null){
            EmpresaRN empresaRN= new EmpresaRN();
            this.listaEmpresa=empresaRN.listar();
        }
        
        return listaEmpresa;
    }

   

}
