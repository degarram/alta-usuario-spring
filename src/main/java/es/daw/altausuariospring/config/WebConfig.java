package es.daw.altausuariospring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * addViewControllers: rutas que SOLO devuelven vista (sin Model, sin lógicA)
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // Sobraría porque por defecto el home busca un index.html...
        // Son endpoints sin lógica de negocio.
        registry.addViewController("/").setViewName("index");


    }
}
