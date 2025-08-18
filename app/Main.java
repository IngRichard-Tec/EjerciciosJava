package app;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import src.pila.EvaluarPostfija;
import src.pila.InfijaAPostfija;
import src.pila.Stack;

public class Main {
    
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Escribe la expresion infija: ");
        String infija = sc.nextLine(); // "7 - (2*3) + 3";
        String postfija = "";

        try {
            postfija = InfijaAPostfija.convertir(infija);
            System.out.println("Infija: " + infija);
            System.out.println("Postfija: " + postfija);

            double resultado = EvaluarPostfija.evaluar(postfija);
            System.out.println("Resultado: " + resultado);

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }


    public static void EjemploStack()
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
