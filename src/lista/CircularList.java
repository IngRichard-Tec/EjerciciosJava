package src.lista;

import src.nodos.Node;

public class CircularList<T> {
    //ATRIBUTO
    private Node<T> firstNode;

    //CONSTRUCTOR1 
    public CircularList(Node<T> first, Node<T> last)
    {
        this.firstNode = first;
    }
    //CONSTRUCTOR2
    public CircularList()
    {
        this.firstNode = null;
    }
    /* Función para insertar en la primera posición el NUEVO NODO */
    public void insertarPrimeraPosicion(T value)
    {
        Node<T> nodeInsert = new Node<>(value);
              
        if (this.firstNode == null) { 
            this.firstNode = nodeInsert; 
            this.firstNode.setNext(this.firstNode);
        }
        else{
            nodeInsert.setNext(this.firstNode);
            Node<T> actual = this.firstNode;
            while(actual.getNext() != this.firstNode) { 
                actual = actual.getNext(); 
            }
            actual.setNext(nodeInsert);
            this.firstNode = nodeInsert; // Actualizar el primer nodo
        }
    }

    /* Función para insertar en la última posición el NUEVO NODO */
    public void insertarUltimaPosicion(T value)
    {
        Node<T> nodeInsert = new Node<>(value);
              
        if (this.firstNode == null) { 
            this.firstNode = nodeInsert; 
            this.firstNode.setNext(this.firstNode);
        }
        else 
        {
            Node<T> actual = this.firstNode; 
            while(actual.getNext() != this.firstNode) { 
                actual = actual.getNext(); 
            }

            actual.setNext(nodeInsert);
            nodeInsert.setNext(this.firstNode);
        }
    }

    //Metodo para imprimir la lista
    public void mostrarLista() {
        Node<T> current = this.firstNode;
        while (current != null) {
            System.out.print(current.getData());
            if (current.getNext() != this.firstNode) {
                System.out.print(" -> ");
            }
            else {
                System.out.print(" -> (vuelve al inicio)");
                break;
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
            if (current == this.firstNode) {
                break; // Si volvemos al inicio, salimos del bucle
            }
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
            if (current == this.firstNode) {
                break; // Si volvemos al inicio, salimos del bucle
            }
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
        if (this.firstNode.getNext() == this.firstNode) {
            this.firstNode = null; 
            return;
        }

        // Recorrer la lista para encontrar el último nodo
        Node<T> current = this.firstNode.getNext();
        Node<T> previous = null;

        while (current != this.firstNode) {
            // Si el valor a borrar es el primer nodo
            if (this.firstNode.getData().equals(value)) {
                this.firstNode = this.firstNode.getNext();
                return;
            }
            else if (current.getData().equals(value)) {
                if (previous != this.firstNode) {
                    previous.setNext(current.getNext());
                }
                return;
            }

            previous = current;
            current = current.getNext();
        }   
    }
}
