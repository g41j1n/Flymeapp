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
public class DAOAirplaneImpl extends DAO{
    
    public void agregarAirplane(Airplane a){
         begin();
        getSession().save(a);
        commit();
        close();
                
    }
     public ArrayList<Airplane> buscarTodoAvion(){
       begin();
       Criteria c=getSession().createCriteria(Airplane.class);
       ArrayList<Airplane> Airplanes = (ArrayList<Airplane>)c.list();
       commit();
       close();
       
       return Airplanes;
   }
    /* Borrar */
   
   public void borrarAvion(Airplane v){
       begin();
       getSession().delete(v);
       commit();
       close();
      
   }
   
   /* Buscar por ID */
   
    public Airplane buscarPorId(int id){
      begin();
     Query q = getSession().createQuery("from Airplane where id_plane = :id");
        q.setInteger("id",id);
        Airplane p = (Airplane)q.uniqueResult();
        commit();
        close();
return p;  
   
    }
    
    
    
    
}
