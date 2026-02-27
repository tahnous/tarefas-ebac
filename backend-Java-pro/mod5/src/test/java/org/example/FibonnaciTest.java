package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @Test
    void deveRetornarCasosBase() {
        assertAll(
                () -> assertEquals(0, Fibonacci.findElementorDP(0), "Fibonacci de 0 deve ser 0"),
                () -> assertEquals(1, Fibonacci.findElementorDP(1), "Fibonacci de 1 deve ser 1")
        );
    }

    @ParameterizedTest
    @CsvSource({
            "2, 1",
            "3, 2",
            "4, 3",
            "5, 5",
            "6, 8",
            "10, 55"
    })
    void deveCalcularValoresSequencia(int entrada, int esperado) {
        assertEquals(esperado, Fibonacci.findElementorDP(entrada));
    }

    @Test
    void deveLancarExcecaoParaIndiceInvalido() {
        // O array tem tamanho 100 (índices 0 a 99). 100 deve estourar o limite.
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            Fibonacci.findElementorDP(100);
        });
    }
}

