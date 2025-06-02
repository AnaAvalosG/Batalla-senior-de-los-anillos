package com.test.vista;

import org.junit.jupiter.api.Test;

import com.vista.SalidaSwing;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class SalidaSwingTest {

    @Test
    void testImprimir() {
        JTextArea area = new JTextArea();
        SalidaSwing salida = new SalidaSwing(area);

        salida.imprimir("Texto visible");
        assertTrue(area.getText().contains("Texto visible"));
    }
}

