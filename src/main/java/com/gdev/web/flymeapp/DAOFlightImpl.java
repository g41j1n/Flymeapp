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
public class DAOFlightImpl extends DAO {
    
           public void agregarFlight(Flight f){
         begin();
        getSession().save(f);
        commit();
        close();
                
    }
     public ArrayList<Flight> buscarTodoFlight(){
       begin();
       Criteria c=getSession().createCriteria(Flight.class);
       ArrayList<Flight> flight = (ArrayList<Flight>)c.list();
       commit();
       close();
       
       return flight;
   }
    /* Borrar */
   
   public void borrarFlight(Flight l){
       begin();
       getSession().delete(l);
       commit();
       close();
      
   }
   
   /* Buscar por ID */
   
    public Flight buscarPorId(int id){
      begin();
     Query q = getSession().createQuery("from Flight where id_flight = :id");
        q.setInteger("id",id);
        Flight p = (Flight)q.uniqueResult();
        commit();
        close();
return p;  
   
    }
    

    
}
