package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Exercicio 1
        System.out.print("(EX1)S=: ");
        String conjunto = scanner.next();
        int[] S = Arrays.stream(conjunto.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.print("(EX1)n=:");
        int n = scanner.nextInt();

        List<List<Integer>> resultado = encontrarSubconjuntos(S, n);

        System.out.println("Saída: " + resultado);

        //  Exercicio 2
        System.out.print("Digite a quantia para o troco: ");
        int quantia = scanner.nextInt();
        System.out.print("Digite moedas disponiveis (ex: 5,2,1): ");
        String moedas1 = scanner.next();
        int[] moedas = Arrays.stream(moedas1.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println("Troco para " + quantia + ":");

        calcularTroco(quantia, moedas);

        scanner.close();

    }
    static void calcularTroco(int valor, int[] moedas) {
        int restante = valor;
        int totalMoedas = 0;

        for (int moeda : moedas) {
            if (restante >= moeda) {
                int quantidadeMoedas = restante / moeda;
                restante = restante % moeda;
                totalMoedas += quantidadeMoedas;

                System.out.println(quantidadeMoedas + " moeda(s) de " + moeda);
            }
        }
    }

    static List<List<Integer>> encontrarSubconjuntos(int[] S, int n) {
        List<List<Integer>> resultado = new ArrayList<>();
        backtrack(resultado, new ArrayList<>(), S, n, 0);
        return resultado;
    }

    private static void backtrack(List<List<Integer>> resultado, List<Integer> temp, int[] S, int n, int inicio) {
        if (temp.size() == n) {
            resultado.add(new ArrayList<>(temp));
            return;
        }


        for (int i = inicio; i < S.length; i++) {
            temp.add(S[i]); // Escolha
            backtrack(resultado, temp, S, n, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
