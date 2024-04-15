package cursoED.semana02.ejercicio;


import cursoED.util.MathUtil;

public class ArrayUniDimensional {
	private static void buscarDemo() {
		int [] datos = {10, 12, 14, 15,
						10, 13, 14,
						17, 10, 12, 10};
		long veces = contarRepeticion(datos, 10);
		System.out.printf("10 se encuentra %d veces%n", veces);
		veces = contarNumerosPrimos(datos);
		System.out.printf("Hay %d numeros primos%n", veces);
	}
	
	public static long contarRepeticion(int[] datos, int n) {
		int cuenta=0;
		for (int i = 0; i < datos.length; i++) {
			if (datos[i] == n)
				cuenta++;
		}
		return cuenta;
	}

	public static long contarNumerosPrimos(int[] datos) {
		int cuenta=0;
		for (int i = 0; i < datos.length; i++) {
			if (MathUtil.esPrimo(datos[i]))
				cuenta++;
		}
		return cuenta;
	}

	public static void main(String[] args) {
		buscarDemo();
	}
}