/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.documento;

import com.digitalizar.empresa.Empresa;
import java.util.List;

/**
 *
 * @author filip
 */
public interface DocumentoDAO {

    void atualizar(Documento documento);

    Documento buscarPorCodigo(Integer id);

    Documento carregar(Integer idDocumento);

    void excluir(Documento documento);

    List<Documento> listar();

    void salvar(Documento documento);
    
}
