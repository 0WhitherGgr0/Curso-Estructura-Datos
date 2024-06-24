package cursoED.semana13.GrafoAd;

import java.util.ArrayList;
import java.util.List;

public class VerticeAdy<T> {
    private String nombre;
    private int numVertice;
    private List<T> lad;

    public VerticeAdy(String x) {
        this.nombre = x;
        numVertice = -1;
        lad = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumVertice() {
        return numVertice;
    }

    public void setNumVertice(int numVertice) {
        this.numVertice = numVertice;
    }

    public List<T> getLad() {
        return lad;
    }
}
