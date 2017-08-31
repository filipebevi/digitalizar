/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.web.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author filip
 */
public class MensagemUtil {
    
    public void sendMensagem(String titulo, String sub){
        FacesContext context = FacesContext.getCurrentInstance();         
        context.addMessage(null, new FacesMessage(titulo,  sub) );
    }
    
}
