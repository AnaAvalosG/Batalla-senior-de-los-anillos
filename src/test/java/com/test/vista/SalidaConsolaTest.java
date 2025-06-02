package com.test.vista;

import com.utilidades.SalidaBatalla;
import com.vista.SalidaConsola;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SalidaConsolaTest {

    @Test
    void testImprimir() {
        // Redirige System.out a un ByteArrayOutputStream
        ByteArrayOutputStream salidaCapturada = new ByteArrayOutputStream();
        PrintStream salidaOriginal = System.out;
        System.setOut(new PrintStream(salidaCapturada));

        SalidaBatalla salida = new SalidaConsola();
        salida.imprimir("Mensaje de prueba");

        System.setOut(salidaOriginal); // Restaura System.out

        assertEquals("Mensaje de prueba" + System.lineSeparator(), salidaCapturada.toString());
    }
}
