package cursoED.semana02;

import java.util.Scanner;

public class FactorialSimple {
	public static long factorial(int n) {
		long result = 1;
		for(int i=1; i<=n; i++) {
			result *= i;
		}
		return result;
		}
		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Integrese un numero: ");
			int n = scanner.nextInt();
			long result = factorial(n);
			System.out.println("El factorial es " + result);
	}
}