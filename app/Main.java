package app;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;
import src.fila.PriorityQueue;
import src.pila.EvaluarPostfija;
import src.pila.InfijaAPostfija;
import src.pila.Stack;
import src.tablaHash.Hashtable;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Hashtable<Integer> numbers = new Hashtable<Integer> ();
        numbers.put("one", 1);
        numbers.put("two", 2);
        numbers.put("three",3);

    }

    public static void ejemploPriorityQueue() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Random rand = new Random();
        int cantidad = 20; // Puedes cambiar la cantidad de elementos
        System.out.println("Agregando valores aleatorios a la PriorityQueue:");
        for (int i = 0; i < cantidad; i++) {
            int valor = rand.nextInt(100) + 1; // 1 a 100
            pq.push(valor, valor); // prioridad y valor iguales
            System.out.print(valor + " ");
        }
        System.out.println("\n\nMostrando en orden ascendente de prioridad:");
        pq.showAscending();
    }

    public static void ejemploStack()
    {
        Stack<Integer> myStack = new Stack<Integer>();
        int size =0 ; // tamaño elegido por el usuario
        int currentData=0; // dato  de un nodo en cuestión

        System.out.print("¿Cuántos  elementos deseas agregar?: ");
        size = sc.nextInt();

        for (int i=0; i<size; i++) {
            System.out.print("Inserta el  elemento " + (i+1) + " : ");
            currentData = sc.nextInt();
            myStack.push(currentData);
        }        

        // Muestra la lista
        System.out.println("Los elementos de la  Pila son: ");
        myStack.show();        

        try {
            myStack.pop();
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Los elementos de la  Pila son: ");
        myStack.show();
    }
}
