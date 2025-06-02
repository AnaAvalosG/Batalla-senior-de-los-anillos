package com.vista;


import javax.swing.SwingUtilities;

import com.controlador.JuegoElSenorDeLosAnillos;

public class MainCampoBatalla {

	public static void main(String[] args) {
		System.out.println("¡Batalla épica comienza!");

	JuegoElSenorDeLosAnillos comenzarJuego = new JuegoElSenorDeLosAnillos();
	
	//comenzarJuego.iniciarBatalla(new SalidaConsola());
	
	SwingUtilities.invokeLater(BatallaSwingVista::new);
	}

}
