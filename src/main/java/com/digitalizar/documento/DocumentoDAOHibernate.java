/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.documento;

import java.math.BigInteger;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author filip
 */
public class DocumentoDAOHibernate implements DocumentoDAO {

    private Session session;

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void salvar(Documento documento) {
        this.session.saveOrUpdate(documento);

    }

    @Override
    public void atualizar(Documento documento) {
        this.session.update(documento);
    }

    @Override
    public void excluir(Documento documento) {
        this.session.delete(documento);
    }

    @Override
    public Documento carregar(Integer idDocumento) {
        return (Documento) this.session.get(Documento.class, idDocumento);

    }

    @Override
    public Documento buscarPorCodigo(Integer id) {
        String hql = "select u from Documento u where u.id =:id";
        Query consulta = (Query) this.session.createCriteria(hql);
        consulta.setInteger("Codigo", id);
        return (Documento) consulta.uniqueResult();
    }

    @Override
    public List<Documento> listar() {
        return this.session.createCriteria(Documento.class).list();
    }

    @Override
    public Integer ultimoCodigoBD() {

        BigInteger numero = null;
        try {
            String hql = "select auto_increment from information_schema.tables "
                    + "where TABLE_SCHEMA='digitalizardb' and table_name='documento'";
            Query consulta = session.createSQLQuery(hql);
            numero = (BigInteger) consulta.uniqueResult();

        } catch (Exception e) {
            System.out.println("Erro ao pegar o ultimo codigo: " + e.getMessage() + e.getLocalizedMessage());
        }
        return numero.intValue();
    }

}
