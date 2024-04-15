package cursoED.semana02.ejercicio;

import cursoED.util.MathUtil;

public class ArrayBiDimensional {
    private static void buscarDemo() {
        int[][] datos = {{10, 12, 14, 15},
                         {10, 13, 14},
                         {17, 10, 12, 10}};
        long veces = contarRepeticion(datos, 10);
        System.out.printf("10 se encuentra %d veces%n", veces);
        veces = contarNumerosPrimos(datos);
        System.out.printf("Hay %d numeros primos%n", veces);
    }

    public static long contarRepeticion(int[][] datos, int n) {
        long count = 0;
        for (int[] fila : datos) {
            for (int elemento : fila) {
                if (elemento == n) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int contarNumerosPrimos(int[][] datos) {
        int count = 0;
        for (int[] fila : datos) {
            for (int elemento : fila) {
                if (MathUtil.esPrimo(elemento)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        buscarDemo();
    }
}