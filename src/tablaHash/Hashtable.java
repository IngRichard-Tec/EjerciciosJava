package src.tablaHash;

import src.lista.SimpleList;

public class Hashtable<E> {
        public static final int M = 23; //Tamaño del listado  
        @SuppressWarnings("unchecked")
        SimpleList<E>[] data = (SimpleList<E>[]) new SimpleList[M]; //Arreglo de Listas

        /**
        * Hashfunction división
        * @param value Valor a encontrar su hashfunction
        * @return key
        */ 
        private int hashfunction(E value) {
                int result=0;
                
                //Asumiendo que el valor se puede castear a entero
                result = ((Integer)value)%M;
                return result;
        }

        public Hashtable() {
                for (int i = 0; i < M; i++) {
                        data[i] = new SimpleList<E>();
                }
        }

        /**
         * Inserta un elemento en la tabla hash
         * @param key Clave (no se usa en esta implementación)
         * @param value Valor a insertar
         */
        public void put(String key, E value) {
                int index = hashfunction(value);
                data[index].insertarUltimaPosicion(value);
        }

}

