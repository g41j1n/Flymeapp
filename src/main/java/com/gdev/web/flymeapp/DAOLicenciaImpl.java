/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gdev.web.flymeapp;

import static com.gdev.web.flymeapp.DAO.close;
import static com.gdev.web.flymeapp.DAO.getSession;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Query;

/**
 *
 * @author gaijin
 */
public class DAOLicenciaImpl extends DAO{
    
                   public void agregarLicencia(Licencia l){
         begin();
        getSession().save(l);
        commit();
        close();
                
    }
     public ArrayList<Licencia> buscarTodoLicencia(){
       begin();
       Criteria c=getSession().createCriteria(Licencia.class);
       ArrayList<Licencia> licencia = (ArrayList<Licencia>)c.list();
       commit();
       close();
       
       return licencia;
   }
    /* Borrar */
   
   public void borrarLicencia(Licencia l){
       begin();
       getSession().delete(l);
       commit();
       close();
      
   }
   
   /* Buscar por ID */
   
    public Licencia buscarPorId(int id){
      begin();
     Query q = getSession().createQuery("from Documentation where id_licencia = :id");
        q.setInteger("id",id);
       Licencia l = (Licencia)q.uniqueResult();
        commit();
        close();
return l;  
   
    }
    
    
}
