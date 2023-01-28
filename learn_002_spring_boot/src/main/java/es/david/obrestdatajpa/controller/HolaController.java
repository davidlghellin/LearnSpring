package es.david.obrestdatajpa.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaController {

    @Value("${app.message}")
    String message;


    @GetMapping("/hola")
    public String holaMundo() {
        System.out.println(message);
        return "Hola mundo\n";
    }

    @GetMapping("/bootstrap")
    public String bootstrap(){
        // no se usa el html. Usariamos por ejemplo el spring mvc
        return "<h1>Prueba</h1>";
    }

}
