/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gdev.web.flymeapp;

import org.codehaus.jackson.map.ObjectMapper;
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
public class ControladorAirplane {
    /* Metodo Insert
    
    */
    @RequestMapping(value="/plane/{model}/{plate}", method=RequestMethod.GET, headers={"Accept=text/html"})
    public @ResponseBody  String salida(@PathVariable String model, @PathVariable integer plate){
        DAOAirplaneImpl d= new DAOAirplaneImpl();
        d.addPlane(new Airplane(model,plate));
        return "Avion creado correctamente";
    }
    @RequestMapping(value="/plane", method=RequestMethod.GET, headers={"Accept=application/json"})
    public @ResponseBody String metodo2()throws Exception {
        DAOAirplaneImpl d= new DAOAirplaneImpl();
        ObjectMapper maper=new ObjectMapper();
            
        return maper.writeValueAsString(d.buscarTodoAirplane());
    }
}

    
    
}
