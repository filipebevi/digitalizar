/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.empresa;

import com.digitalizar.empresa.Empresa;
import com.digitalizar.util.DAOFactory;
import java.util.List;

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
    
    public void excluir(Empresa empresa){
        this.empresaDAO.excluir(empresa);
    }
    
    public List<Empresa> listar(){
        return this.empresaDAO.listarEmpresa();
    }
    
    public Empresa carregar(Integer id){
        return this.empresaDAO.carregar(id);
    }
    
}
