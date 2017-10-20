/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.tipodocumento;


import com.digitalizar.empresa.Empresa;
import com.digitalizar.util.DAOFactory;
import java.util.List;

/**
 *
 * @author filip
 */
public class TipoDocumentoRN {
    
    private TipoDocumentoDAO tipoDocumentoDAO;
    
    
    public TipoDocumentoRN(){
        this.tipoDocumentoDAO=DAOFactory.criarTipoDocumentoDAO();
    }
    
    public void salvar(TipoDocumento tipoDocumento){
        this.tipoDocumentoDAO.salvar(tipoDocumento);
    }
    
    public void excluir(TipoDocumento tipoDocumento){
        this.tipoDocumentoDAO.excluir(tipoDocumento);
    }
    
    public List<TipoDocumento> listar(Empresa empresa){
        return this.tipoDocumentoDAO.listar(empresa);
    }
    
    public TipoDocumento carregar(Integer id){
        TipoDocumento resultado=null;
        if(id!=null){
            resultado=this.tipoDocumentoDAO.carregar(id);
        }
        return resultado;
    }
    
    public List<Extensao> listarExtensao(){
        return this.tipoDocumentoDAO.listarExtensao();
    }
   
}
