package edu.sdccd.cisc191;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
