/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.campitos.spring.web;

import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author campitos
 */
public class Guardar {
    public void guardar(String nombre, float sueldo){
            
Session sesion=  HibernateUtilidades.getSessionFactory().openSession();
// primer paso: Empezar una sesion

sesion.getTransaction().begin();
sesion.save(new Usuario(1,nombre,sueldo));

sesion.getTransaction().commit();
System.out.println("Se inserto adecuadamente");
sesion.close();
    }
    
    public ArrayList<Usuario> obtenerUsuario(){
                    
Session sesion=  HibernateUtilidades.getSessionFactory().openSession();
// primer paso: Empezar una sesion

sesion.getTransaction().begin();
        Criteria c=sesion.createCriteria(Usuario.class);
 
 ArrayList<Usuario> usuarios2=(ArrayList<Usuario>)   c.list();
 sesion.close();
 return usuarios2;
    }
    
}
