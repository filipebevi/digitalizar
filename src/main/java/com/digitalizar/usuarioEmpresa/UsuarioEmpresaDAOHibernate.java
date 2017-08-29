/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.usuarioEmpresa;

import com.digitalizar.empresa.Empresa;
import com.digitalizar.usuario.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author filip
 */
public class UsuarioEmpresaDAOHibernate implements UsuarioEmpresaDAO {

    private Session session;

    public void setSession(Session session) {
        this.session = session;
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
    public Empresa buscarFavorita(Usuario usuario) {
        
        Criteria criteria =this.session.createCriteria(UsuarioEmpresa.class);
        criteria.add(Restrictions.eq("usuario", usuario));
        criteria.add(Restrictions.eq("padrao", true));
        UsuarioEmpresa usuarioEmpresa =  (UsuarioEmpresa) criteria.uniqueResult();
        Empresa padrao=usuarioEmpresa.getEmpresa();
        return  padrao;
        
      
    }

    @Override
    public List<Empresa> listar(Usuario usuario) {
        Criteria criteria = this.session.createCriteria(UsuarioEmpresa.class);
        criteria.add(Restrictions.eq("usuario", usuario));
        List<UsuarioEmpresa> usuarioEmpresas = criteria.list();
        List<Empresa> empresas =new ArrayList<Empresa>();
        for (int i = 0; i < usuarioEmpresas.size(); i++) {
            UsuarioEmpresa usuarioEmpresa = usuarioEmpresas.get(i);
            Empresa empresa=usuarioEmpresa.getEmpresa();
            empresas.add(empresa);
            empresa=null;
            usuarioEmpresa=null;
            
        }
        return empresas;
    }

}
