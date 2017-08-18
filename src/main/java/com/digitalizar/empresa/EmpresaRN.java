/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.empresa;

import com.digitalizar.util.DAOFactory;

/**
 *
 * @author filip
 */
public class EmpresaRN {
    
    private EmpresaDAO empresaDAO;
    
    
    public EmpresaRN(){
        this.empresaDAO=DAOFactory.criarEmpresaDAO();
    }
    
    public void salvar(Empresa empresa){
        this.empresaDAO.salvar(empresa);
    }
    
}
