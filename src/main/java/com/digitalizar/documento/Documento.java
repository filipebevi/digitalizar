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
import java.io.File;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author filip
 */
@Entity
public class Documento implements Serializable{
    @Id
    @GeneratedValue
    private Integer id;
    
    @Temporal(TemporalType.DATE)
    private Calendar data_inclusao;
    
    @ManyToOne
    private Usuario usuario_inclusao;
    
    @ManyToOne
    private Usuario usuario_aprovacao;
    
    @Temporal(TemporalType.DATE)
    private Calendar data_aprovacao;
    
    private File arquivo;
    
    @ManyToOne
    private Empresa empresa;
    
    @ManyToOne
    private TipoDocumento tipo_documento;
    
    private String descricao;
    
    @Temporal(TemporalType.DATE)
    private Calendar periodo_inicial;
    
    @Temporal(TemporalType.DATE)
    private Calendar periodo_final;
    
    private Double valor;
    
    @Temporal(TemporalType.DATE)
    private Calendar vencimento;
    
    @ManyToOne
    private Entidade entidade;
    
    private String numero;
    @Temporal(TemporalType.DATE)
    
    private Calendar ult_alteracao;
    
    @ManyToMany
    private List <Documento> documentos;
    
    
    
}
