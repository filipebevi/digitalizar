/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.usuario;


import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author filip
 */
public class UsuarioDAOHibernate implements UsuarioDAO {
    
    private Session session;
    public void setSession(Session session){
        this.session=session;
    }
    
    
    
    
    @Override
    public void salvar(Usuario usuario) {
        this.session.saveOrUpdate(usuario);
        
    }
    

    
    
    @Override
    public void atualizar(Usuario usuario) {
        this.session.update(usuario);
    }
    

    
    
    @Override
    public void excluir(Usuario usuario) {
        this.session.delete(usuario);
    }
    

    
    
    @Override
    public Usuario carregar(Integer idUsuario) {
        return (Usuario) this.session.get(Usuario.class, idUsuario);
       
    }
    

    
    
    @Override
    public Usuario buscarPorCodigo(Integer id) {
        String hql="select u from Usuario u where u.id =:id";
        Query consulta = (Query) this.session.createCriteria(hql);
        consulta.setInteger("Codigo", id);
        return (Usuario) consulta.uniqueResult();
    }
    
  
    
    
    @Override
    public List<Usuario> listar() {
        return this.session.createCriteria(Usuario.class).list();
    }
    
    
}
