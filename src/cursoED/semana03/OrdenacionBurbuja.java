package cursoED.semana03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrdenacionBurbuja {

    public static <T extends Comparable<T>> void burbuja(List<T> lista) {
        boolean interruptor = true;
        int pasada, j;
        int n = lista.size();
        // bucle externo controla la cantidad de pasadas
        for (pasada = 0; pasada < n - 1 && interruptor; pasada++) {
            interruptor = false;
            for (j = 0; j < n - pasada - 1; j++) {
                T elem = lista.get(j);
                if (elem.compareTo(lista.get(j + 1)) > 0) {
                    // elementos desordenados, se intercambian
                    interruptor = true;
                    intercambiar(lista, j, j + 1);
                }
            }
        }
    }

    private static <T> void intercambiar(List<T> a, int i, int j) {
        T aux = a.get(i);
        a.set(i, a.get(j));
        a.set(j, aux);
    }

    private static void demo() {
        int[] a = { 8, 4, 6, 2 };
//      int[] a = { 8, 6, 4, 2 };
//      int[] a = { 2, 4, 6, 8 };
        
     /*   
      * Otra Forma
      * List<Integer> lista = new ArrayList<>();
        lista.add(8);
        lista.add(4);
        lista.add(6);
        lista.add(2);
        burbuja(lista);
        imprimir(lista); */   
        
        /*
         * Otra Forma
		List<Integer> lista = Arrays.asList(8,4,6,2);
        */
        
        List<Racional> lista = Arrays.asList(new Racional(1,5), new Racional(3,5), new Racional (10,5));

        /* 
       *metodo1
       *ArrayList<Integer> integerArray = new ArrayList<>(a.length);
        
        for (int value : a) {
            integerArray.add(value);
        }
        
        burbuja(integerArray);
        imprimir(integerArray);
        
        */
        
    }

  /*  
   *metodo1
   * private static void imprimir(List<Integer> a) {
        for (int n : a) {
            System.out.print(n + " ");
        }
        System.out.println();
    }*/

    private static <T> void imprimir(List<T> a) {
        
        System.out.print(a);
    }
    
    public static void main(String[] args) {
        demo();

    }
}
