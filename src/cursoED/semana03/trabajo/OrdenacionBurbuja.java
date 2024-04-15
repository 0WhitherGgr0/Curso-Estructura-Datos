package cursoED.semana03.trabajo;

public class OrdenacionBurbuja {

    public static void burbuja(int[] a) {
        boolean interruptor = true;
        int n = a.length;
        // bucle externo controla la cantidad de pasadas
        for (int pasada = 0; pasada < n - 1 && interruptor; pasada++) {
            interruptor = false;
            for (int j = 0; j < n - pasada - 1; j++) {
                if (a[j] > a[j + 1]) {
                    // elementos desordenados, se intercambian
                    interruptor = true;
                    intercambiar(a, j, j + 1);
                }
            }
        }
    }

    private static void intercambiar(int[] a, int i, int j) {
        int aux = a[i];
        a[i] = a[j];
        a[j] = aux;
    }

    private static void demo() {
        int[] a = { 8, 4, 6, 2 };
        burbuja(a);
        imprimir(a);
    }

    private static void imprimir(int[] a) {
        for (int n : a) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        demo();
    }
}
