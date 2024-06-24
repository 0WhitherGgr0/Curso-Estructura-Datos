package cursoED.semana13.GrafoAd;

import java.util.Iterator;
import java.util.List;

public class ListaIterador {
	  private Iterator<Arco> iterator;

	    public ListaIterador(List<Arco> listaAdy) {
	        this.iterator = listaAdy.iterator();
	    }

	    public Arco siguiente() {
	        if (iterator.hasNext()) {
	            return iterator.next();
	        }
	        return null;
	    }
}
