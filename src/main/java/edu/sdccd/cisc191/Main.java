package edu.sdccd.cisc191;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Student {
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

@FunctionalInterface
interface StudentFilter{
    boolean test(Student student);
}

class StudentAnalyzer {

    public static List<Student> filter(List<Student> students, StudentFilter filter) {
        List<Student> result = new ArrayList<>();
        for (Student s : students) {
            if (filter.test(s)) result.add(s);
        }

        return result;
    }
    public static List<Student> sort(List<Student> students, Comparator<Student> comparator) {
        List<Student> sorted = new ArrayList<>(students);
        sorted.sort(comparator);

        return sorted;
    }

    public static double averageGpa(List<Student> students) {
        if (students.isEmpty()) return 0.0;
        double total = 0.0;
        for (Student s : students) total += s.getGpa();

        return total / students.size();
    }

}



public class Main {
    public static void main(String[] args) {

        // TODO create students
        List<Student> students = Arrays.asList(
                new Student("Abe", 3.9, 1001),
                new Student("Andre",   3.9, 1002),
                new Student("Jace", 3.7, 1003),
                new Student("Justin", 2.1, 1004),
                new Student("Collin",   3.8, 1005),
                new Student("Chris", 4.0, 1006)
        );
        // TODO demonstrate filtering
        System.out.println("Students with GPA >= 3.0");
        List<Student> filtered = StudentAnalyzer.filter(students, s -> s.getGpa() >= 3.0);
        for (Student s : filtered) {
            System.out.println(s);
        }

        // TODO demonstrate sorting
        System.out.println("\nStudents sorted by name");
        List<Student> byName = StudentAnalyzer.sort(students, Comparator.comparing(Student::getName));
        for (Student s : byName) {
            System.out.println(s);
        }

        System.out.println("\nStudents sorted by GPA (highest first)");
        List<Student> byGpa = StudentAnalyzer.sort(students, (a, b) -> Double.compare(b.getGpa(), a.getGpa()));
        for (Student s : byGpa) {
            System.out.println(s);
        }

        // TODO print average GPA
        System.out.printf("\nAverage GPA: " + StudentAnalyzer.averageGpa(students));

    }
}