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
public class DaoCrewImpl extends DAO {
           public void agregarCrew(Crew c){
         begin();
        getSession().save(c);
        commit();
        close();
                
    }
     public ArrayList<Crew> buscarTodoCrew(){
       begin();
       Criteria c=getSession().createCriteria(Crew.class);
       ArrayList<Crew> crew = (ArrayList<Crew>)c.list();
       commit();
       close();
       
       return crew;
   }
    /* Borrar */
   
   public void borrarCrew(Crew w){
       begin();
       getSession().delete(w);
       commit();
       close();
      
   }
   
   /* Buscar por ID */
   
    public Crew buscarPorId(int id){
      begin();
     Query q = getSession().createQuery("from Crew where id_crew = :id");
        q.setInteger("id",id);
        Crew p = (Crew)q.uniqueResult();
        commit();
        close();
return p;  
   
    }
    
    
}
