/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.usuarioEmpresa;


import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author filip
 */
public class UsuarioEmpresaDAOHibernate implements UsuarioEmpresaDAO {
    
    private Session session;
    public void setSession(Session session){
        this.session=session;
    }
    
    
    
    
    @Override
    public void salvar(UsuarioEmpresa usuarioEmpresa) {
        this.session.saveOrUpdate(usuarioEmpresa);
        
    }
    

    
    
    @Override
    public void atualizar(UsuarioEmpresa usuarioEmpresa) {
        this.session.update(usuarioEmpresa);
    }
    

    
    
    @Override
    public void excluir(UsuarioEmpresa usuarioEmpresa) {
        this.session.delete(usuarioEmpresa);
    }
    

    
    
    @Override
    public UsuarioEmpresa carregar(Integer idUsuarioEmpresa) {
        return (UsuarioEmpresa) this.session.get(UsuarioEmpresa.class, idUsuarioEmpresa);
       
    }
    

    
    
    @Override
    public UsuarioEmpresa buscarPorCodigo(Integer id) {
        String hql="select u from UsuarioEmpresa u where u.id =:id";
        Query consulta = (Query) this.session.createCriteria(hql);
        consulta.setInteger("Codigo", id);
        return (UsuarioEmpresa) consulta.uniqueResult();
    }
    
  
    
    
    @Override
    public List<UsuarioEmpresa> listar() {
        return this.session.createCriteria(UsuarioEmpresa.class).list();
    }
    
}
