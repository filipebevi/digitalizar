/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.usuarioTipoDocumento;



import com.digitalizar.usuario.Usuario;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author filip
 */
public class UsuarioTipoDocumentoDAOHibernate implements UsuarioTipoDocumentoDAO {
    
    
    private Session session;
    public void setSession(Session session){
        this.session=session;
    }
    
    
    
    
    @Override
    public void salvar(UsuarioTipoDocumento usuarioTipoDocumento) {
        this.session.saveOrUpdate(usuarioTipoDocumento);
        
    }
    

    
    
    @Override
    public void atualizar(UsuarioTipoDocumento usuarioTipoDocumento) {
        this.session.update(usuarioTipoDocumento);
    }
    

    
    
    @Override
    public void excluir(UsuarioTipoDocumento usuarioTipoDocumento) {
        this.session.delete(usuarioTipoDocumento);
    }
    

    
    
    @Override
    public UsuarioTipoDocumento carregar(Integer idUsuarioTipoDocumento) {
        return (UsuarioTipoDocumento) this.session.get(UsuarioTipoDocumento.class, idUsuarioTipoDocumento);
       
    }
    

    
    
    @Override
    public UsuarioTipoDocumento buscarPorCodigo(Integer id) {
        String hql="select u from UsuarioTipoDocumento u where u.id =:id";
        Query consulta = (Query) this.session.createCriteria(hql);
        consulta.setInteger("Codigo", id);
        return (UsuarioTipoDocumento) consulta.uniqueResult();
    }
    
  
    
    
    @Override
    public List<UsuarioTipoDocumento> listar(Usuario usuario) {
        Criteria criteria = this.session.createCriteria(UsuarioTipoDocumento.class);
        criteria.add(Restrictions.eq("usuario", usuario));
        List<UsuarioTipoDocumento> usuarioTipoDocumentos = criteria.list();
        
       
        return usuarioTipoDocumentos;
    }
    
}
