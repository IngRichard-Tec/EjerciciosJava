package src.app;

import java.util.Stack;

public class InfijaAPostfija {
    private static final String OPERADORES = "^*/+-()";

    public static String convertir(String expresion) throws Exception {
        StringBuilder npostfija = new StringBuilder();
        Stack<Character> pila = new Stack<>();
        int len = expresion.length();
        for (int i = 0; i < len; ) {
            char c = expresion.charAt(i);
            if (Character.isWhitespace(c)) {
                i++;
                continue;
            }
            // Leer número flotante completo
            if (Character.isDigit(c) || c == '.') {
                StringBuilder num = new StringBuilder();
                while (i < len && (Character.isDigit(expresion.charAt(i)) || expresion.charAt(i) == '.')) {
                    num.append(expresion.charAt(i));
                    i++;
                }
                npostfija.append(num).append(' ');
                continue;
            }
            // Si es operador
            if (esOperador(c)) {
                if (c == '(') {
                    pila.push(c);
                } else if (c == ')') {
                    while (!pila.isEmpty() && pila.peek() != null && pila.peek() != '(') {
                        npostfija.append(pila.pop()).append(' ');
                    }
                    if (!pila.isEmpty() && pila.peek() != null && pila.peek() == '(') {
                        pila.pop(); // Quita el '('
                    }
                } else {
                    while (!pila.isEmpty() && pesoEnPila(pila.peek()) >= pesoEnExpresion(c)) {
                        npostfija.append(pila.pop()).append(' ');
                    }
                    pila.push(c);
                }
                i++;
                continue;
            }
            // Si no es operador ni número, ignorar
            i++;
        }
        while (!pila.isEmpty()) {
            char op = pila.pop();
            if (op != '(' && op != ')') {
                npostfija.append(op).append(' ');
            }
        }
        return npostfija.toString().trim();
    }

    private static boolean esOperador(char c) {
        return OPERADORES.indexOf(c) != -1;
    }

    private static int pesoEnExpresion(char op) {
        switch (op) {
            case '^': return 4;
            case '*':
            case '/': return 2;
            case '+':
            case '-': return 1;
            case '(': return 5;
            default: return 0;
        }
    }

    private static int pesoEnPila(char op) {
        switch (op) {
            case '^': return 3;
            case '*':
            case '/': return 2;
            case '+':
            case '-': return 1;
            case '(': return 0;
            default: return 0;
        }
    }
}
