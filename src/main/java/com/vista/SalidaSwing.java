package com.vista;

import javax.swing.JTextArea;

import com.utilidades.SalidaBatalla;

/**
 * Implementacion de la interfaz {@link SalidaBatalla} que muestra la salida del
 * combate en un componente grafico {@link JTextArea} utilizando Swing.
 *
 * Permite redirigir la salida de los mensajes de batalla a una interfaz grafica
 * en lugar de la consola, facilitando la interaccion con el usuario a traves de
 * la GUI.
 * 
 * Se utiliza principalmente cuando se lanza la simulación desde la vista
 * {@code BatallaSwingVista}.
 * 
 * @author Ana Avalos
 */
public class SalidaSwing implements SalidaBatalla {

	private JTextArea area;

	/**
	 * Crea una nueva instancia de {@code SalidaSwing}.
	 * 
	 * @param area El componente {@code JTextArea} donde se mostraran los mensajes.
	 */
	public SalidaSwing(JTextArea area) {
		this.area = area;
	}

	/**
	 * Añade una linea de texto al componente {@code JTextArea}.
	 * 
	 * @param linea El mensaje que se desea mostrar.
	 */
	@Override
	public void imprimir(String linea) {
		area.append(linea + "\n");
	}

}
