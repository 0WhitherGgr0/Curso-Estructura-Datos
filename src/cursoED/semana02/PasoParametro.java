package cursoED.semana02;

import java.util.Arrays;

import cursoED.util.Complejo;

public class PasoParametro {
	
	private static void pasoPorValorPrimitivo() {
		int n = 10;
		modificarValorPrimitivo(n);
		System.out.println(n);
	}
	private static void modificarValorPrimitivo(int n) {
		n++;
	}
	private static void pasoPorValorReferencia1() {

		Complejo c = new Complejo(1, 2.5);
		modificarValorReferencia(c);
		System.out.println(c);
	}
	private static void modificarValorReferencia(Complejo c) {
		c = new Complejo(3, 4);
	}

	private static void pasoPorValorReferencia2() {
		Complejo c = new Complejo(1, 2);
		modificarContenido(c);
		System.out.println(c);
	}
	
	private static void modificarContenido(Complejo c) {
		c.setReal(3);
		c.setImaginaria(4);
	}
	
	private static void arrayComoParametro() {
		char[] cad = {'J', 'a', 'v', 'a'};
		cambiarAMayuscula(cad);
		imprimir(cad);
	}
	
	private static void cambiarAMayuscula(char[] cad) {
//		cad = new char[cad.length];
//		cad = Arrays.copyOf(cad, cad.length);
		for (int i = 0; i < cad.length; i++) {
			cad[i] = Character.toUpperCase(cad[i]);
		}
	}

	private static void imprimir(char[] cad) {
		for (int i = 0; i < cad.length; i++) {
			System.out.print(cad[i]);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		pasoPorValorReferencia1();
//		pasoPorValorReferencia2();
//		arrayComoParametro();
	}

}