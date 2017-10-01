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
            documento.setData_inclusao(Calendar.getInstance());
            documento.setUsuario_inclusao(usuario);
        }
        documento.setTamanho(file.getSize());
        documento.setEmpresa(empresa);
        documento.setUlt_alteracao(Calendar.getInstance());
        documento.setUsuarioAlteracao(usuario);
        int ano = documento.getPeriodo_final().getYear() + 1900;
        int mes = documento.getPeriodo_final().getMonth() + 1;

        Integer ultimoCodigo = ultimoCodigoBR();
        String path = "C:" + File.separator
                + "UPLOAD" + File.separator
                + empresa.getNome() + File.separator
                + documento.getTipo_documento().getDescricao() + File.separator
                + ano + File.separator
                + mes;
        String nomeArquivo = empresa.getNome() + " - "
                + documento.getTipo_documento().getDescricao() + " - "
                + ultimoCodigo + " - "
                + file.getSubmittedFileName().substring(file.getSubmittedFileName().indexOf("."));
        documento.setPath(path);
        documento.setNome(nomeArquivo);
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
    
    public void editar(Documento documento, Usuario usuario){
        documento.setUlt_alteracao(Calendar.getInstance());
        documento.setUsuarioAlteracao(usuario);
        this.documentoDAO.editar(documento);
    }

    public void excluir(Documento documento, Usuario usuario) {
        boolean verifica=false;
        for(UsuarioTipoDocumento userTipo:usuario.getUsuarioTipoDocumento()){
            if(userTipo.getTipoDocumento().getId().equals(documento.getTipo_documento().getId()) && userTipo.getExcluir()==true){
                this.documentoDAO.excluir(documento);
                verifica=true;
            } 
        }
        if(!verifica){
            new MensagemUtil().sendMensagem("Usuário sem permissão para excluir este tipo de documento", " ");
        }
        
    }
    
    public void aprovar(Documento documento, Usuario usuario){
        documento.setData_aprovacao(Calendar.getInstance());
        documento.setUsuario_aprovacao(usuario);
        
    }

    public List<Documento> listar(Empresa empresa, Usuario usuario, String descricao ,TipoDocumento tipoDocumento, Entidade entidade,
            Date dataInicio, Date dataFim) {
        UsuarioRN usuarioRN = new UsuarioRN();
        usuario = usuarioRN.buscarPorEmail(usuario.getEmail());
        return this.documentoDAO.listar(empresa, usuario, descricao ,tipoDocumento,entidade, dataInicio, dataFim);
        
    }
    
   

    public Integer ultimoCodigoBR() {
        return this.documentoDAO.ultimoCodigoBD();
    }

}
