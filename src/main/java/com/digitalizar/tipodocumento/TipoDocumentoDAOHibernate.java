/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.tipodocumento;


import com.digitalizar.empresa.Empresa;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author filip
 */
public class TipoDocumentoDAOHibernate implements TipoDocumentoDAO {
    
    private Session session;
    public void setSession(Session session){
        this.session=session;
    }
    
    
    
    
    @Override
    public void salvar(TipoDocumento tipoDocumento) {
        this.session.saveOrUpdate(tipoDocumento);
        
    }
    

    
    
    @Override
    public void atualizar(TipoDocumento tipoDocumento) {
        this.session.update(tipoDocumento);
    }
    

    
    
    @Override
    public void excluir(TipoDocumento tipoDocumento) {
        this.session.delete(tipoDocumento);
    }
    

    
    
    @Override
    public TipoDocumento carregar(Integer idTipoDocumento) {
        return (TipoDocumento) this.session.get(TipoDocumento.class, idTipoDocumento);
       
    }
    

    
    
    @Override
    public TipoDocumento buscarPorCodigo(Integer id) {
        String hql="select u from TipoDocumento u where u.id =:id";
        Query consulta = (Query) this.session.createCriteria(hql);
        consulta.setInteger("Codigo", id);
        return (TipoDocumento) consulta.uniqueResult();
    }
    
    @Override
    public List<TipoDocumento> listar(Empresa empresa) {
        Criteria criteria = this.session.createCriteria(TipoDocumento.class);
        criteria.add(Restrictions.eq("empresa", empresa));
        return criteria.list();
    }
    
    @Override
    public List<Extensao> listarExtensao(){
        Criteria criteria = this.session.createCriteria(Extensao.class);
        return criteria.list();
    }
    
    
}
