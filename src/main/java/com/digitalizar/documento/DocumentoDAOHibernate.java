/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.documento;

import com.digitalizar.empresa.Empresa;
import com.digitalizar.entidade.Entidade;
import com.digitalizar.tipodocumento.TipoDocumento;
import com.digitalizar.usuario.Usuario;
import com.digitalizar.usuarioTipoDocumento.UsuarioTipoDocumento;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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
    public List<Documento> listar(Empresa empresa, Usuario usuario) {
        Criteria criteria = this.session.createCriteria(Documento.class);
        List<TipoDocumento> tipoDocumentos = new ArrayList<>();
        for (UsuarioTipoDocumento userTipoDoc : usuario.getUsuarioTipoDocumento()) {
            if (userTipoDoc.getVisualizar() && userTipoDoc.getTipoDocumento().getEmpresa().getId().equals(empresa.getId())) {
                tipoDocumentos.add(userTipoDoc.getTipoDocumento());
            }
        }
        criteria.add(Restrictions.in("tipo_documento",tipoDocumentos));
        criteria.addOrder(Order.asc("tipo_documento"));
        
        

        
        return criteria.list();

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
