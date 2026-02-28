package edu.sdccd.cisc191;

@FunctionalInterface
public interface StudentFilter{
    boolean test(Student student);
}
