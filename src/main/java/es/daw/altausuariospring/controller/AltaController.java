package es.daw.altausuariospring.controller;

import es.daw.altausuariospring.service.AltaService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/alta")
@RequiredArgsConstructor
public class AltaController {

    private static final Logger LOG = LoggerFactory.getLogger(AltaController.class);
    private final AltaService service;

//    // Inyección por constructor: NO hacemos new OpcionesService(), nos lo da Spring
//    public AltaController(AltaService service) {
//        this.service = service;
//    }

//    @GetMapping("/")
//    public String inicio() {
//        return "index";              // → templates/index.html
//   }

//    @GetMapping("/alta")
    @GetMapping
    public String mostrarFormulario(Model model) {
        // 1. Añadir al modelo las listas de tecnologías y niveles
        model.addAttribute("tecnologias", service.getTecnologias());
        model.addAttribute("listaNiveles", service.getNiveles());
        // 2. Devolver el nombre de la vista
        return "formulario";
    }

//    @PostMapping("/alta")
    @PostMapping
    public String procesarFormulario(@RequestParam String nombre,
                                     @RequestParam String email,
                                     @RequestParam String tecnologia,
                                     @RequestParam(name = "nivel", required = false) List<String> niveles,
                                     Model model) {
        // 1. Si nombre está vacío → mensajeError + datos introducidos + listas → "formulario"
        // 2. Si no → datos al modelo → "confirmacion"

        if (nombre.isBlank()) {
            model.addAttribute("mensajeError", "El nombre es obligatorio");
            model.addAttribute("email", email);
            model .addAttribute("tecnologias", service.getTecnologias());
            model.addAttribute("tecnologia", tecnologia);
            model.addAttribute("listaNiveles", service.getNiveles());
            model.addAttribute("nivelesSeleccionados", niveles);
            return "formulario";
        }

        model.addAttribute("nombre", nombre);
        model.addAttribute("email", email);
        model.addAttribute("tecnologia", tecnologia);
        model.addAttribute("niveles", niveles);

        return "confirmacion";
    }
}