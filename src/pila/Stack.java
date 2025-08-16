package src.pila;

public class Stack<T> {

    //Capacidad del arreglo, ponemos un número muy grande para 
    //simular capacidad infinita
    public static final int CAPACITY = 1000;
    
    //lugar para guardar los valores
    private T[] data;

    //la cantidad de elementos en la pila
    private int size = 0;

    //Crea un nuevo objeto tipo Stack 
    public Stack() {
        this.data = (T[]) new Object[CAPACITY];
    }
    
    /**      
    *  Regresa TRUE si la pila esta vacía.
    *  @return 
    */ 
    public boolean isEmpty(){        
        return  (this.size==0);
    }

    /**
    *  Regresa el tamaño de la pila.
    *  @return 
    */ 
    public int size(){
        return  (this.size);
    }

    /**
     *  Añade un elemento al tope de la pila
    *  @param value to push
    */ 
    public void push(T value){
        //agrega en el tope de la pila el valor correspondiente
        this.data[this.size] = value;

        //aumenta el tamaño de la pila
        this.size++;
    }

    /**
    *  Obtiene el tope de la pila y lo borra de la misma
    *  @return el valor del tope
    *  @throws Exception 
    */
      public T pop() throws Exception{
        T  result = null;

        //si está vacía la pila regresa una excepción 
        if (this.isEmpty()) {
          throw  new Exception("La  Pila está vacía");
        }

        this.size--;
        result = this.data[this.size];
        this.data[this.size]= null; //Garbage collector 
        
        return result;
    }

    /**
    *  Obtiene el tope de la pila sin borrarlo de la misma
    *  @return el valor del tope
    *  @throws Exception 
    */ 
    public T peek() throws Exception{
        T  result = null;
        
        //si está vacía la pila regresa una excepción
        if (this.isEmpty()){
            throw  new Exception("La  Pila está vacía");
        }
        
        result = this.data[this.size];
        return result;
    }

    /**
    *  Muestra los elementos de la pila
    */
    public void show() {
        for (int i = size - 1; i >= 0; i--) {
            System.out.println(data[i]);
        }
    }

}
