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

    // 1 - Instanciamos la calculadora de la manera tradicional
    Calculadora calculadoraNormal = new Calculadora();
    System.out.println(calculadoraNormal.holaMundo());

    // 2 - Obtenemos el bean a traves de Spring framework, que tenemos que castear
    Calculadora calculadoraQueSaluda = (Calculadora) context.getBean("calculadora");

    String texto = calculadoraQueSaluda.holaMundo();
    System.out.println(texto);

    Calculadora calculadora2 = (Calculadora) context.getBean("calculadora");
    String texto2 = calculadora2.holaMundo();
    System.out.println(texto2);

    // Creamos el gestor Facturas
    GestorFacturas gestorFacturas = (GestorFacturas) context.getBean("gestorFacturas");
    System.out.println(gestorFacturas.calculadora.holaMundo());

    // 3 - Los beans por defecto son singleton
    // se puede cambiar a scope prototype si queremos que siempre se creen
    // Se suelen usar el singleton cuando suele ser servicios o cosas así, cuando no depende
  }
}
