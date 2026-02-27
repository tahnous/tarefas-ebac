package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculadoraTest {

    private Calculadora calc;


    @BeforeEach
    void setup() {
        calc = new Calculadora();
    }


    @Test
    void testeAdicionar() {
        assertEquals(10, calc.adicionar(7, 3));
    }


    @Test
    void testeSubtrair() {
        assertEquals(4, calc.subtrair(10, 6));
    }


    @Test
    void testeMultiplicar() {
        assertEquals(20, calc.multiplicar(4, 5));
    }


    @Test
    void testeDividir() {
        assertEquals(0, calc.dividir(0, 10));
        assertEquals(5, calc.dividir(10, 2));
    }

    @Test
    void testeDividirPorZero() {

        assertThrows(ArithmeticException.class, () -> {
            calc.dividir(10, 0);
        });
    }
}
