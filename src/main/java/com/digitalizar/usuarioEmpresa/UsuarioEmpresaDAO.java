/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.usuarioEmpresa;

import com.digitalizar.empresa.Empresa;
import com.digitalizar.usuario.Usuario;
import java.util.List;

/**
 *
 * @author filip
 */
public interface UsuarioEmpresaDAO {

    void atualizar(UsuarioEmpresa usuarioEmpresa);

    Empresa buscarFavorita(Usuario usuario);

    UsuarioEmpresa carregar(Integer idUsuarioEmpresa);

    void excluir(UsuarioEmpresa usuarioEmpresa);

    List<Empresa> listar(Usuario usuario);

    void salvar(UsuarioEmpresa usuarioEmpresa);
    
}
