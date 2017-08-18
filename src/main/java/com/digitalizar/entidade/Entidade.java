/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.entidade;

import com.digitalizar.empresa.Empresa;
import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author filip
 */
@Entity
public class Entidade implements Serializable{
    @Id
    @GeneratedValue
    private Integer id;
    
    private String nome;
    
    @ManyToOne
    private Empresa empresa;
    
    @Temporal(TemporalType.DATE)
    private Calendar ultima_alteracao;
    
    
}
