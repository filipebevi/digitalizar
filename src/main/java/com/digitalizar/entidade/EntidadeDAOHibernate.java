/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.entidade;

import com.digitalizar.entidade.Entidade;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author filip
 */
public class EntidadeDAOHibernate implements EntidadeDAO {
    
    private Session session;
    public void setSession(Session session){
        this.session=session;
    }
    
    
    
    
    @Override
    public void salvar(Entidade entidade) {
        this.session.saveOrUpdate(entidade);
        
    }
    

    
    
    @Override
    public void atualizar(Entidade entidade) {
        this.session.update(entidade);
    }
    

    
    
    @Override
    public void excluir(Entidade entidade) {
        this.session.delete(entidade);
    }
    

    
    
    @Override
    public Entidade carregar(Integer idEntidade) {
        return (Entidade) this.session.get(Entidade.class, idEntidade);
       
    }
    

    
    
    @Override
    public Entidade buscarPorCodigo(Integer id) {
        String hql="select u from Entidade u where u.id =:id";
        Query consulta = (Query) this.session.createCriteria(hql);
        consulta.setInteger("Codigo", id);
        return (Entidade) consulta.uniqueResult();
    }
    
  
    
    
    @Override
    public List<Entidade> listar() {
        return this.session.createCriteria(Entidade.class).list();
    }
    
}
