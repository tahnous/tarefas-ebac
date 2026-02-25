package org.example;

public class Fila {

    int[] fila;
    int count;

    public  Fila() {
        fila = new int [1];
        this.count = 0;
    }
    // Complexidade O(n)
    void enqueue (int x) {
        int aux[] = new int [2 * count+1];
        for (int i = 0; i < count; i++)
            aux[i] = fila[i];
        aux[count++] = x;
        fila = aux;
    }
    // Complexidade O(n)
    void dequeue () {
        int aux[] = new int[2 * count-1];
        for (int i = 1; i < count; i++) {
            aux[i-1] = fila[i];
        }
        fila = aux;
        count--;
    }
    // Complexidade O(1)
    int rear() {
        return fila[count -1 ];
    }
    // Complexidade O(1)
    int front() {
        return fila[0];
    }
    boolean isEmpty () {
        return count == 0;
    }
    int size () {
        return count;
    }
}
