package src.app;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import src.pila.Stack;

public class Main {
    
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Stack <Integer> myStack = new Stack();
        int size =0 ; // tamaño elegido por el usuario
        int currentData=0; // dato  de un nodo en cuestión

        System.out.print("¿Cuántos  elementos deseas agregar?");
        size = sc.nextInt();

        for (int i=0; i<size; i++) {
            System.out.print("Inserta el  elemento "+ (i+1));
            currentData = sc.nextInt();
            myStack.push(currentData);
        }        

        // Muestra la lista
        System.out.println("Los elementos de la  Pila son:");
        myStack.show();        

        try {
            myStack.pop();
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Los elementos de la  Pila son:");
        myStack.show();
    }
}
