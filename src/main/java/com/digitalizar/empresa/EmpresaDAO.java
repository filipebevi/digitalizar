/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.empresa;


import java.util.List;

/**
 *
 * @author filip
 */
public interface EmpresaDAO {

   

    void excluir(Empresa empresa);

    List<Empresa> listarEmpresa();

    void salvar(Empresa empresa);
    
    Empresa carregar(Integer id);
    
}
