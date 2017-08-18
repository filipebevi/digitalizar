/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.empresa;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author filip
 */
@Entity
public class Empresa implements Serializable{
    
    @Id
    @GeneratedValue
    private Integer id;
    private String nome;
    private String logotipo;
    
    
}
