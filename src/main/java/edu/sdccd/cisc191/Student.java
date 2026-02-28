package edu.sdccd.cisc191;
//
public class Student {
    private String name;
    private int id;
    private double gpa;

    public Student(String name, double gpa, int id) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Student name cannot be null or blank");
        }
        if (id <= 0) {
            throw new IllegalArgumentException("Student id cannot be negative");

        }
        if (gpa < 0.0 || gpa > 4.0) {
            throw new IllegalArgumentException("Student gpa cannot be negative");
        }
        this.name = name;
        this.id = id;
        this.gpa = gpa;
    }

    public String getName() { return name; }
    public double getGpa()  { return gpa;  }
    public int    getId()   { return id;   }

    public void setName(String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Student name cannot be null or blank");

        this.name = name;
    }

    public void setGpa(double gpa) {
        if (gpa < 0.0 || gpa > 4.0) throw new IllegalArgumentException("Student gpa cannot be negative");

        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return String.format("Student{id=%d, name='%s', gpa=%.2f}", id, name, gpa);
    }
}