package src.lista;

import src.nodos.Node;

public class DoubleList<T> {
    //ATRIBUTO
    private Node<T> firstNode;
    private Node<T> lastNode;

    //CONSTRUCTOR1 
    public DoubleList(Node<T> first, Node<T> last)
    {
        this.firstNode = first;
        this.lastNode = last;
    }
    //CONSTRUCTOR2
    public DoubleList()
    {
        this.firstNode = null;
        this.lastNode = null;
    }

    /* Función para insertar en la primera posición el NUEVO NODO */
    public void insertarPrimeraPosicion(T value)
    {
        /* 1) Crear el nuevo NODO a insertar con el valor que le pasas como parametro */
        Node<T> nodeInsert = new Node<>(value); 

        if (this.firstNode == null) { 

            this.lastNode = nodeInsert;
            this.firstNode = nodeInsert;
        }
        else
        {
            nodeInsert.setNext(this.firstNode);
            
            this.firstNode.setPrevious(nodeInsert);
            this.firstNode = nodeInsert;
        }
    }

    /* Función para insertar en la última posición el NUEVO NODO */
    public void insertarUltimaPosicion(T value)
    {
        Node<T> nodeInsert = new Node<>(value);
              
        //Si la lista está vacía, entonces asigar en nodo nuevo (nodeInsert)
        if (this.firstNode == null) { 
            this.firstNode = nodeInsert;
            this.lastNode = nodeInsert;
        }
        // Si exites el primer nodo
        else 
        {
            nodeInsert.setPrevious(this.lastNode);
            
            this.lastNode.setNext(nodeInsert);
            this.lastNode = nodeInsert;
        }
    }

    public void mostrarListaIzqDer() {
        Node<T> current = this.firstNode;
        while (current != null) {
            System.out.print(current.getData());
            if (current.getNext() != null) {
                System.out.print(" -> ");
            }
            current = current.getNext();
        }
        System.out.println();
    }

    public void mostrarListaDerIzq() {
        Node<T> current = this.lastNode;
        while (current != null) {
            System.out.print(current.getData());
            if (current.getPrevious() != null) {
                System.out.print(" -> ");
            }
            current = current.getPrevious();
        }
        System.out.println();
    }

    // Método para buscar un elemento en la lista e indicar su posición (la primera posición es 1)
    public int encontrar(T value) {
        Node<T> current = firstNode;
        int posicion = 1;
        while (current != null) {
            if (current.getData().equals(value)) {
                
                return posicion;
            }
            current = current.getNext();
            posicion++;
        }
        return -1;
    }

    // Método para actualizar un elemento en la lista
    public boolean actualizar(T viejo, T nuevo) {
        Node<T> current = firstNode;
        while (current != null) {
            if (current.getData().equals(viejo)) {
                current.setData(nuevo);
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public void borrarNodo(T value)
    {
        //Lista vacia
        if (firstNode == null) {
            return; 
        }

        // Si solo hay un nodo
        if (firstNode.getNext() == null) {
            firstNode = null; 
            return;
        }

        // Recorrer la lista para encontrar el último nodo
        Node<T> current = firstNode;
        Node<T> previous = null;

        while (current != null) {
            // Si el valor a borrar es el primer nodo
            if (firstNode.getData().equals(value)) {
                firstNode = firstNode.getNext();
                return;
            }
            else if (current.getData().equals(value)) {
                if (previous != null) {
                    previous.setNext(current.getNext());
                }
                return;
            }

            previous = current;
            current = current.getNext();
        }   
    }
}
