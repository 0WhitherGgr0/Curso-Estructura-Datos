package cursoED.semana02;

import java.util.Arrays;

public class ArrayCopia {
	public static int[] arrayCopia(int[] origen) {
		int[] destino = new int[origen.length];
		for (int i = 0; i < origen.length; i++) {
			destino[i] = origen[i];
		}
		return destino;
	}
	public static void arrayCopia(int[] origen, int[] destino) {
		for (int i = 0; i < origen.length; i++) {
			destino[i] = origen[i];
		}
	}

	public static void demo0( ) {
		int[] a1 = {1,3,5,7,9};
		int[] a2;
		mostrar(a1);
		a2 = arrayCopia(a1);
		a1[0] = 10;
		mostrar(a1);
		mostrar(a2);
	}
	public static void demo1( ) {
		int[] a1 = {1,3,5,7,9};
		int[] a2 = new int[a1.length];
		mostrar(a1);
		arrayCopia(a1, a2);
		a1[0] = 10;
//		System.out.println(a1);
//		System.out.println(a2);
		mostrar(a1);
		mostrar(a2);
	}
	public static void demo2( ) {
		int[] a1 = {1,3,5,7,9};
		int[] a2 = new int[a1.length];
		mostrar(a1);
		System.arraycopy(a1, 0, a2, 0, a1.length);
		a1[0] = 10;
		mostrar(a1);
		mostrar(a2);
	}
	public static void demo3( ) {
		int[] a1 = {1,3,5,7,9};
		int[] a2;
		mostrar(a1);
		a2 = Arrays.copyOf(a1, a1.length);
		a1[0] = 10;
		mostrar(a1);
		mostrar(a2);
	}
	public static void demo4( ) {
		int[] a1 = {1,3,5,7,9};
		int[] a2;
		mostrar(a1);
		a2 = Arrays.copyOfRange(a1, 0, a1.length);
		a1[0] = 10;
		mostrar(a1);
		mostrar(a2);
	}


	private static void mostrar(int[] a) {
		for (int elem : a) {
			System.out.print(elem + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		demo1();
	}

}