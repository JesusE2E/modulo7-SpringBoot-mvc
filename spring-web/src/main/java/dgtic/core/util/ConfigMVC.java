package dgtic.core.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConfigMVC implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);
        //Registrare las rutas para trabajar
        //añadir al registro lo que se necesita
        registry.addResourceHandler("/imagenes/**").addResourceLocations("file:/C://imagenes//");
    }
}
