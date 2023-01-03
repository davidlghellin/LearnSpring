package es.david.scan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Clase principal.
 * @author david
 *
 * @version 0.0.1
 */
public class Main {

  /**
   * Ejecutable del ejemplo.
   * @param args argumentos
   */
  public static void main(String[] args) {
    // Creamos el contexto a partir del fichero bean que hemos definido
    ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

    // 2 - Obtenemos el bean a traves de Spring framework, que tenemos que castear
    Calculadora2 calculadoraQueSaluda = (Calculadora2) context.getBean("calculadora2");

    String texto = calculadoraQueSaluda.holaMundo();
    System.out.println(texto);
    // usando anotacion @Component
  }
}
