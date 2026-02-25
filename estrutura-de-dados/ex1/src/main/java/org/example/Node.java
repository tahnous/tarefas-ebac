package org.example;

public class Node<T> {
    T valor;
    Node<T> proximo;

    public Node(T valor) {
        this.valor = valor;
        this.proximo =  null;
    }
}
