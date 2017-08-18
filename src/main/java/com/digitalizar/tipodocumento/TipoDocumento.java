/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.tipodocumento;

import com.digitalizar.empresa.Empresa;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author filip
 */
@Entity
public class TipoDocumento implements Serializable{
    @Id
    @GeneratedValue
    private Integer id;
    private String descricao;
    
    @ManyToOne
    private Empresa empresa;
    
}
