package com.test.controlador;

import com.controlador.JuegoElSenorDeLosAnillos;
import com.utilidades.SalidaBatalla;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JuegoElSenorDeLosAnillosTest {

    private StringBuilder salidaCapturada;
    private SalidaBatalla salida;

    @BeforeEach
    void setUp() {
        salidaCapturada = new StringBuilder();
        salida = linea -> salidaCapturada.append(linea).append("\n");
    }

    @Test
    void iniciarBatallaDebeGenerarResultado() {
        JuegoElSenorDeLosAnillos juego = new JuegoElSenorDeLosAnillos();

        juego.iniciarBatalla(salida);

        String resultado = salidaCapturada.toString();

        // Aseguramos que al menos uno de los mensajes finales aparezca
        assertTrue(
            resultado.contains("La victoria pertenece a los heroes!") ||
            resultado.contains("¡No!, las bestias lograron la victoria"),
            "La salida debe indicar un resultado final de la batalla"
        );
    }
}
