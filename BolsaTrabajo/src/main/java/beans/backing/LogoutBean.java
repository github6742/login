/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.backing;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author sgrsm
 */
@Named(value = "logoutBean")
@RequestScoped
public class LogoutBean {

    private static Logger log = Logger.getLogger(LogoutBean.class.getName());
    
    public LogoutBean() {      
    }
    
    public String logout(){
        String destino ="/index?faces-redirect=true";
        
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        
        try{
            request.logout();
        } catch (Exception e) {
            log.log(Level.SEVERE,"Fallo el cierre de session del usuario",e);
            destino ="errorLogin?faces-redirect=true";
        }
        
        return destino;
    }
}
