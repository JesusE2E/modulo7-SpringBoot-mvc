package dgtic.core.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InicioController {

    @Value("${mensaje.application}")
    private String valor;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String inicio(){
        return "inicio";
    }

//pasar informacion a la vista con la clase model
    @RequestMapping(value = "modelo",method = RequestMethod.GET)
    public String modelo(Model model){
        model.addAttribute("mensaje","Diplomado de Java con Spring");
        return "inicio";
    }
    //pasar informacion a la vista con la clase model
    @RequestMapping(value = "propiedad",method = RequestMethod.GET)
    public String propiad(Model model){
        model.addAttribute("propiedad",valor);
        System.out.println(valor);
        return "inicio";
    }


    @RequestMapping(value = "principal",method = RequestMethod.GET)
    public String salto(Model model){
//model.addAttribute("contenido","Principal");

        return "principal/principal";
    }

}
