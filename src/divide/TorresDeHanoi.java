package src.divide;

//import java.util.Stack;
import java.util.Stack;

public class TorresDeHanoi {
    private Stack<Integer>[] torres;
    private int numDiscos;

    @SuppressWarnings("unchecked")
    public TorresDeHanoi(int numDiscos) {
        this.numDiscos = numDiscos;
        torres = new Stack[3];
        for (int i = 0; i < 3; i++) {
            torres[i] = new Stack<>();
        }
        for (int i = numDiscos; i >= 1; i--) {
            torres[0].push(i);
        }
    }

    public void resolver() {
        moverDiscos(numDiscos, 0, 2, 1);
    }

    private void moverDiscos(int n, int origen, int destino, int auxiliar) {
        if (n > 0) {
            moverDiscos(n - 1, origen, auxiliar, destino);
            int disco = torres[origen].pop();
            torres[destino].push(disco);
            mostrarTorres("Mover disco " + disco + " de Torre " + (origen+1) + " a Torre " + (destino+1));
            moverDiscos(n - 1, auxiliar, destino, origen);
        }
    }

    public void mostrarTorres(String mensaje) {
        System.out.println(mensaje);
        for (int i = 0; i < 3; i++) {
            System.out.print("Torre " + (i+1) + ": ");
            System.out.println(torres[i]);
        }
        System.out.println();
    }
}
