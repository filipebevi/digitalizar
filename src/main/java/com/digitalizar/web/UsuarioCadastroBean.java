/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.web;

import com.digitalizar.empresa.Empresa;
import com.digitalizar.empresa.EmpresaRN;
import com.digitalizar.tipodocumento.TipoDocumento;
import com.digitalizar.tipodocumento.TipoDocumentoRN;
import com.digitalizar.usuario.Usuario;
import com.digitalizar.usuario.UsuarioRN;
import com.digitalizar.usuarioEmpresa.UsuarioEmpresa;
import com.digitalizar.usuarioEmpresa.UsuarioEmpresaRN;
import com.digitalizar.usuarioTipoDocumento.UsuarioTipoDocumento;
import com.digitalizar.web.util.ContextoUtil;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author filip
 */
@ManagedBean
@ViewScoped
public class UsuarioCadastroBean implements Serializable {

    Usuario usuario = new Usuario();
    Empresa empresa = new Empresa();
    TipoDocumento tipoDocumento = new TipoDocumento();
    UsuarioEmpresa usuarioEmpresa = new UsuarioEmpresa();
    UsuarioTipoDocumento usuarioTipo = new UsuarioTipoDocumento();
    List<TipoDocumento> listaTipo;
    List<Empresa> listaEmpresa;
    String permissao = null;
    List<UsuarioTipoDocumento> listaFilter;

    public UsuarioCadastroBean() {
        ContextoBean contexto = ContextoUtil.getContextoBean();
        if (contexto.getUsuarioTemporario() != null) {
            this.usuario = contexto.getUsuarioTemporario();
        }

    }

    public void novaEmpresa() {

        this.empresa = new Empresa();
        this.usuarioEmpresa = new UsuarioEmpresa();
    }

    public String salvar() {
        ContextoBean contextoBean = ContextoUtil.getContextoBean();
        if (this.usuario.getId() == null) {
            this.usuario.setUsuarioInclusao(contextoBean.getUsuarioLogado());
            this.usuario.setData_inclusao(Calendar.getInstance());
        }
        this.usuario.setUsuarioAlteracao(contextoBean.getUsuarioLogado());
        this.usuario.setData_ult_alteracao(Calendar.getInstance());
        UsuarioRN usuarioRN = new UsuarioRN();
        usuarioRN.salvar(this.usuario);
        this.usuario = new Usuario();
        contextoBean.setUsuarioTemporario(null);

        return "usuario";

    }

    public void adicionarEmpresa() {
        UsuarioEmpresa.Id id = new UsuarioEmpresa.Id();
        id.setEmpresa(this.empresa.getId());
        id.setUsuario(this.usuario.getId());
        this.usuarioEmpresa.setId(id);
        this.usuarioEmpresa.setUsuario(this.usuario);
        this.usuarioEmpresa.setEmpresa(this.empresa);

        this.usuario.getUsuarioEmpresa().add(this.usuarioEmpresa);

        this.empresa = new Empresa();
        this.usuarioEmpresa = new UsuarioEmpresa();

    }

    public void removerEmpresa() {
        usuario.getUsuarioEmpresa().remove(this.usuarioEmpresa);
    }

    public void adicionarPermissao() {
        this.usuario.getPermissao().add(this.permissao);
        this.permissao = new String();
    }

    public void removerPermissao() {
        this.usuario.getPermissao().remove(this.permissao);
        this.permissao = new String();
    }

    public void adicionarTipo() {
        UsuarioTipoDocumento.Id id = new UsuarioTipoDocumento.Id();
        id.setTipoDocumento(this.tipoDocumento.getId());
        id.setUsuario(this.usuario.getId());
        this.usuarioTipo.setId(id);
        this.usuarioTipo.setUsuario(this.usuario);
        this.usuarioTipo.setTipoDocumento(this.tipoDocumento);

        this.usuario.getUsuarioTipoDocumento().add(this.usuarioTipo);

        this.tipoDocumento = new TipoDocumento();
        this.usuarioTipo = new UsuarioTipoDocumento();
        this.listaFilter = null;

    }

    public void removerTipo() {
        usuario.getUsuarioTipoDocumento().remove(this.usuarioTipo);
    }

    public List<Empresa> getListaEmpresa() {
        if (this.listaEmpresa == null) {
            EmpresaRN empresaRN = new EmpresaRN();
            this.listaEmpresa = empresaRN.listar();
        }

        return this.listaEmpresa;
    }

    public List<TipoDocumento> getListaTipo() {

        TipoDocumentoRN tipoRN = new TipoDocumentoRN();
        
            UsuarioEmpresaRN usuarioEmpresaRN = new UsuarioEmpresaRN();
            this.empresa = usuarioEmpresaRN.buscarFavorita(this.usuario);
        if(empresa!=null){
            this.listaTipo = tipoRN.listar(this.empresa);
        }
        
            
        
        

        return this.listaTipo;
    }

    

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public UsuarioEmpresa getUsuarioEmpresa() {
        return usuarioEmpresa;
    }

    public void setUsuarioEmpresa(UsuarioEmpresa usuarioEmpresa) {
        this.usuarioEmpresa = usuarioEmpresa;
    }

    public String getPermissao() {
        return permissao;
    }

    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public UsuarioTipoDocumento getUsuarioTipo() {
        return usuarioTipo;
    }

    public void setUsuarioTipo(UsuarioTipoDocumento usuarioTipo) {
        this.usuarioTipo = usuarioTipo;
    }

}
