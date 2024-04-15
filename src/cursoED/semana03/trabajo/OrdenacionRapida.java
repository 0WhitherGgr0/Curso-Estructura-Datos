package cursoED.semana03.trabajo;

import java.util.Arrays;
import java.util.List;

public class OrdenacionRapida {

    public static <T extends Comparable<T>> void quickSort(List<T> lista) {
        quickSort(lista, 0, lista.size() - 1);
    }

    private static <T extends Comparable<T>> void quickSort(List<T> lista, int primero, int ultimo) {
        int i, j;
        T pivote;
        i = primero;
        j = ultimo;
        pivote = lista.get((primero + ultimo) / 2);
        do {
            while (lista.get(i).compareTo(pivote) < 0)
                i++;
            while (lista.get(j).compareTo(pivote) > 0)
                j--;
            if (i <= j) {
                intercambiar(lista, i, j);
                i++;
                j--;
            }
        } while (i <= j);
        if (primero < j)
            quickSort(lista, primero, j); // mismo proceso con sublista izqda
        if (i < ultimo)
            quickSort(lista, i, ultimo); // mismo proceso con sublista drcha

    }

    private static <T> void intercambiar(List<T> lista, int i, int j) {
        T temp = lista.get(i);
        lista.set(i, lista.get(j));
        lista.set(j, temp);
    }

    private static void demo() {
        List<Integer> lista = Arrays.asList(8, 4, 6, 2);
        System.out.println("Lista original: " + lista);
        
        // Ordenar la lista utilizando quickSort
        OrdenacionRapida.quickSort(lista);
        
        System.out.println("Lista ordenada: " + lista);
    }


    public static void main(String[] args) {
        demo();
    }

}
