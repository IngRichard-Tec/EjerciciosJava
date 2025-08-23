package src.nodos;

public class PriorityNode<dataType> {

  private int priority;
  private dataType data;

  /**
   * Constructor Simple
   */
  public PriorityNode() {

  }

  /**
   * Constructor con parámetros
   * 
   * @param priority Número entero de prioridad.
   * @param data     Tipo de dato a almacenar
   */
  public PriorityNode(int priority, dataType data) {
    this.priority = priority;
    this.data = data;
  }

  /**
   * Regresa la prioridad del Nodo
   * 
   * @return número entero
   */
  public int getPriority() {
    return priority;
  }

  /**
   * Establece la prioridad del Nodo
   * 
   * @param priority Número entero de prioridad
   */
  public void setPriority(int priority) {

    this.priority = priority;

  }

  /**
   * Obtiene el dato del nodo
   * 
   * @return Regresa el valor del Nodo
   */
  public dataType getData() {

    return data;

  }

  /**
   * Establece el dato del nodo
   * @param data Tipo de dato a almacenar
   */
  public void setData(dataType data) {

    this.data = data;

  }

  /**
   * Regresa una cadena con los datos del nodo
   * @return String
   */
  @Override
  public String toString() {

    return "ProrityNode{" + "priority=" + priority + ", data=" + data + '}';

  }
}