package src.pila;

public class EvaluarPostfija {

    public static double evaluar(String postfija) throws Exception {
        Stack<Double> pila = new Stack<>();
        String[] tokens = postfija.split("\\s+");

        for (String token : tokens) {
            System.out.println(token);

            if (esNumero(token)) {
                pila.push(Double.parseDouble(token));
            } else if (esOperador(token)) {
                double operando2 = pila.pop();
                double operando1 = pila.pop();
                double resultado = operar(operando1, operando2, token.charAt(0));
                pila.push(resultado);
            }
        }
        return pila.pop();
    }

    private static boolean esNumero(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private static boolean esOperador(String token) {
        return token.length() == 1 && "^*/+-".contains(token);
    }

    private static double operar(double op1, double op2, char operador) {
        switch (operador) {
            case '+': return op1 + op2;
            case '-': return op1 - op2;
            case '*': return op1 * op2;
            case '/': return op1 / op2;
            case '^': return Math.pow(op1, op2);
            default: throw new IllegalArgumentException("Operador inválido: " + operador);
        }
    }
}
