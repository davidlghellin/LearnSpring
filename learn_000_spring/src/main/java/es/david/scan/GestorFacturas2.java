package es.david.scan;

import org.springframework.stereotype.Component;

// https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-classpath-scanning
@Component
public class GestorFacturas2 {

  Calculadora2 calculadora;

  /**
   * Construnctor.
   */
  public GestorFacturas2(Calculadora2 calculadora) {
    System.out.println("Ejecutando constructor GestorFacturas");
    this.calculadora = calculadora;
  }

}
