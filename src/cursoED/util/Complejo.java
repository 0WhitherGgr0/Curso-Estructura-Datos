package cursoED.util;

import java.util.Objects;

public class Complejo {
	private double real;
	private double imaginaria;

	public Complejo(double real, double imaginaria) {
		this.real = real;
		this.imaginaria = imaginaria;
	}

	public double getReal() {
		return real;
	}

	public void setReal(double real) {
		this.real = real;
	}

	public double getImaginaria() {
		return imaginaria;
	}

	public void setImaginaria(double imaginaria) {
		this.imaginaria = imaginaria;
	}

	@Override
	public String toString() {
		return String.format("%.2f%+.2fi", real, imaginaria);
	}

	@Override
	public int hashCode() {
		return Objects.hash(imaginaria, real);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Complejo other = (Complejo) obj;
//https://www.baeldung.com/java-comparing-doubles
		double epsilon = 0.000001d;
		return Math.abs(real - other.real) < epsilon && Math.abs(imaginaria - other.imaginaria) < epsilon;
//return imaginaria == other.imaginaria && real == other.real;
	}
}