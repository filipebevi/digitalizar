/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.documento;

import com.digitalizar.empresa.Empresa;
import com.digitalizar.util.DAOFactory;
import java.io.File;
import java.util.List;



/**
 *
 * @author filip
 */
public class DocumentoRN {
    
     private DocumentoDAO documentoDAO;
    
    public DocumentoRN(){
        this.documentoDAO = DAOFactory.criarDocumentoDAO();
    }
    
    public Documento carregar(Integer id){
        return this.documentoDAO.carregar(id);
    }
    
    public Documento buscarPorCodigo(Integer id){
        return this.documentoDAO.buscarPorCodigo(id);
    }
    
    public void salvar(Documento documento){
        
        this.documentoDAO.salvar(documento);
    
    }
    
    public void excluir(Documento documento){
        this.documentoDAO.excluir(documento);
    }
    
    public List<Documento> listar(){
        return this.documentoDAO.listar();
    }
    
}
