/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.usuarioEmpresa;

import java.util.List;

/**
 *
 * @author filip
 */
public interface UsuarioEmpresaDAO {

    void atualizar(UsuarioEmpresa usuarioEmpresa);

    UsuarioEmpresa buscarPorCodigo(Integer id);

    UsuarioEmpresa carregar(Integer idUsuarioEmpresa);

    void excluir(UsuarioEmpresa usuarioEmpresa);

    List<UsuarioEmpresa> listar();

    void salvar(UsuarioEmpresa usuarioEmpresa);
    
}
