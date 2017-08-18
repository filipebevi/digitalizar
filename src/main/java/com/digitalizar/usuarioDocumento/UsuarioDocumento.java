/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.usuarioDocumento;

import com.digitalizar.documento.Documento;
import com.digitalizar.usuario.Usuario;
import java.io.Serializable;
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
    private Id id;

    private Boolean visualizar;
    private Boolean incluir;
    private Boolean editar;
    private Boolean excluir;

    @Embeddable
    public static class Id implements Serializable {
        @ManyToOne
        private Usuario usuario;
        
        @ManyToOne
        private Documento documento;

    }

}
