package cursoED.semana02;

public class ArrayDemo {
	private void inicializacion() {
		int[] numeros = { 3, 4, 5 };
		numeros = new int[]{ 10, 11, 12, 13 };
		String s = "abc";
		s = "def";
	}

	private static void inicializa2() {
		float[] notas = new float[6];
		for (int i = 0; i < notas.length; i++) {
			notas[i] = (float) Math.random() * 20;
		}
		mostrarArray(notas);
	}

	private static void mostrarArray(float[] notas) {
		for (int i = 0; i < notas.length; i++) {
			System.out.print(notas[i] + " ");
		}
//		for (float n : notas) {
//			System.out.print(n + " ");
//		}
		System.out.println();
	}
	private static void mostrarArray(int[] a) {
		for (int n : a) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
	
	private static void losArraySonReferencias() {
		int[] a1 = {1,3,5,7,9};
		int[] a2 = a1;
		a2[0] = 2;
		mostrarArray(a1);
	}

	public static void main(String[] args) {
		inicializa2();

	}
}