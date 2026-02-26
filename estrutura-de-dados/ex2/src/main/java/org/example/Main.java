package org.example;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Map<Integer, BigInteger> memo = new HashMap<>();
    public static void main(String[] args) {

        java.math.BigInteger n = fat(100);
        System.out.println(n);
        n = fatTopDown(100);
        System.out.println(n);
        n = fatBottomUp(100);
        System.out.println(n);


    }

    // Exercicio 1
    // Para contornar o limite de 32 bits do tipo int, devemos usar a classe BigInteger do pacote java.math.
    //  Ela permite armazenar números inteiros com precisão limitada apenas pela memória RAM disponível
    static BigInteger fat(int n) {
        if (n == 0 || n == 1) {
            return BigInteger.ONE;
        }
        // BigInteger requer métodos para operações matemáticas
        return BigInteger.valueOf(n).multiply(fat(n - 1));
    }

    // Exercicio 2 a programação dinamica leva vantagem por armazenar o resultado de operações anteriores, evitando o uso execisso da pilha
    static BigInteger fatBottomUp(int n) {
        if (n == 0 || n == 1) return BigInteger.ONE;

        BigInteger[] tabela = new BigInteger[n + 1];
        tabela[0] = BigInteger.ONE;
        tabela[1] = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            tabela[i] = tabela[i - 1].multiply(BigInteger.valueOf(i));
        }

        return tabela[n];
    }
    
    static BigInteger fatTopDown(int n) {

        if (n == 0 || n == 1) return BigInteger.ONE;

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        BigInteger result = BigInteger.valueOf(n).multiply(fatTopDown(n - 1));
        memo.put(n, result);
        return result;
    }
    // Exercicio 3:
    // Na Programação Dinâmica: O resultado de cada subproblema é calculado apenas uma vez e armazenado.
    // Se o programa precisar do resultado de novo, ele apenas o lê da memória (
    // Na recursão pura, o computador frequentemente resolve o mesmo subproblema várias vezes, piorando o tempo de execução.
    // Além disso a recursao pura abusa do uso da memoria pois ela utiliza a pilha da memoria para as chamadas recursivas.
    // Já a programação sa um simples laço for e armazena os dados na Heap, que é uma área de memória muito maior e mais estável,
    // evitando o uso excessivo de memoria devido a recursividade.
}