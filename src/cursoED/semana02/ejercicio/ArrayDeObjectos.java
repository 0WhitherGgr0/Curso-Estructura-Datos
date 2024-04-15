package cursoED.semana02.ejercicio;

import cursoED.util.Complejo;

public class ArrayDeObjectos {
    private static void buscarDemo() {
        Complejo[] datos = {new Complejo(1, 2), new Complejo(5, 7), new Complejo(6, 3)};
        Complejo dato = new Complejo(1, 2);
        long veces = contarRepeticion(datos, dato);
        System.out.printf("%s se encuentra %d veces%n", dato, veces);
    }

    public static long contarRepeticion(Complejo[] datos, Complejo dato) {
        long count = 0;
        for (Complejo complejo : datos) {
            if (complejo.equals(dato)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        buscarDemo();
    }
}