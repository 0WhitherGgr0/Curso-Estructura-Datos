package cursoED.semana13;

public class Main {
	public static void main(String[] args) {
		GrafoAdcia g = new GrafoAdcia();

		// Agregar vértices
		g.agregaVertice(1);
		g.agregaVertice(2);
		g.agregaVertice(3);

		// Agregar arcos
		g.agregaArco(1, 2);
		g.agregaArco(2, 3);
		g.agregaArco(3, 1);

		// Mostrar el grafo
		System.out.println("Grafo actual:");
		g.imprimirGrafo();

		System.out.println("¿1 y 2 son adyacentes? " + g.adyacente(1, 2));
		System.out.println("¿1 y 3 son adyacentes? " + g.adyacente(1, 3));

		g.borraVertice(2);

		// Mostrar el grafo después de borrar un vértice
		System.out.println("\nGrafo después de borrar el vértice 2:");
		g.imprimirGrafo();
		
		
		
		
		
	
	    GrafoMatrizAdyacencia gma = new GrafoMatrizAdyacencia(4); // Crear un grafo con 4 vértices

	    // Agregar vértices
	    gma.agregaVertice(0);
	    gma.agregaVertice(1);
	    gma.agregaVertice(2);
	    gma.agregaVertice(3);

	    // Agregar arcos
	    gma.agregaArco(0, 1);
	    gma.agregaArco(0, 3);
	    gma.agregaArco(1, 2);
	    gma.agregaArco(2, 3);

	    // Mostrar el grafo
	    System.out.println("Grafo actual:");
	    gma.imprimirGrafo();

	    // Verificar si dos vértices son adyacentes
	    System.out.println("¿1 y 2 son adyacentes? " +  gma.adyacente(1, 2));
	    System.out.println("¿0 y 3 son adyacentes? " +  gma.adyacente(0, 3));

	    // Borrar un vértice y sus arcos asociados
	    gma.borraVertice(2);

	    // Mostrar el grafo después de borrar un vértice
	    System.out.println("\nGrafo después de borrar el vértice 2:");
	    gma.imprimirGrafo();
		
	}
	
	

	
}
