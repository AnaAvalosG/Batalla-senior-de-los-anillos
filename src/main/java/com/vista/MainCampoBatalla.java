package com.vista;

import javax.swing.SwingUtilities;

import com.controlador.JuegoElSenorDeLosAnillos;

/**
 * Clase principal del proyecto que inicia la batalla en consola y luego lanza
 * la interfaz grafica con Swing. Este archivo combina tanto la simulación por
 * consola como la vista grafica. Primero ejecuta una simulaciono con personajes
 * predefinidos (consola) y luego lanza la vista de formulario con Swing.
 * 
 * @author Ana Avalos
 */
public class MainCampoBatalla {

	/**
	 * Metodo principal que inicia la aplicacion.
	 * 
	 * Ejecuta primero la batalla por consola y luego inicializa la vista grafica
	 * Swing para permitir la interaccion del usuario.
	 * 
	 * @param args argumentos de la linea de comandos (no se utilizan).
	 */
	public static void main(String[] args) {
		System.out.println("¡Batalla épica comienza!");

		JuegoElSenorDeLosAnillos comenzarJuego = new JuegoElSenorDeLosAnillos();

		comenzarJuego.iniciarBatalla(new SalidaConsola());

		SwingUtilities.invokeLater(BatallaSwingVista::new);
	}

}
