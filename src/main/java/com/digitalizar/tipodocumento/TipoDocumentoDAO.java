/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.tipodocumento;

import java.util.List;

/**
 *
 * @author filip
 */
public interface TipoDocumentoDAO {

    void atualizar(TipoDocumento tipoDocumento);

    TipoDocumento buscarPorCodigo(Integer id);

    TipoDocumento carregar(Integer idTipoDocumento);

    void excluir(TipoDocumento tipoDocumento);

    List<TipoDocumento> listar();

    void salvar(TipoDocumento tipoDocumento);
    
}
