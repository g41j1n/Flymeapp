/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gdev.web.flymeapp;


import static com.gdev.web.flymeapp.DAO.close;
import static com.gdev.web.flymeapp.DAO.getSession;
import java.util.ArrayList;
import org.hibernate.Query; 
import org.hibernate.Criteria;


/**
 *
 * @author gaijin
 */
public class DAOUsrImpl extends DAO{
    
    public void agregarUsr(Usr u){
        begin();
        getSession().save(u);
        commit();
        close();
    }
    /* Obtencion de todos los registros de las tablas
    */
   public ArrayList<Usr> buscarTodoUsr(){
       begin();
       Criteria c=getSession().createCriteria(Usr.class);
       ArrayList<Usr> usrs = (ArrayList<Usr>)c.list();
       commit();
       close();
       
       return usrs;
   }
    /* Borrar */
   
   public void borrarUsr(Usr u){
       begin();
       getSession().delete(u);
       commit();
       close();
      
   }
   
   /* Buscar por ID */
   
    public Usr buscarPorId(int id){
      begin();
     Query q = getSession().createQuery("from Usr where idUsr = :id");
        q.setInteger("id",id);
        Usr p = (Usr)q.uniqueResult();
        commit();
        close();
return p;  
   
    }
    
}
