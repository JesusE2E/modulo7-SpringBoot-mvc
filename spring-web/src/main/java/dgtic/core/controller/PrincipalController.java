package dgtic.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="spring")
public class PrincipalController {
@RequestMapping(value="requestmapping",method= RequestMethod.GET)
  //  @GetMapping("requestmapping")
    public String mappingClase(Model model){
        model.addAttribute("contenido", "@RequestMapping Clase");
        return "spring/requestmapping";
    }

    @RequestMapping(value="getmapping",method= RequestMethod.GET)
    //  @GetMapping("requestmapping")
    public String getMapping(Model model){
        model.addAttribute("contenido", "@Getmapping en metodo");
        return "spring/getmapping";
    }

    //{/spring/parametros-uno/49

    @GetMapping("parametros-uno/{edad}")
    public String getParametroUno(@PathVariable("edad") int edad, Model model){
    String cadena ="Tu edad es: "+edad;
    model.addAttribute("contenido",cadena);
    return edad==1?"redirect:/spring/getmapping":"spring/pathVariable";
    }

}
