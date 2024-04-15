package cursoED.semana03;

class Racional implements Comparable<Racional> {
	private int numerador, denominador;

	public Racional() {
		numerador = 0;
		denominador = 1;
	}

	public Racional(int n, int d) {
		super();
		numerador = n;
		if (d == 0)
			throw new RuntimeException(" Denominador == 0");
		denominador = d;
	}

	@Override
	public int compareTo(Racional o) {
		double result = ((double) numerador / denominador - (double) o.numerador / o.denominador);
		if (result == 0)
			return 0;
		else if (result > 0)
			return 1;
		else
			return -1;

	}

	@Override
	public String toString() {
		return String.format("%d/%d", numerador, denominador);
	}
	
	
}