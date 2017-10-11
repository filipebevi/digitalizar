/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.tipodocumento;

import com.digitalizar.empresa.Empresa;
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

    List<TipoDocumento> listar(Empresa empresa);

    void salvar(TipoDocumento tipoDocumento);

    List<Extensao> listarExtensoes();

}
