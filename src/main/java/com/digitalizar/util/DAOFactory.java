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
import com.digitalizar.entidade.EntidadeDAO;
import com.digitalizar.entidade.EntidadeDAOHibernate;
import com.digitalizar.tipodocumento.TipoDocumentoDAO;
import com.digitalizar.tipodocumento.TipoDocumentoDAOHibernate;
import com.digitalizar.usuario.UsuarioDAO;
import com.digitalizar.usuario.UsuarioDAOHibernate;
import com.digitalizar.usuarioEmpresa.UsuarioEmpresaDAO;
import com.digitalizar.usuarioEmpresa.UsuarioEmpresaDAOHibernate;
import com.digitalizar.usuarioTipoDocumento.UsuarioTipoDocumentoDAO;
import com.digitalizar.usuarioTipoDocumento.UsuarioTipoDocumentoDAOHibernate;



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
    
    public static EntidadeDAO criarEntidadeDAO(){
        EntidadeDAOHibernate entidadeDAO=new EntidadeDAOHibernate();
        entidadeDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return entidadeDAO;
    }
    
    public static TipoDocumentoDAO criarTipoDocumentoDAO(){
        TipoDocumentoDAOHibernate tipoDocumentoDAO=new TipoDocumentoDAOHibernate();
        tipoDocumentoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return tipoDocumentoDAO;
    }
    
     public static UsuarioDAO criarUsuarioDAO(){
         UsuarioDAOHibernate usuarioDAO=new UsuarioDAOHibernate();
        usuarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return usuarioDAO;
    }
     
     public static UsuarioEmpresaDAO criarUsuarioEmpresaDAO(){
         UsuarioEmpresaDAOHibernate usuarioEmpresaDAO=new UsuarioEmpresaDAOHibernate();
        usuarioEmpresaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return usuarioEmpresaDAO;
    }
     
     public static UsuarioTipoDocumentoDAO criarUsuarioTipoDocumentoDAO(){
         UsuarioTipoDocumentoDAOHibernate usuarioTipoDocumentoDAO=new UsuarioTipoDocumentoDAOHibernate();
        usuarioTipoDocumentoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return usuarioTipoDocumentoDAO;
    }
    
    
}
