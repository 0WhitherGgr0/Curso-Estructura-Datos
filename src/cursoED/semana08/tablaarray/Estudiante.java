package cursoED.semana08.tablaarray;

import java.util.Comparator;

import java.util.Objects;

public class Estudiante implements WithPriority {
    private String id;
    private String lastName;
    private String firstName;
    private float grade;
    private int priority;

    public Estudiante(String id, String lastName, String firstName, float grade, int priority) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.grade = grade;
        this.priority = priority;
    }

    @Override
    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estudiante that = (Estudiante) o;
        return Float.compare(that.grade, grade) == 0 &&
                priority == that.priority &&
                Objects.equals(id, that.id) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(firstName, that.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstName, grade, priority);
    }
}
