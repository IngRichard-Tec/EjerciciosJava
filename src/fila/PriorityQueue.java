package src.fila;

import src.nodos.PriorityNode;

public class PriorityQueue<dataType> {

    // Capacidad del arreglo, ponemos un número muy grande para
    // simular capacidad infinita
    public static final int CAPACITY = 1000;

    // la cantidad de elementos en la cola
    private int size = 0;

    PriorityNode<dataType>[] data;

    public PriorityQueue() {
        data = null;
    }

    public void push(int priority, dataType value) {
        // Creamos nodo a insertar
        PriorityNode<dataType> nodeToInsert = new PriorityNode<dataType>(priority, value);

        // Aumentamos el tamaño de la cola priorizada
        this.size++;

        // Si es el primero lo ponemos en la posición 1 y listo
        if (size == 1) {
            data[size] = nodeToInsert;

        } else {

            // Si no está vacía la cola priorizada
            // la posición temporal es la última
            int myPosition = size;

            // ponemos el nodo ahí
            data[myPosition] = nodeToInsert;

            /* encontramos la posición del padre */
            int myParentPosition = (int) (myPosition / 2);

            // Y guardamos el valor del padre
            PriorityNode<dataType> myParent = data[myParentPosition];

            // repetimos intercambiar el padre con el hijo hasta que el padre
            // tenga mayor prioridad que el hijo
            while (myPosition != 1 && myParent.getPriority() > nodeToInsert.getPriority()) {
                data[myPosition] = myParent;
                data[myParentPosition] = nodeToInsert;
                myPosition = myParentPosition;
                myParentPosition = (int) (myParentPosition / 2);
                myParent = data[myParentPosition];
            }
        }
    }
}
