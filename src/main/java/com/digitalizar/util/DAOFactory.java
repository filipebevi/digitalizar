/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.util;

import com.digitalizar.documento.DocumentoDAO;
import com.digitalizar.documento.DocumentoDAOHibernate;
import com.digitalizar.empresa.EmpresaDAO;
import com.digitalizar.empresa.EmpresaDAOHibernate;



/**
 *
 * @author Flipe
 */
public class DAOFactory {
    
    public static DocumentoDAO criarDocumentoDAO(){
        DocumentoDAOHibernate documentoDAO=new DocumentoDAOHibernate();
        documentoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return documentoDAO;
    }
    
    public static EmpresaDAO criarEmpresaDAO(){
        EmpresaDAOHibernate empresaDAO=new EmpresaDAOHibernate();
        empresaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return empresaDAO;
    }
    
    
}
