package cursoED.semana03;

public class BusquedaBinaria {
	
	public static int busquedaBinaria(int a[], int clave) {
		int central, bajo, alto;
		int valorCentral;
		bajo = 0;
		alto = a.length - 1;
		while (bajo <= alto) {
			central = (bajo + alto) / 2; // índice de elemento central
			valorCentral = a[central]; // valor del índice central
			if (clave == valorCentral)
				return central; // encontrado, devuelve posición
			else if (clave < valorCentral)
				alto = central - 1; // ir a sublista inferior
			else
				bajo = central + 1; // ir a sublista superior

		}
		return -1; // elemento no encontrado
	}
	private static void demo() {
		int[] a = { 8, 4, 6, 2 };
//		int[] a = { 8, 6, 4, 2 };
//		int[] a = { 2, 4, 6, 8 };
		int clave = 6;
		int posicion = busquedaBinaria(a, clave);
		if (posicion != -1) {
			System.out.println("La clave " + clave + " fue encontrada en la posición " + posicion);
		} else {
			System.out.println("La clave " + clave + " no fue encontrada en el array.");
		}
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
