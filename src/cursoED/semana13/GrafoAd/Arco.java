package cursoED.semana13.GrafoAd;

public class Arco {
    int destino;
    double peso;

    public Arco(int d) {
        destino = d;
    }

    public Arco(int d, double p) {
        this(d);
        peso = p;
    }

    public int getDestino() {
        return destino;
    }

    @Override
    public boolean equals(Object n) {
        if (this == n) return true;
        if (n == null || getClass() != n.getClass()) return false;
        Arco a = (Arco) n;
        return destino == a.destino;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(destino);
    }
}