package es.david.scan;

import org.springframework.stereotype.Component;

// https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-classpath-scanning
@Component
public class Calculadora2 {

  public Calculadora2() {
    System.out.println("Creamos constructor scaneado");
  }

  public String holaMundo() {
    return "Hola mundo scaneado";
  }
}
