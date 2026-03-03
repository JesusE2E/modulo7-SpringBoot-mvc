package dgtic.core.controller;

import dgtic.core.controller.dto.EnteroConverter;
import dgtic.core.controller.dto.MayusculasConverter;
import dgtic.core.controller.dto.UsuarioDTO;
import dgtic.core.controller.dto.VacioConverter;
import dgtic.core.validationn.NombresValidation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value="spring")
public class PrincipalController {

    @Autowired
    private NombresValidation nombresValidation;


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

    @GetMapping("parametros-dos/{edad}/{nombre}")
    public String getParametrosDos(@PathVariable("edad") int edad,
                                   @PathVariable("nombre")String nombre,
                                   Model model){
    String cadena="Tu edad es:"+edad+" y tu nombre es :"+nombre;
    model.addAttribute("contenido",cadena);
    return "spring/pathVariable";
    }

    @GetMapping("/requestparam")
    public String getRequestParam(@RequestParam(value="dato",required = false)String dato,Model model){
    String cadena="Sin informacion";
    if(dato!=null){
        cadena="la informacion es: "+dato;
    }
    model.addAttribute("contenido",cadena);
    model.addAttribute("info",cadena);
    return "spring/requestParam";
    }

    @GetMapping("/requestparam-v")
    public String getRequestParamDosParametros(@RequestParam(value="dato",required = false)String dato,
                                               @RequestParam(value="diplomado",required = false)String diplomado,
                                               Model model){
        String cadena="Sin informacion de dato y diplomado";
        if(dato!=null || diplomado!=null){
            cadena="la informacion es: "+dato+" el diplomado es: "+diplomado;
        }
        model.addAttribute("contenido",cadena);
        model.addAttribute("error",cadena);
        return "spring/requestParam";
    }
//metodo para el formulario
    //desplegar formulario
    @GetMapping("ver-formulario")
    public String verFormulario(Model model){
    model.addAttribute("contenido ","ingrese los siguientes datos");
        return "spring/requestparam-post";
    }


    @PostMapping("recibir-informacion")
    public String recibirDatos(@RequestParam(value = "nombre")String nombre,
                               @RequestParam(value = "correo")String correo,
                               Model model){
     String cadena="Sin Informacion";
     if(!nombre.isEmpty() && !correo.isEmpty()){
         model.addAttribute("contenido ","ingrese los siguientes datos");
         cadena="nombre: "+nombre+" correo: "+correo;
         model.addAttribute("contenido",cadena);


     }
        return "spring/requestparam-post";
    }



    @GetMapping("ver-usuario")
    public String verUsuario(
                               Model model){

            model.addAttribute("contenido ","ingrese los siguientes datos");

        return "spring/binding";
    }




    @PostMapping("recibir-usuario")
    public String recibirDatos(UsuarioDTO usuarioDTO,
                               Model model){
        String cadena="Sin Informacion";
        if(!usuarioDTO.getNombre().isEmpty() && !usuarioDTO.getCorreo().isEmpty()){
            model.addAttribute("contenido ","Los datos son");
            cadena="nombre: "+usuarioDTO.getNombre()+" correo: "+usuarioDTO.getCorreo()
            +"Cp: "+usuarioDTO.getCp()+"telefono: "+usuarioDTO.getTel() ;
            model.addAttribute("contenido",cadena);


        }
        return "spring/binding";
    }

//ver-usuario-v2

    @GetMapping("ver-usuario-v2")
    public String verUsuarioV2(Model model){
    model.addAttribute("usuario",new UsuarioDTO());
    model.addAttribute("contenido","ingresa los datos siguientes");
    return "spring/binding-v2";
    }


    @PostMapping("ver-usuario-v2")
    public String recibirUsuario2(@ModelAttribute("usuario") UsuarioDTO usuarioDTO,
                               Model model){
        String cadena="Sin Informacion";
        if(!usuarioDTO.getNombre().isEmpty() && !usuarioDTO.getCorreo().isEmpty()){
            model.addAttribute("contenido ","Los datos son");
            cadena="nombre: "+usuarioDTO.getNombre()+" correo: "+usuarioDTO.getCorreo()
                    +"Cp: "+usuarioDTO.getCp()+"telefono: "+usuarioDTO.getTel() ;
            model.addAttribute("contenido",cadena);


        }
        return "spring/binding-v2";
    }

    @GetMapping("ver-usuario-v3")
    public String verUsuarioV3(Model model){
        model.addAttribute("usuario",new UsuarioDTO());
        model.addAttribute("contenido","ingresa los datos siguientes");
        return "spring/binding-v3";
    }

    @PostMapping("recibir-usuario-v3")
    public String recibirUsuario3(@Valid @ModelAttribute("usuario") UsuarioDTO usuario,
                                  BindingResult bindingResult,
                                  Model model){
        if(bindingResult.hasErrors()){
            for(ObjectError error:bindingResult.getAllErrors()){
                System.out.println("Error: "+error.getDefaultMessage());
            }
            return "spring/binding-v3";
        }
        model.addAttribute("usuario",usuario);
        String cadena="";
        if(!usuario.getNombre().isEmpty() && !usuario.getCorreo().isEmpty()){
            model.addAttribute("contenido","Los datos que ingresas son:");
            cadena="Tu nombre es: "+usuario.getNombre()+" y correo: "+usuario.getCorreo()+" Cp: "+usuario.getCp()+" Telefono: "+usuario.getTel();
        }
        model.addAttribute("contenido","Los datos que ingresas son:");
        model.addAttribute("info",cadena);
        return "spring/binding-v3";
        }


    @InitBinder("usuario")
    public void convertir(WebDataBinder binder){
        binder.registerCustomEditor(Integer.class,
                "edad", new EnteroConverter());

        binder.registerCustomEditor(String.class,
                "nombre", new MayusculasConverter());

        binder.registerCustomEditor(String.class,
                "correo", new VacioConverter());

        binder.addValidators(nombresValidation);

        }

    @GetMapping("ver-usuario-v4")
    public String verUsuarioV4(Model model){
        model.addAttribute("usuario",new UsuarioDTO());
        model.addAttribute("contenido","ingresa los datos siguientes");
        return "spring/binding-v4";
    }

    @PostMapping("recibir-usuario-v4")
    public String recibirUsuario(@Valid @ModelAttribute("usuario") UsuarioDTO usuario,
                                  BindingResult bindingResult,
                                  Model model){
        if(bindingResult.hasErrors()){
            for(ObjectError error:bindingResult.getAllErrors()){
                System.out.println("Error: "+error.getDefaultMessage());
            }
            return "spring/binding-v4";
        }
        model.addAttribute("usuario",usuario);
        String cadena="";
        if(!usuario.getNombre().isEmpty() && !usuario.getCorreo().isEmpty()){
            model.addAttribute("contenido","Los datos que ingresas son:");
            cadena="Tu nombre es: "+usuario.getNombre()+" y correo: "+usuario.getCorreo()+" Cp: "+usuario.getCp()+" Telefono: "+usuario.getTel();
        }
        model.addAttribute("contenido","Los datos que ingresas son:");
        model.addAttribute("info",cadena);
        return "spring/binding-v4";
    }






}
