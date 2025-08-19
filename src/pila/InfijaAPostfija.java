package pila;

public class InfijaAPostfija {
    private static final String OPERADORES = "^*/+-()";

    public static String convertir(String expresion) throws Exception {
        StringBuilder npostfija = new StringBuilder();
        Stack<Character> pila = new Stack<Character>();

        int len = expresion.length();
        for (int i = 0; i < len; ) {
            char c = expresion.charAt(i);
            if (Character.isWhitespace(c)) {
                i++;
                continue;
            }

            // Leer número entero o flotante completo
            if (Character.isDigit(c) || c == '.') {
                StringBuilder num = new StringBuilder();
                while (i < len && (Character.isDigit(expresion.charAt(i)) || expresion.charAt(i) == '.')) {
                    num.append(expresion.charAt(i));
                    i++;
                }
                npostfija.append(num).append(' ');
                System.out.println("1) VARIABLE (npostfija): " + npostfija);

                continue;
            }

            // Si es operador
            if (esOperador(c)) {
                if (c == '(') {
                    pila.push(c);
                    System.out.println("1) PUSH: " + c);

                } else if (c == ')') {
                    while (!pila.isEmpty() && pila.peek() != '(') {
                        System.out.println("1) POP: " + pila.peek());
                        npostfija.append(pila.pop()).append(' ');
                        System.out.println("2) VARIABLE (npostfija): " + npostfija);
                    }
                    if (!pila.isEmpty() && pila.peek() == '(') {
                        pila.pop(); // Quita el '('
                        System.out.println("2) POP: " + c);
                    }
                } else {
                    while (!pila.isEmpty() && pesoEnPila(pila.peek()) >= pesoEnExpresion(c)) {
                        System.out.println("3) POP: " + pila.peek());
                        npostfija.append(pila.pop()).append(' ');
                        System.out.println("3) VARIABLE (npostfija): " + npostfija);
                    }
                    pila.push(c);
                    System.out.println("2) PUSH: " + c);
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
                System.out.println("4) VARIABLE (npostfija): " + npostfija);
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
