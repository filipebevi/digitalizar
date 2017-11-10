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
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
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
    public void editar(Documento documento) {
        this.session.update(documento);

    }

    @Override
    public void atualizar(Documento documento) {
        this.session.update(documento);
    }

    @Override
    public void excluir(Documento documento) {

        this.session.update(documento);
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
    public List<Documento> listar(Empresa empresa, Usuario usuario, String descricao, TipoDocumento tipoDocumento, Entidade entidade,
            Date dataInicio, Date dataFim, Double valorDe, Double valorAte, Date vencimentoDe, Date vencimentoAte, String numero) {
        List<Documento> resultado = null;
        Criteria criteria = this.session.createCriteria(Documento.class);
        List<TipoDocumento> tipoDocumentos = new ArrayList<>();
        for (UsuarioTipoDocumento userTipoDoc : usuario.getUsuarioTipoDocumento()) {
            if (userTipoDoc.getVisualizar() && userTipoDoc.getTipoDocumento().getEmpresa().getId().equals(empresa.getId())) {
                tipoDocumentos.add(userTipoDoc.getTipoDocumento());
            }
        }
        criteria.add(Restrictions.isNull("dataExclusao"));
        criteria.add(Restrictions.in("tipoDocumento", tipoDocumentos));
        if (tipoDocumento != null) {
            criteria.add(Restrictions.eq("tipoDocumento", tipoDocumento));
        }

        if (entidade != null) {
            criteria.add(Restrictions.eq("entidade", entidade));
        }
        if (dataInicio != null && dataFim != null) {
            criteria.add(Restrictions.or(Restrictions.between("competencia", dataInicio, dataFim),
                                         Restrictions.or(Restrictions.or(Restrictions.and(Restrictions.le("periodoInicial", dataInicio),Restrictions.ge("periodoFinal", dataInicio)),
                                                                         Restrictions.and(Restrictions.le("periodoInicial", dataFim),Restrictions.ge("periodoFinal", dataFim))),
                                                        Restrictions.or(Restrictions.between("periodoInicial", dataInicio, dataFim),Restrictions.between("periodoFinal", dataInicio, dataFim)))));
                                                 
                                               
        }

        if (descricao != null) {
            if (!numero.isEmpty()) {
                criteria.add(Restrictions.ilike("descricao", "%" + descricao + "%"));
            }

        }
        if (numero != null) {
            if (!numero.isEmpty()) {
                criteria.add(Restrictions.ilike("numero", "%" + numero + "%"));
            }
        }
        if (vencimentoDe != null && vencimentoAte != null) {
            criteria.add(Restrictions.between("vencimento", vencimentoDe, vencimentoAte));
        }
        if (valorDe != null && valorAte != null) {
            criteria.add(Restrictions.between("valor", valorDe, valorAte));
        }

        criteria.addOrder(Order.asc("tipoDocumento"));

        if (!tipoDocumentos.isEmpty()) {
            resultado = criteria.list();
        }

        return resultado;
    }

    public Criteria listagem(Empresa empresa, Usuario usuario) {

        Criteria criteria = this.session.createCriteria(Documento.class);

        if (!criteria.list().isEmpty()) {
            List<TipoDocumento> tipoDocumentos = new ArrayList<>();
            for (UsuarioTipoDocumento userTipoDoc : usuario.getUsuarioTipoDocumento()) {
                if (userTipoDoc.getVisualizar() && userTipoDoc.getTipoDocumento().getEmpresa().getId().equals(empresa.getId())) {
                    tipoDocumentos.add(userTipoDoc.getTipoDocumento());
                }
            }
            criteria.add(Restrictions.isNull("dataExclusao"));
            criteria.add(Restrictions.in("tipoDocumento", tipoDocumentos));//necessita ter pelo menos 1 tipo de documento com visualizar para a empresa
        } else {
            criteria = null;
        }

        return criteria;

    }
    @Override
    public List<Documento> listarCodigo(Empresa empresa, Usuario usuario, Integer codigo){
        Criteria criteria = listagem(empresa, usuario);
        if(codigo!=null){
            criteria.add(Restrictions.eq("id", codigo));
        }else{
            return null;
        }
        
        return criteria.list();
    }

    @Override
    public List<Documento> naoAprovados(Empresa empresa, Usuario usuario) {

        List<Documento> resultado = new ArrayList<>();
        Criteria criteria = listagem(empresa, usuario);

        if (criteria != null) {

            criteria.add(Restrictions.isNull("dataAprovacao"));

            resultado.addAll(criteria.list());

        }

        return resultado;
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

    @Override
    public Integer totalDoc(Empresa empresa) {
        Criteria criteria = this.session.createCriteria(Documento.class);
        criteria.add(Restrictions.isNull("dataExclusao"));
        criteria.add(Restrictions.eq("empresa", empresa));
        criteria.setProjection(Projections.rowCount());
        return Integer.parseInt(criteria.uniqueResult().toString());

    }

    @Override
    public Integer porUsuario(Empresa empresa, Usuario usuario) {
        Criteria criteria = this.session.createCriteria(Documento.class);
        criteria.add(Restrictions.isNull("dataExclusao"));
        criteria.add(Restrictions.eq("empresa", empresa));
        criteria.add(Restrictions.eq("usuarioInclusao", usuario));
        criteria.setProjection(Projections.rowCount());
        return Integer.parseInt(criteria.uniqueResult().toString());

    }

    @Override
    public Integer mesAnterior(Empresa empresa) {
        Criteria criteria = this.session.createCriteria(Documento.class);
        criteria.add(Restrictions.isNull("dataExclusao"));
        criteria.add(Restrictions.eq("empresa", empresa));
        //criteria.add(Restrictions.eq("MONTH(data_inclusao)", Calendar.getInstance().get(2)-1));
        criteria.add(Restrictions.sqlRestriction("YEAR(data_inclusao)=" + Calendar.getInstance().get(1)));
        criteria.add(Restrictions.sqlRestriction("MONTH(data_inclusao)=" + Calendar.getInstance().get(2)));
        criteria.setProjection(Projections.rowCount());
        return Integer.parseInt(criteria.uniqueResult().toString());

    }

    @Override
    public Integer mesAtual(Empresa empresa) {
        Criteria criteria = this.session.createCriteria(Documento.class);
        criteria.add(Restrictions.isNull("dataExclusao"));
        criteria.add(Restrictions.eq("empresa", empresa));
        Integer mesAtual = Calendar.getInstance().get(2) + 1;
        Integer anoAtual = Calendar.getInstance().get(1);

        criteria.add(Restrictions.sqlRestriction("YEAR(data_inclusao)=" + anoAtual));
        criteria.add(Restrictions.sqlRestriction("MONTH(data_inclusao)=" + mesAtual));
        criteria.setProjection(Projections.rowCount());
        return Integer.parseInt(criteria.uniqueResult().toString());

    }

}
