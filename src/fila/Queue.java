package src.fila;

import src.lista.SimpleList;

public class Queue<T> {
    private SimpleList<T> list;

    public Queue() {
        this.list = new SimpleList<>();
    }

    public void enqueue(T data) {
        list.insertarUltimaPosicion(data);
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T data = list.firstNode.getData();
        list.borrarNodo(data);
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return list.firstNode.getData();
    }

    public boolean isEmpty() {
        return list.firstNode == null;
    }

    public void mostrar() {
        if (isEmpty()) {
            System.out.println("Fila vacía");
            return;
        }
        System.out.print("Fila: ");
        list.mostrarLista();
    }
}