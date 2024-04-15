package cursoED.semana03.trabajo;

import java.util.Arrays;
import java.util.Scanner;

import cursoED.semana03.OrdenacionPorInsercion;
import cursoED.semana03.OrdenacionPorIntercambio;
import cursoED.semana03.OrdenacionPorSeleccion;
import cursoED.semana03.OrdenacionRapida;



public class SortApp {

	private static int[] data;


	public static void main(String[] args) {
		String opcion="";
		String[] menu = {"1.-Generar datos",
						"2.-Ordenar Por Insercion",
						"3.-Ordenar por Intercambio",
						"4.-Ordenar por Seleccion",
						"5.-Quicksort",
						"q.-Salir"};
		do {
			mostrarMenu(menu);
			opcion = leerOpcion("Ingrese una opcion: ");
			procesar(opcion);
		} while (!opcion.equals("q"));

	}

	private static void procesar(String opcion) {
		switch (opcion) {
		case "1": 
			data = generarData();
			mostrarArray(data);
			break;
		case "2":
		case "3":
		case "4":
		case "5":
			ordenar(data, opcion);
			break;
		case "q":
			break;
		default:
			System.out.println("Opcion ingresada no es correcta");
			break;
		}
		
	}

    private static void ordenar(int[] data, String opcion) {
        int[] input = Arrays.copyOf(data, data.length);
        long inicio = System.nanoTime();
        switch (opcion) {
            case "2":
                OrdenacionPorInsercion.ordenarPorInsercion(input);
                break;
            case "3":
                OrdenacionPorIntercambio.ordenarPorIntercambio(input);
                break;
            case "4":
                OrdenacionPorSeleccion.ordenarPorSeleccion(input);
                break;
            case "5":
                OrdenacionRapida.quickSort(input);
                break;
        }
        long fin = System.nanoTime();
        long tiempoTranscurrido = fin - inicio;
        mostrarArray(input);
        System.out.println("Tiempo transcurrido: " + tiempoTranscurrido + " nanosegundos");
    }
    
    
	private static void mostrarArray(int[] input) {
		for (int elem : input) {
			System.out.print(elem + " ");
		}
		System.out.println();
	}

	private static int[] generarData() {
		System.out.println("Ingrese la cantidad de data a generar:");
		Scanner scan = new Scanner(System.in);
		int cantidad = scan.nextInt();
		int[] data = new int[cantidad];
		for (int i=0; i< cantidad; i++) {
			data[i] = (int)(Math.random() * cantidad);
		}
		return data;
	}

	private static String leerOpcion(String prompt) {
		System.out.print(prompt);
		Scanner scan = new Scanner(System.in);
		String opcion = scan.next();
		return opcion;
	}

	private static void mostrarMenu(String[] menu) {
		for (String m : menu) {
			System.out.println(m);
		}
	}

}
