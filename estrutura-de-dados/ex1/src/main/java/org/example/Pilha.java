package org.example;

public class Pilha {

    int [] pilha;
    int count;

    // Complexidade O(n)
    void  push (int x) {
        int aux[] = new int [2 * count+1];
        for (int i = 0; i < count ; i++)
            aux[i] = pilha[i];
        aux[count++] = x;
        pilha = aux;

    }

    int top (){
        int element = 0;
        try {
            element = pilha[count - 1];
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Pilha vazia");
        }
        return element;
    }

    boolean IsEmpty(){
        return count == 0;
    }

    int size() {
        return count;
    }
    // Complexidade O(1).
    // Operação imediata de cálculo de endereço de memória, independente do tamanho do array.
    int pop () {
        int element = 0;
        try {
             element = pilha[--count];
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Pilha vazia");
        }
        return element;
    }
    public  Pilha () {
        pilha = new int [1];
        this.count = 0;
    }

}
