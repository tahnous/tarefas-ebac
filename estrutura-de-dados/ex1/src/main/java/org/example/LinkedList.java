package org.example;

public class LinkedList <T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    // Complexidade O(1). Elemento adicionado no fim sem percorrer a lista
    public void push(T value) {
        if (size == 0) {
            head = tail = new Node<>(value);
        } else {
            tail.proximo = new Node<>(value);
            tail = tail.proximo;
        }
        size++;
    }


    public void removeHead() {
        if (head == null) {
            return;
        }
        head = head.proximo;
        if (head == null) {
            tail = null;
        }
        size--;
    }
    // Complexidade O(n). Exige percorrer a lista até o nó anterior ao que será removido
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        if (index == 0) {
            removeHead();
            return;
        }

        Node<T> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.proximo;
        }

        if (current.proximo == tail) {
            tail = current;
        }

        current.proximo = current.proximo.proximo;
        size--;
    }
    // Complexidade O(n). Para remover o último nó, deve ser percorrido do head até o penúltimo nó para atualizar o tail.
    public Node <T> pop() {

        if (head == null) {
            return null;
        }

        Node<T> removedNode = tail;

        if (head == tail) {
            head = tail = null;
            size = 0;
            return removedNode;
        }

        Node<T> current = head;
        while (current.proximo != tail) {
            current = current.proximo;
        }

        tail = current;
        tail.proximo = null;
        size--;

        return removedNode;
    }

    public int size() {
        return size;
    }

    //Complexidade O(n). É necessário caminhar nó por nó até o indice
    public Node <T> elementAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.proximo;
        }

        return current;
    }

    public void printList() {
        Node<T> current = head;
        System.out.print("Lista: ");

        while (current != null) {
            System.out.print(current.valor + " ");
            current = current.proximo;
        }

        System.out.println("null");
    }
    // Complexidade O(n). Necessário percorrer n elementos. No melhor caso (índice 0), é
    // O(1)
    public void insert(int index, T value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Índice fora dos limites");
        }

        if (index == 0) {
            Node<T> newNode = new Node<>(value);
            newNode.proximo = head;
            head = newNode;
            if (size == 0) {
                tail = head;
            }
            size++;
            return;
        }

        if (index == size) {
            push(value);
            return;
        }

        Node<T> current = head;

        for (int i = 0; i < index - 1; i++) {
            current = current.proximo;
        }

        Node<T> newNode = new Node<>(value);
        newNode.proximo = current.proximo;
        current.proximo = newNode;
        size++;
    }


}
