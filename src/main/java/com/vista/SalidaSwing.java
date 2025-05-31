package com.vista;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;

import com.utilidades.SalidaBatalla;

public class SalidaSwing implements SalidaBatalla {

	 private JTextArea area;

	    public SalidaSwing(JTextArea area) {
	        this.area = area;
	    }

	    @Override
	    public void imprimir(String linea) {
	        area.append(linea + "\n");
	    }
	  

}
