package cursoED.semana03;

public class BusquedaSecuencial {

	
	public static int buscaSecuencial(int[] a, int clave) {
		int pos=-1;
		for(int i=0;a.length>i; i++) {
			if(a[i]==clave) {
				 pos=i;
                 break; // Se encontró la clave, se interrumpe el bucle
			}			
		}				
		return pos;
	}
	
	private static void demo() {
		int[] a = { 8, 4, 6, 2 };
//		int[] a = { 8, 6, 4, 2 };
//		int[] a = { 2, 4, 6, 8 };
        int clave = 5;
        int posicion = buscaSecuencial(a, clave);
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
