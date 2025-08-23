package src.lista;

import src.nodos.Node;

public class SimpleList<T> {
    //ATRIBUTO
    public Node<T> firstNode;

    //CONSTRUCTOR1 
    public SimpleList(Node<T> first)
    {
        this.firstNode = first;
    }
    //CONSTRUCTOR2
    public SimpleList()
    {
        this.firstNode = null;
    }

    /* Función para insertar en la primera posición el NUEVO NODO */
    public void insertarPrimeraPosicion(T value)
    {
       Node<T> nodeInsert = new Node<>(value); 
       nodeInsert.setNext(this.firstNode);        
       this.firstNode = nodeInsert;  
    }

    /* Función para insertar en la última posición el NUEVO NODO */
    public void insertarUltimaPosicion(T value)
    {
        Node<T> nodeInsert = new Node<>(value);
              
        if (this.firstNode == null) {
            nodeInsert.setNext(this.firstNode);
            this.firstNode = nodeInsert; 
        }
        else 
        {
            Node<T> actual  = this.firstNode; 
            while(actual.getNext() != null) { 
                actual = actual.getNext(); 
            }
            actual.setNext(nodeInsert);
        }
    }

    //Metodo para imprimir la lista
    public void mostrarLista() {
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

    // Método para buscar un elemento en la lista e indicar su posición (la primera posición es 1)
    public int encontrar(T value) {
        Node<T> current = this.firstNode;
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
        Node<T> current = this.firstNode;
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
        if (this.firstNode == null) {
            return; 
        }

        // Si solo hay un nodo
        if (this.firstNode.getNext() == null) {
            this.firstNode = null; 
            return;
        }

        // Recorrer la lista para encontrar el último nodo
        Node<T> current = this.firstNode;
        Node<T> previous = null;

        while (current != null) {
            // Si el valor a borrar es el primer nodo
            if (this.firstNode.getData().equals(value)) {
                this.firstNode = this.firstNode.getNext();
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
