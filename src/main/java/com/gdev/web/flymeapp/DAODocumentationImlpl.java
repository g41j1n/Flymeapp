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
public class DAODocumentationImlpl extends DAO{
    
               public void agregarDocumentation(Documentation d){
         begin();
        getSession().save(d);
        commit();
        close();
                
    }
     public ArrayList<Documentation> buscarTodoDocumentation(){
       begin();
       Criteria c=getSession().createCriteria(Documentation.class);
       ArrayList<Documentation> documentation = (ArrayList<Documentation>)c.list();
       commit();
       close();
       
       return documentation;
   }
    /* Borrar */
   
   public void borrarDocumentation(Documentation c){
       begin();
       getSession().delete(c);
       commit();
       close();
      
   }
   
   /* Buscar por ID */
   
    public Documentation buscarPorId(int id){
      begin();
     Query q = getSession().createQuery("from Documentation where id_docu = :id");
        q.setInteger("id",id);
        Documentation d = (Documentation)q.uniqueResult();
        commit();
        close();
return d;  
   
    }
    

    
}
