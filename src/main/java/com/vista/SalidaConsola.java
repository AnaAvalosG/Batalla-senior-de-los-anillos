package com.vista;

import com.utilidades.SalidaBatalla;

/**
 * Implementacion de la interfaz {@link SalidaBatalla} que muestra la salida por
 * consola estandar.
 * 
 * Utilizada cuando se ejecuta la simulacion sin interfaz grafica, permitiendo
 * que los mensajes del combate se impriman directamente en la terminal del
 * sistema.
 * 
 * @author Ana Avalos
 */
public class SalidaConsola implements SalidaBatalla {

	/**
	 * Imprime una linea de texto en la consola.
	 * 
	 * @param linea El mensaje que se desea imprimir.
	 */
	@Override
	public void imprimir(String linea) {
		System.out.println(linea);
	}

}
