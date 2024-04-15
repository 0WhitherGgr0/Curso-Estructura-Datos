package cursoED.util;

public class MathUtil {
	public static boolean esPrimo(int numero) {
		boolean es = true;
		for (int i = 2; i < numero; i++) {
			if (numero % i == 0) {
				es = false;
				break;
			}
		}
		return es;
	}
}