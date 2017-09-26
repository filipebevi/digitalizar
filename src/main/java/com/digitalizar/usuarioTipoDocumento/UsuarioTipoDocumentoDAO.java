/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.usuarioTipoDocumento;

import com.digitalizar.tipodocumento.TipoDocumento;
import com.digitalizar.usuario.Usuario;
import java.util.List;

/**
 *
 * @author filip
 */
public interface UsuarioTipoDocumentoDAO {

    void atualizar(UsuarioTipoDocumento usuarioTipoDocumento);

    UsuarioTipoDocumento buscarPorCodigo(Integer id);

    UsuarioTipoDocumento carregar(Integer idUsuarioTipoDocumento);

    void excluir(UsuarioTipoDocumento usuarioTipoDocumento);

    List<UsuarioTipoDocumento> listar(Usuario usuario);

    void salvar(UsuarioTipoDocumento usuarioTipoDocumento);
    
}
