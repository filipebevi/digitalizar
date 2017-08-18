/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.usuarioDocumento;

import com.digitalizar.documento.Documento;
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
public class UsuarioDocumento implements Serializable {

    @EmbeddedId
    private UsuarioDocumentoId id;

    private Boolean visualizar;
    private Boolean incluir;
    private Boolean editar;
    private Boolean excluir;

    public UsuarioDocumento() {
    }

    public UsuarioDocumentoId getId() {
        return id;
    }

    public void setId(UsuarioDocumentoId id) {
        this.id = id;
    }

    public Boolean getVisualizar() {
        return visualizar;
    }

    public void setVisualizar(Boolean visualizar) {
        this.visualizar = visualizar;
    }

    public Boolean getIncluir() {
        return incluir;
    }

    public void setIncluir(Boolean incluir) {
        this.incluir = incluir;
    }

    public Boolean getEditar() {
        return editar;
    }

    public void setEditar(Boolean editar) {
        this.editar = editar;
    }

    public Boolean getExcluir() {
        return excluir;
    }

    public void setExcluir(Boolean excluir) {
        this.excluir = excluir;
    }
    
    @Override
    public String toString() {
        return String.format("%s[id=%d]", getClass().getSimpleName(), getId());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.id);
        hash = 13 * hash + Objects.hashCode(this.visualizar);
        hash = 13 * hash + Objects.hashCode(this.incluir);
        hash = 13 * hash + Objects.hashCode(this.editar);
        hash = 13 * hash + Objects.hashCode(this.excluir);
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
        final UsuarioDocumento other = (UsuarioDocumento) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.visualizar, other.visualizar)) {
            return false;
        }
        if (!Objects.equals(this.incluir, other.incluir)) {
            return false;
        }
        if (!Objects.equals(this.editar, other.editar)) {
            return false;
        }
        if (!Objects.equals(this.excluir, other.excluir)) {
            return false;
        }
        return true;
    }
    
    

    
    
    

    @Embeddable
    public static class UsuarioDocumentoId implements Serializable {
        @ManyToOne
        private Usuario usuario;
        
        @ManyToOne
        private Documento documento;

        public UsuarioDocumentoId() {
        }

        public Usuario getUsuario() {
            return usuario;
        }

        public void setUsuario(Usuario usuario) {
            this.usuario = usuario;
        }

        public Documento getDocumento() {
            return documento;
        }

        public void setDocumento(Documento documento) {
            this.documento = documento;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 13 * hash + Objects.hashCode(this.usuario);
            hash = 13 * hash + Objects.hashCode(this.documento);
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
            final UsuarioDocumentoId other = (UsuarioDocumentoId) obj;
            if (!Objects.equals(this.usuario, other.usuario)) {
                return false;
            }
            if (!Objects.equals(this.documento, other.documento)) {
                return false;
            }
            return true;
        }
        
        

        
        
        
   
        
        

    }

}
