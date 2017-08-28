/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.usuario;

import java.util.List;

/**
 *
 * @author filip
 */
public interface UsuarioDAO {

    void atualizar(Usuario usuario);

    Usuario buscarPorEmail(String email);

    Usuario carregar(Integer idUsuario);

    void excluir(Usuario usuario);

    List<Usuario> listar();

    void salvar(Usuario usuario);
    
}
