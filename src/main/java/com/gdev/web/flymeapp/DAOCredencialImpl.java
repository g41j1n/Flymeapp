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
public class DAOCredencialImpl extends DAO{
       public void agregarCredencial(Credencial c){
         begin();
        getSession().save(c);
        commit();
        close();
                
    }
     public ArrayList<Credencial> buscarTodoCredencial(){
       begin();
       Criteria c=getSession().createCriteria(Credencial.class);
       ArrayList<Credencial> credenciales = (ArrayList<Credencial>)c.list();
       commit();
       close();
       
       return credenciales;
   }
    /* Borrar */
   
   public void borrarCredencial(Credencial d){
       begin();
       getSession().delete(d);
       commit();
       close();
      
   }
   
   /* Buscar por ID */
   
    public Credencial buscarPorId(int id){
      begin();
     Query q = getSession().createQuery("from Credencial where id_credencial = :id");
        q.setInteger("id",id);
        Credencial p = (Credencial)q.uniqueResult();
        commit();
        close();
return p;  
   
    }
    
    
    
}
