package fila;

public class Queue<T> {

    //Capacidad del arreglo, ponemos un número muy grande para 
    //simular capacidad infinita
    public static final int CAPACITY = 1000; 
    //lugar para guardar los valores

    private T[] data;
    //la cantidad de elementos en la fila

    private int size=0;

    /**
     * Crear un nuevo objeto tipo Fila
     * 
     * */
    @SuppressWarnings("unchecked")
    public Queue() {
        this.data  = (T[])new Object[CAPACITY];
    }

    /**
     *  Regresa TRUE si la fila está vacía.
    *  @return 
    */
    public boolean isEmpty(){        
        return (this.size==0);
    }

    /**
    *  Regresa el tamaño de la fila.
    *  @return 
    */
    public int size(){
        return (this.size);
    }
    
    /**
    *  Añade un elemento al tope de la fila
    *  @param value to push
    */ 
    public void push(T value){
        //agrega en el tope de la fila el valor correspondiente
        this.data[this.size] = value;

        //aumenta el tamaño de la fila
        this.size++;
    }

    /**
    *  Obtiene el tope de la fila y lo borra de la misma
    *  @return el valor del tope
    *  @throws Exception 
    */
      public T pop() throws Exception{
        T result = null;

        //si está vacía la fila regresa una excepción 
        if (this.isEmpty()) {
          throw  new Exception("La Fila está vacía");
        }

        //obtenemos el elemento de hasta delante
        result = this.data[0];
    
        //movemos todos los elementos una posición
        for (int i=0; i<this.size-1; i++){
            data[i]=data[i+1];            
        }
    
        this.data[this.size] = null; //Garbage collector
        
         //disminuimos el tamaño de la fila
        this.size--;        
        return result;
    }

        /**
    *  Obtiene el tope de la fila sin borrarlo de la misma
    *  @return el valor del tope
    *  @throws Exception 
    */ 
    public T peek() throws Exception {
        T result = null;

        if (this.isEmpty()) {
            throw new Exception("La Fila está vacía");
        }
        result = this.data[0]; 
        return result;


}