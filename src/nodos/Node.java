package src.nodos;

public class Node<T> {
    
    //atributos
    private T data; //TIPO DE DATO: E (elemento generico) nombre: data
    private Node<T> next; //TIPO DE OBJETO: NODE, nombre: next
    private Node<T> previous; //TIPO DE OBJETO: NODE, nombre: previous

    public Node(T data)
    {
        this.data = data;
    }

    //CONSTRUCTOR 1
    public Node(T data, Node<T> next)
    {
        this.data = data;
        this.next = next;
    }

    public Node(T data, Node<T> previous, Node<T> next)
    {
        this.previous = previous;
        this.data = data;
        this.next = next;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    public T getData()  {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
