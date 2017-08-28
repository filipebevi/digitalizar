/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.entidade;

import com.digitalizar.entidade.Entidade;
import com.digitalizar.entidade.EntidadeDAO;
import com.digitalizar.util.DAOFactory;
import java.util.List;

/**
 *
 * @author filip
 */
public class EntidadeRN {
    
    private EntidadeDAO entidadeDAO;
    
    
    public EntidadeRN(){
        this.entidadeDAO=DAOFactory.criarEntidadeDAO();
    }
    
    public void salvar(Entidade entidade){
        this.entidadeDAO.salvar(entidade);
    }
    
    public void excluir(Entidade entidade){
        this.entidadeDAO.excluir(entidade);
    }
    
    public List<Entidade> listar(){
        return this.entidadeDAO.listar();
    }
    
}
