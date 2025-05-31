package com.vista;

import com.utilidades.SalidaBatalla;

public class SalidaConsola implements SalidaBatalla {

	@Override
	public void imprimir(String linea) {
		 System.out.println(linea);
	}

}
