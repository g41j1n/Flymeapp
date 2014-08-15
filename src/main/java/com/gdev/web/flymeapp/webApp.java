/* cross domain services
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gdev.web.flymeapp;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 *
 * @author gaijin
 */
public class webApp extends AbstractAnnotationConfigDispatcherServletInitializer{
    
    @Override
    protected String[] getServletMappings(){
        return new String[]{
            "/serv/*"   
                
                
                
        };
    }
    @Override
    protected Class<?>[] getRootConfigClasses(){
        return new Class<?>[0];
    }
    @Override
    protected Class<?>[] getServletConfigClasses(){
        return new Class <?>[]{webAppConfig.class};
    }
}
