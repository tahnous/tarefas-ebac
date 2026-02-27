package org.example;

public class Calculadora {

    /**
     * Realiza a soma de dois números inteiros.
     *
     * @param a O primeiro valor para a soma.
     * @param b O segundo valor para a soma.
     * @return A soma resultante de a + b.
     */
    public int adicionar(int a, int b) {
        return a + b;
    }

    /**
     * Realiza a subtração entre dois números inteiros.
     *
     * @param a O valor do minuendo.
     * @param b O valor do subtraendo.
     * @return O resultado da diferença de a - b.
     */
    public int subtrair(int a, int b) {
        return a - b;
    }

    /**
     * Realiza a multiplicação de dois números inteiros.
     *
     * @param a O primeiro fator.
     * @param b O segundo fator.
     * @return O produto resultante de a * b.
     */
    public int multiplicar(int a, int b) {
        return a * b;
    }

    /**
     * Realiza a divisão inteira entre dois números.
     *
     * @param a O dividendo.
     * @param b O divisor (não deve ser zero).
     * @return O quociente da divisão de a / b.
     * @throws ArithmeticException Caso o divisor (b) seja zero.
     */
    public int dividir(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Divisão por zero não permitida.");
        }
        return a / b;
    }
}
