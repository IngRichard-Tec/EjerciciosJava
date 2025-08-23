package src.fila;

public class QueueArray<E> {
    // Capacidad del arreglo, ponemos un número muy grande para
    // simular capacidad infinita
    public static final int CAPACITY = 1000;

    // lugar para guardar los valores
    private E[] data;

    // la cantidad de elementos en la cola
    private int size = 0;

    // Crea un nuevo objeto tipo Cola
    @SuppressWarnings("unchecked")
    public QueueArray() {
        this.data = (E[]) new Object[CAPACITY];

    }

    /**
     * Regresa TRUE si la cola está vacía.
     * 
     * @return
     */
    public boolean isEmpty() {

        return (this.size == 0);

    }

    /**
     * Regresa el tamaño de la cola.
     * 
     * @return
     */
    public int size() {

        return (this.size);

    }

    /**
     * Añade un elemento al tope de la cola
     * 
     * @param value to push
     */
    public void push(E value) {
        // agrega en el tope de la cola el valor correspondiente
        this.data[this.size] = value;
        // aumenta el tamaño del cola
        this.size++;
    }

    /**
     * Obtiene el primer elemento de la cola y lo borra de la misma
     * 
     * @return el primer elemento
     * @throws Exception
     */
    public E pop() throws Exception {
        E result = null;
        // si está vacía la cola regresa una excepción

        if (this.isEmpty()) {
            throw new Exception("La cola está vacía");
        }

        // obtenemos el elemento de hasta delante
        result = this.data[0];

        // movemos todos los elementos una posición
        for (int i = 0; i < this.size - 1; i++) {
            data[i] = data[i + 1];
        }

        this.data[this.size] = null; // Garbage collector

        // disminuimos el tamaño de la cola
        this.size--;
        return result;
    }

    /**
     * Obtiene primer elemento de la cola sin borrarlo de la misma
     * @return el valor del primer elemento
     * @throws Exception
     */

    public E peek() throws Exception {
        E result = null;
        // si está vacía la cola regresa una excepción
        if (this.isEmpty()) {
            throw new Exception("La Cola está vacía");
        }
        result = this.data[0];
        return result;
    }
}