package cursoED.semana03;

public class OrdenacionPorInsercion {

	
	public static void ordenarPorInsercion(int[] a) {
		int n = a.length;
		for (int i = 1; i < n; i++) {
			/*
			 * indice j es para explorar la sublista a[i-1]..a[0] buscando la posicion
			 * correcta del elemento destino
			 */
			int j = i;
			int aux = a[i];
			// se localiza el punto de inserción explorando hacia izquierda
			while (j > 0 && aux < a[j - 1]) {
				// desplazar elementos hacia derecha para hacer espacio
				a[j] = a[j - 1];
				j--;
			}
			a[j] = aux;
		}
	}
	private static void demo() {
		int[] a = { 8, 4, 6, 2 };
//		int[] a = { 8, 6, 4, 2 };
//		int[] a = { 2, 4, 6, 8 };
		ordenarPorInsercion(a); 
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
