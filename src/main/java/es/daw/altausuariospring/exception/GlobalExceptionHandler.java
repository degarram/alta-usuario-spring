package es.daw.altausuariospring.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {

    public String gestionarErrorFichero(FicheroNoEncontradoException ex, Model model) {
        model.addAttribute("error", ex.getMessage());
        return "error";
    }
}
