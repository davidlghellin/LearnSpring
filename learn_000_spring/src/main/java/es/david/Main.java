package es.david;

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

    // Obtenermos el bean, que tenemos que castear
    Calculadora calculadoraQueSaluda = (Calculadora) context.getBean("calculadora");

    String texto = calculadoraQueSaluda.holaMundo();
    System.out.println(texto);

    Calculadora calculadora2 = (Calculadora) context.getBean("calculadora");
    String texto2 = calculadora2.holaMundo();
    System.out.println(texto2);

  }
}
