package src.fila;

import src.nodos.PriorityNode;

public class PriorityQueue<dataType> {

    // Capacidad del arreglo, ponemos un número muy grande para
    // simular capacidad infinita
    public static final int CAPACITY = 1000;

    // la cantidad de elementos en la fila
    private int size = 0;

    PriorityNode<dataType>[] data;

    @SuppressWarnings("unchecked")
    public PriorityQueue() {
        data = new PriorityNode[CAPACITY + 1]; // Usamos 1-based index
    }
    // Extrae el elemento de mayor prioridad (menor valor de prioridad)
    public dataType pop() {
        if (size == 0) {
            throw new IllegalStateException("La fila está vacía");
        }
        PriorityNode<dataType> min = data[1];
        data[1] = data[size];
        data[size] = null;
        size--;
        heapify(1);
        return min.getData();
    }

    // Reordena el heap después de extraer el mínimo
    private void heapify(int i) {
        int left = 2 * i;
        int right = 2 * i + 1;
        int smallest = i;
        if (left <= size && data[left].getPriority() < data[smallest].getPriority()) {
            smallest = left;
        }
        if (right <= size && data[right].getPriority() < data[smallest].getPriority()) {
            smallest = right;
        }
        if (smallest != i) {
            PriorityNode<dataType> temp = data[i];
            data[i] = data[smallest];
            data[smallest] = temp;
            heapify(smallest);
        }
    }

    // Muestra todos los elementos en orden de prioridad (sin modificar la fila)
    public void showAscending() {
        // Copiamos la fila para no modificarla
        PriorityQueue<dataType> copia = new PriorityQueue<>();
        for (int i = 1; i <= size; i++) {
            copia.push(data[i].getPriority(), data[i].getData());
        }
        System.out.println("Elementos en orden ascendente de prioridad:");
        while (copia.size > 0) {
            System.out.print(copia.pop() + " ");
        }
        System.out.println();
    }

    public void push(int priority, dataType value) {
        // Creamos nodo a insertar
        PriorityNode<dataType> nodeToInsert = new PriorityNode<dataType>(priority, value);

        // Aumentamos el tamaño de la fila priorizada
        this.size++;

        // Si es el primero lo ponemos en la posición 1 y listo
        if (size == 1) {
            data[size] = nodeToInsert;
        } else {

            // Si no está vacía la fila priorizada
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
