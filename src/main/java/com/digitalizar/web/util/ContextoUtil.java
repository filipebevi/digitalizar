/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizar.web.util;

import com.digitalizar.web.ContextoBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author filip
 */
public class ContextoUtil {
    
    public static ContextoBean getContextoBean(){
        FacesContext context=FacesContext.getCurrentInstance();
        ExternalContext externalContext=context.getExternalContext();
        HttpSession session=(HttpSession) externalContext.getSession(true);
        ContextoBean contextoBean=(ContextoBean) session.getAttribute("contextoBean");
        return contextoBean;
    }
    
}
