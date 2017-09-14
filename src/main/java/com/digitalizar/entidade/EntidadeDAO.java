/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.entidade;

import com.digitalizar.empresa.Empresa;
import java.util.List;

/**
 *
 * @author filip
 */
public interface EntidadeDAO {

    void atualizar(Entidade entidade);

    Entidade buscarPorCodigo(Integer id);

    Entidade carregar(Integer idEntidade);

    void excluir(Entidade entidade);

    List<Entidade> listar(Empresa empresa);

    void salvar(Entidade entidade);
    
 
    
}
