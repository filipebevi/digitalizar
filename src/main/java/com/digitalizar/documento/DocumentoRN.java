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
import com.digitalizar.usuario.UsuarioRN;
import com.digitalizar.usuarioTipoDocumento.UsuarioTipoDocumento;
import com.digitalizar.util.DAOFactory;
import com.digitalizar.web.util.MensagemUtil;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.servlet.http.Part;
import javax.transaction.Transactional;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author filip
 */
@Transactional
public class DocumentoRN {

    private DocumentoDAO documentoDAO;

    public DocumentoRN() {
        this.documentoDAO = DAOFactory.criarDocumentoDAO();
    }

    public Documento carregar(Integer id) {
        return this.documentoDAO.carregar(id);
    }

    public Documento buscarPorCodigo(Integer id) {
        return this.documentoDAO.buscarPorCodigo(id);
    }

    public void salvar(Documento documento, Empresa empresa, Usuario usuario, Part file) {
        if (documento.getId() == null) {
            documento.setDataInclusao(Calendar.getInstance());
            documento.setUsuarioInclusao(usuario);
        }
        documento.setTamanho(file.getSize());
        documento.setEmpresa(empresa);
        documento.setDataEdicao(Calendar.getInstance());
        documento.setUsuarioEdicao(usuario);
        int ano = Calendar.getInstance().getTime().getYear() + 1900;
        int mes = Calendar.getInstance().getTime().getMonth() + 1;
        int dia = Calendar.getInstance().getTime().getDate();

        Integer ultimoCodigo = ultimoCodigoBR();
        String path = "C:" + File.separator
                + "UPLOAD" + File.separator
                + empresa.getNome() + File.separator
                + ano + File.separator
                + mes;
        String nomeArquivo = empresa.getNome() + " - "
                + ultimoCodigo + " - "
                + ano + mes + dia
                + file.getSubmittedFileName().substring(file.getSubmittedFileName().indexOf("."));
        documento.setDiretorio(path);
        documento.setNomeArquivo(nomeArquivo);
        File diretorio = new File(path);
        if (!diretorio.exists()) {
            boolean success = diretorio.mkdirs();
        }
        try (InputStream input = file.getInputStream()) {
            Files.copy(input, new File(path, nomeArquivo).toPath());
            this.documentoDAO.salvar(documento);

        } catch (Exception e) {
            System.out.println("O arquivo não foi salvo, erro durante a inserção ao banco ou na gravação do arquivo:" + e.getMessage());
            e.printStackTrace();

        }

    }

    public void editar(Documento documento, Usuario usuario) {
        boolean verifica = false;
        for (UsuarioTipoDocumento userTipo : usuario.getUsuarioTipoDocumento()) {
            if (userTipo.getTipoDocumento().getId().equals(documento.getTipoDocumento().getId()) && userTipo.getAlterar() == true) {
                documento.setDataEdicao(Calendar.getInstance());
                documento.setUsuarioEdicao(usuario);
                this.documentoDAO.editar(documento);
                verifica = true;
            }
        }
        if (!verifica) {
            new MensagemUtil().sendMensagem("alerta", "Usuário sem permissão para Alterar este tipo de documento", " ");
        }
    }

    public void excluir(Documento documento, Usuario usuario) {
        boolean verifica = false;
        for (UsuarioTipoDocumento userTipo : usuario.getUsuarioTipoDocumento()) {
            if (userTipo.getTipoDocumento().getId().equals(documento.getTipoDocumento().getId()) && userTipo.getExcluir() == true) {
                documento.setDataExclusao(Calendar.getInstance());
                documento.setUsuarioExclusao(usuario);
                this.documentoDAO.excluir(documento);

                verifica = true;
            }
        }
        if (!verifica) {
            new MensagemUtil().sendMensagem("alerta", "Usuário sem permissão para excluir este tipo de documento", " ");
        }

    }

    public void aprovar(Documento documento, Usuario usuario) {
        documento.setDataAprovacao(Calendar.getInstance());
        documento.setUsuarioAprovacao(usuario);

    }

    public List<Documento> listar(Empresa empresa, Usuario usuario, String descricao, 
            TipoDocumento tipoDocumento, Entidade entidade,
            Date dataInicio, Date dataFim,
            Double valorDe, Double valorAte, Date vencimentoDe, Date vencimentoAte, String numero) {
        UsuarioRN usuarioRN = new UsuarioRN();
        usuario = usuarioRN.buscarPorEmail(usuario.getEmail());
        return this.documentoDAO.listar(empresa, usuario, descricao, tipoDocumento, entidade, dataInicio, dataFim,
                valorDe, valorAte, vencimentoDe, vencimentoAte, numero);

    }

    public List<Documento> naoAprovados(Empresa empresa, Usuario usuario) {
        UsuarioRN usuarioRN = new UsuarioRN();
        usuario = usuarioRN.buscarPorEmail(usuario.getEmail());
        return this.documentoDAO.naoAprovados(empresa, usuario);
    }
    
    public List<Documento> listarCodigo(Empresa empresa, Usuario usuario, Integer codigo){
        UsuarioRN usuarioRN = new UsuarioRN();
        usuario = usuarioRN.buscarPorEmail(usuario.getEmail());
        return this.documentoDAO.listarCodigo(empresa, usuario, codigo);
    }

    public Integer ultimoCodigoBR() {
        return this.documentoDAO.ultimoCodigoBD();
    }

    public Integer totalDoc(Empresa empresa) {
        return this.documentoDAO.totalDoc(empresa);
    }

    public Integer porUsuario(Empresa empresa, Usuario usuario) {
        return this.documentoDAO.porUsuario(empresa, usuario);
    }

    public Integer mesAnterior(Empresa empresa) {
        return this.documentoDAO.mesAnterior(empresa);
    }

    public Integer mesAtual(Empresa empresa) {
        return this.documentoDAO.mesAtual(empresa);
    }

}
