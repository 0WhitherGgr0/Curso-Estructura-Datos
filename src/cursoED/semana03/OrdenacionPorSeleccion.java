package cursoED.semana03;

public class OrdenacionPorSeleccion {

	public static void ordenarPorSeleccion(int[] a) {
		int n = a.length;
		for (int i = 0; i < n - 1; i++) {
			int indiceMenor = i;
			for (int j = i + 1; j < n; j++) {
				if (a[indiceMenor] > a[j]) {
					indiceMenor = j;
				}
			}
			if (i != indiceMenor)
				intercambiar(a, indiceMenor, i);

		}
	}

	private static void intercambiar(int[] a, int i, int j) {
		int aux = a[i];
		a[i] = a[j];
		a[j] = aux;
	}
	
	private static void demo() {
		int[] a = { 8, 4, 6, 2 };
//		int[] a = { 8, 6, 4, 2 };
//		int[] a = { 2, 4, 6, 8 };
		ordenarPorSeleccion(a); 
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
