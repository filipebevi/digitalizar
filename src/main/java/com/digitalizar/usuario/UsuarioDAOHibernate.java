/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.usuario;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author filip
 */
public class UsuarioDAOHibernate implements UsuarioDAO {

    private Session session;

    public void setSession(Session session) {
        this.session = session;
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
    public Usuario buscarPorEmail(String email) {
        Criteria criteria = this.session.createCriteria(Usuario.class);
        criteria.add(Restrictions.eq("email", email));
        return (Usuario) criteria.uniqueResult();

    }

    @Override
    public List<Usuario> listar(String texto) {
        Criteria criteria = this.session.createCriteria(Usuario.class);
        if (texto != null) {
            
            Criterion nome = Restrictions.like("nome", "%"+texto+"%");
            Criterion email = Restrictions.like("email", "%"+texto+"%");
            LogicalExpression orExp = Restrictions.or(email, nome);
            criteria.add(orExp);
        }
        criteria.addOrder(Order.asc("nome"));
        return criteria.list();

    }

}
