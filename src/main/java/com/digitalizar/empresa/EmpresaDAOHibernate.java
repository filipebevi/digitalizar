/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.empresa;


import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author filip
 */
public class EmpresaDAOHibernate implements EmpresaDAO {
    
    private Session session;
    public void setSession(Session session){
        this.session=session;
    }
    
    @Override
    public void salvar(Empresa empresa){
        session.saveOrUpdate(empresa);
    }
    
    @Override
    public void excluir(Empresa empresa){
        session.delete(empresa);
    }
    
    @Override
    public List<Empresa> listarEmpresa(){
        return session.createCriteria(Empresa.class).list();
    } 
    
    public Empresa carregar(Integer id){
        return (Empresa)session.get(Empresa.class, id );
    }
    
    
    
    
    
}
