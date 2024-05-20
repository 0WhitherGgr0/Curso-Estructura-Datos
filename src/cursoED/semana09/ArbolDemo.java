package cursoED.semana09;

public class ArbolDemo {
	   Nodo<String> izdo, dcho, centro1, centro2, centro3;
	   ArbolBinario<String> arbol;

	    public ArbolDemo() {
	        izdo = new Nodo<>(null, "Maria", null);
	        dcho = new Nodo<>(null, "Rodrigo", null);
	        centro1 = new Nodo<>(izdo, "Esperanza", dcho);

	        izdo = new Nodo<>(null, "Anyora", null);
	        dcho = new Nodo<>(null, "Abel", null);
	        centro2 = new Nodo<>(izdo, "M Jesus", dcho);

	        centro3 = new Nodo<>(centro1, "Esperanza", centro2);

	        arbol = new ArbolBinario<>(centro3);
	    }

	
	
	public static void main(String[] args) {
		ArbolBinario<String> ab = construirArbol(); //devuelve un arbol que contienen los nodos de ejemplo: Maria, Rodrigo, Esperaza, etc.
		ab.preorden();
		System.out.println();
		ab.inorden();
		System.out.println();
		ab.postorden();
		System.out.println();
	}
	
    public static ArbolBinario<String> construirArbol() {
        ArbolDemo demo = new ArbolDemo();
        return demo.arbol;
    }
}
