/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.documento;

import com.digitalizar.empresa.Empresa;
import com.digitalizar.entidade.Entidade;
import com.digitalizar.tipodocumento.TipoDocumento;
import com.digitalizar.usuario.Usuario;
import java.util.Date;
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

    List<Documento> listar(Empresa empresa, Usuario usuario,String descricao ,TipoDocumento tipoDocumento, Entidade entidade,
            Date dataInicio, Date dataFim);
    
    List<Documento> naoAprovados(Empresa empresa, Usuario usuario);

    void salvar(Documento documento);
    
    void editar(Documento documento);
    
    Integer ultimoCodigoBD();
    
    Integer totalDoc(Empresa empresa);
    
    public Integer porUsuario(Empresa empresa, Usuario usuario);
    
    public Integer mesAnterior(Empresa empresa);
    
    public Integer mesAtual(Empresa empresa);
    
}
