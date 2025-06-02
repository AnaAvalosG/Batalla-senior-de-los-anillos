package com.test.vista;

import org.junit.jupiter.api.Test;

import com.vista.MainCampoBatalla;

import static org.junit.jupiter.api.Assertions.*;

class MainCampoBatallaTest {

    @Test
    void testMainNoLanzaErrores() {
        assertDoesNotThrow(() -> MainCampoBatalla.main(new String[]{}));
    }
}

