/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.usuarioTipoDocumento;

import com.digitalizar.tipodocumento.TipoDocumento;
import com.digitalizar.usuario.Usuario;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author filip
 */

@Entity
public class UsuarioTipoDocumento implements Serializable{
    
    @EmbeddedId
    private Id id;
    
    @ManyToOne
    private Usuario usuario;
    
    @ManyToOne
    private TipoDocumento tipoDocumento;
    
    private Boolean visualizar;
    private Boolean excluir;
    private Boolean inserir;
    private Boolean alterar;

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Boolean getVisualizar() {
        return visualizar;
    }

    public void setVisualizar(Boolean visualizar) {
        this.visualizar = visualizar;
    }

    public Boolean getExcluir() {
        return excluir;
    }

    public void setExcluir(Boolean excluir) {
        this.excluir = excluir;
    }

    public Boolean getInserir() {
        return inserir;
    }

    public void setInserir(Boolean inserir) {
        this.inserir = inserir;
    }

    public Boolean getAlterar() {
        return alterar;
    }

    public void setAlterar(Boolean alterar) {
        this.alterar = alterar;
    }
    
    
    
    
    
    
    
    @Override
    public String toString() {
        return String.format("%s[id=%d]", getClass().getSimpleName(), getId());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.usuario);
        hash = 97 * hash + Objects.hashCode(this.tipoDocumento);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UsuarioTipoDocumento other = (UsuarioTipoDocumento) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.tipoDocumento, other.tipoDocumento)) {
            return false;
        }
        return true;
    }
    
    
    @Embeddable
    public static class Id implements Serializable {
        
        private Integer usuario;
        
        private Integer tipoDocumento;

        public Integer getUsuario() {
            return usuario;
        }

        public void setUsuario(Integer usuario) {
            this.usuario = usuario;
        }

        public Integer getTipoDocumento() {
            return tipoDocumento;
        }

        public void setTipoDocumento(Integer tipoDocumento) {
            this.tipoDocumento = tipoDocumento;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 67 * hash + Objects.hashCode(this.usuario);
            hash = 67 * hash + Objects.hashCode(this.tipoDocumento);
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Id other = (Id) obj;
            if (!Objects.equals(this.usuario, other.usuario)) {
                return false;
            }
            if (!Objects.equals(this.tipoDocumento, other.tipoDocumento)) {
                return false;
            }
            return true;
        }
        
        
    }
    
    
   
    
    
}
