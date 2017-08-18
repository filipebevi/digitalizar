/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.usuarioEmpresa;

import com.digitalizar.empresa.Empresa;
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
public class UsuarioEmpresa implements Serializable {

    @EmbeddedId
    private UsuarioEmpresaId id;

    private Boolean padrao;

    public UsuarioEmpresa() {
    }

    public UsuarioEmpresaId getId() {
        return id;
    }

    public void setId(UsuarioEmpresaId id) {
        this.id = id;
    }

    public Boolean getPadrao() {
        return padrao;
    }

    public void setPadrao(Boolean padrao) {
        this.padrao = padrao;
    }
    
    @Override
    public String toString() {
        return String.format("%s[id=%d]", getClass().getSimpleName(), getId());
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.id);
        hash = 61 * hash + Objects.hashCode(this.padrao);
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
        final UsuarioEmpresa other = (UsuarioEmpresa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.padrao, other.padrao)) {
            return false;
        }
        return true;
    }
    
    
    
    

    
    
    

    @Embeddable
    public static class UsuarioEmpresaId implements Serializable {

        @ManyToOne
        private Usuario usuario;

        @ManyToOne
        private Empresa empresa;

        public UsuarioEmpresaId() {
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

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 61 * hash + Objects.hashCode(this.usuario);
            hash = 61 * hash + Objects.hashCode(this.empresa);
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
            final UsuarioEmpresaId other = (UsuarioEmpresaId) obj;
            if (!Objects.equals(this.usuario, other.usuario)) {
                return false;
            }
            if (!Objects.equals(this.empresa, other.empresa)) {
                return false;
            }
            return true;
        }
        
        

        
        
    
    }

}
