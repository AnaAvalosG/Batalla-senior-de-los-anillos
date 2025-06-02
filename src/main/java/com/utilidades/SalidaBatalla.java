package com.utilidades;

/**
 * Interfaz funcional para la salida de mensajes durante la batalla. Permite
 * separar la logica de presentacion de resultados de la logica del modelo. Esto
 * facilita el uso de diferentes salidas, como consola o interfaz grafica
 * (Swing), sin tener que modificar la logica de la batalla.
 * 
 * Las clases que implementan esta interfaz deben definir como mostraran la
 * salida que genera la batalla.
 * 
 * Ejemplos de implementaciones: - {@code SalidaConsola}: muestra los resultados
 * por consola. - {@code SalidaSwing}: muestra los resultados en un JTextArea de
 * una interfaz Swing.
 * 
 * @author Ana Avalos
 */
@FunctionalInterface
public interface SalidaBatalla {

	/**
	 * Imprime una linea de texto como resultado de la batalla.
	 *
	 * @param linea La línea de texto a mostrar.
	 */
	void imprimir(String linea);

}
