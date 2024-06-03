package cursoED.semana10;


public class ArbolAvl<T> {
	NodoAvl<T> raiz;

	public ArbolAvl() {
		raiz = null;
	}

	public NodoAvl<T> getRaiz() {
		return raiz;
	}

	private NodoAvl<T> rotacionII(NodoAvl<T> n, NodoAvl<T> n1) {
		n.setIzdo(n1.getDcho());
		n1.setDcho(n);
		// actualización de los factores de equilibrio
		if (n1.fe == -1) // se cumple en la inserción
		{
			n.fe = 0;
			n1.fe = 0;
		} else {
			n.fe = -1;
			n1.fe = 1;
		}
		return n1;
	}

	private NodoAvl<T> rotacionDD(NodoAvl<T> n, NodoAvl<T> n1) {
		n.setDcho(n1.getIzdo());
		n1.setIzdo(n);
		// actualización de los factores de equilibrio
		if (n1.fe == +1) // se cumple en la inserción
		{
			n.fe = 0;
			n1.fe = 0;
		} else {
			n.fe = +1;
			n1.fe = -1;
		}
		return n1;
	}

	private NodoAvl<T> rotacionID(NodoAvl<T> n, NodoAvl<T> n1) {
		NodoAvl<T> n2;
		n2 = (NodoAvl<T>) n1.getDcho();
		n.setIzdo(n2.getDcho());
		n2.setDcho(n);
		n1.setDcho(n2.getIzdo());
		n2.setIzdo(n1);
		// actualización de los factores de equilibrio
		if (n2.fe == +1)
			n1.fe = -1;
		else
			n1.fe = 0;
		if (n2.fe == -1)
			n.fe = 1;
		else
			n.fe = 0;
		n2.fe = 0;
		return n2;
	}

	private NodoAvl<T> rotacionDI(NodoAvl<T> n, NodoAvl<T> n1) {
		NodoAvl<T> n2;
		n2 = (NodoAvl<T>) n1.getIzdo();
		n.setDcho(n2.getIzdo());
		n2.setIzdo(n);
		n1.setIzdo(n2.getDcho());
		n2.setDcho(n1);
		// actualización de los factores de equilibrio
		if (n2.fe == +1)
			n.fe = -1;
		else
			n.fe = 0;
		if (n2.fe == -1)
			n1.fe = 1;
		else
			n1.fe = 0;
		n2.fe = 0;
		return n2;
	}

	public void insertar(T dato) {
		Logical h = new Logical(false); // intercambia un valor booleano
		raiz = insertarAvl(raiz, dato, h);
	}

	private NodoAvl<T> insertarAvl(NodoAvl<T> raiz, T dato, Logical h) {
		NodoAvl<T> n1;
		if (raiz == null) {
			raiz = new NodoAvl<>(null, dato, null);
			h.setLogical(true);
		} else {
			int comparacion = ((Comparable<T>) dato).compareTo(raiz.getDato());
			if (comparacion < 0) {
				NodoAvl iz;
				iz = insertarAvl((NodoAvl) raiz.getIzdo(), dato, h);
				raiz.setIzdo(iz);
				// regreso por los nodos del camino de búsqueda
				if (h.booleanValue()) {
					// decrementa el fe por aumentar la altura de rama izquierda
					switch (raiz.fe) {
					case 1:
						raiz.fe = 0;
						h.setLogical(false);
						break;
					case 0:
						raiz.fe = -1;
						break;
					case -1: // aplicar rotación a la izquierda
						n1 = (NodoAvl<T>) raiz.getIzdo();
						if (n1.fe == -1)
							raiz = rotacionII(raiz, n1);
						else
							raiz = rotacionID(raiz, n1);
						h.setLogical(false);
					}
				}
			} else if (comparacion > 0) {
				NodoAvl<T> dr;
				dr = insertarAvl((NodoAvl<T>) raiz.getDcho(), dato, h);
				raiz.setDcho(dr);
				// regreso por los nodos del camino de búsqueda
				if (h.booleanValue()) {
					// incrementa el fe por aumentar la altura de rama izquierda
					switch (raiz.fe) {
					case 1: // aplicar rotación a la derecha
						n1 = (NodoAvl<T>) raiz.getDcho();
						if (n1.fe == +1)
							raiz = rotacionDD(raiz, n1);
						else
							raiz = rotacionDI(raiz, n1);
						h.setLogical(false);
						break;
					case 0:
						raiz.fe = +1;
						break;
					case -1:
						raiz.fe = 0;
						h.setLogical(false);
					}
				}
			} else
				throw new RuntimeException("No puede haber claves repetidas ");

		}
		return raiz;
	}
	public void eliminar(T valor) throws Exception {
	    Logical flag = new Logical(false);
	    raiz = borrarAvl(raiz, valor, flag);
	}

	private NodoAvl<T> borrarAvl(NodoAvl<T> r, T clave, Logical cambiaAltura) throws Exception {
	    if (r == null) {
	        throw new Exception("Nodo no encontrado");
	    } else if (((Comparable<T>) clave).compareTo(r.getDato()) < 0) {
	        NodoAvl<T> iz = borrarAvl((NodoAvl<T>)r.getIzdo(), clave, cambiaAltura);
	        r.setIzdo(iz);
	        if (cambiaAltura.booleanValue()) {
	            r = equilibrar1(r, cambiaAltura);
	        }
	    } else if (((Comparable<T>) clave).compareTo(r.getDato()) > 0) {
	        NodoAvl<T> dr = borrarAvl((NodoAvl<T>)r.getDcho(), clave, cambiaAltura);
	        r.setDcho(dr);
	        if (cambiaAltura.booleanValue()) {
	            r = equilibrar2(r, cambiaAltura);
	        }
	    } else { // Nodo encontrado
	        NodoAvl<T> q = r; // nodo a quitar del árbol
	        if (q.getIzdo() == null) {
	            r = (NodoAvl<T>) q.getDcho();
	            cambiaAltura.setLogical(true);
	        } else if (q.getDcho() == null) {
	            r = (NodoAvl<T>) q.getIzdo();
	            cambiaAltura.setLogical(true);
	        } else { // tiene rama izquierda y derecha
	            NodoAvl<T> iz = reemplazar(r, (NodoAvl<T>) r.getIzdo(), cambiaAltura);
	            r.setIzdo(iz);
	            if (cambiaAltura.booleanValue()) {
	                r = equilibrar1(r, cambiaAltura);
	            }
	        }
	        q = null;
	    }
	    return r;
	}

	private NodoAvl<T> reemplazar(NodoAvl<T> n, NodoAvl<T> act, Logical cambiaAltura) {
	    if (act.getDcho() != null) {
	        NodoAvl<T> d = reemplazar(n, (NodoAvl<T>) act.getDcho(), cambiaAltura);
	        act.setDcho(d);
	        if (cambiaAltura.booleanValue()) {
	            act = equilibrar2(act, cambiaAltura);
	        }
	    } else {
	        n.setDato(act.getDato());
	        n = act;
	        act = (NodoAvl<T>) act.getIzdo();
	        n = null;
	        cambiaAltura.setLogical(true);
	    }
	    return act;
	}

	private NodoAvl<T> equilibrar1(NodoAvl<T> n, Logical cambiaAltura) {
	    NodoAvl<T> n1;
	    switch (n.fe) {
	        case -1:
	            n.fe = 0;
	            break;
	        case 0:
	            n.fe = 1;
	            cambiaAltura.setLogical(false);
	            break;
	        case +1:
	            n1 =(NodoAvl<T>) n.getDcho();
	            if (n1.fe >= 0) {
	                if (n1.fe == 0)
	                    cambiaAltura.setLogical(false);
	                n = rotacionDD(n, n1);
	            } else
	                n = rotacionDI(n, n1);
	            break;
	    }
	    return n;
	}

	private NodoAvl<T> equilibrar2(NodoAvl<T> n, Logical cambiaAltura) {
	    NodoAvl<T> n1;
	    switch (n.fe) {
	        case -1:
	            n1 = (NodoAvl<T>) n.getIzdo();
	            if (n1.fe <= 0) {
	                if (n1.fe == 0)
	                    cambiaAltura.setLogical(false);
	                n = rotacionII(n, n1);
	            } else
	                n = rotacionID(n, n1);
	            break;
	        case 0:
	            n.fe = -1;
	            cambiaAltura.setLogical(false);
	            break;
	        case +1:
	            n.fe = 0;
	            break;
	    }
	    return n;
	}
}
