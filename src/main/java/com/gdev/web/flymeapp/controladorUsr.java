/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gdev.web.flymeapp;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author gaijin
 */
@Controller
@RequestMapping("/")
public class controladorUsr {
    /*Metodo insert
    
    */
    @RequestMapping(value="/usr/{usuario}/{password}", method=RequestMethod.GET, headers={"Accept=text/html"})
    public @ResponseBody  String salida(@PathVariable String usuario, @PathVariable String password){
        DAOUsrImpl d= new DAOUsrImpl();
        d.agregarUsr(new Usr(usuario,password));
        return "Usuario creado correctamente";
    }
    @RequestMapping(value="/usr", method=RequestMethod.GET, headers={"Accept=application/json"})
    public @ResponseBody String metodo2()throws Exception {
        DAOUsrImpl d= new DAOUsrImpl();
        ObjectMapper maper=new ObjectMapper();
            
        return maper.writeValueAsString(d.buscarTodoUsr());
    }
}
