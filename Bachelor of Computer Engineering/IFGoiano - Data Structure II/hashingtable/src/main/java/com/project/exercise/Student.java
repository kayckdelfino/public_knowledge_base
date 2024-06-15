package com.project.exercise;

import java.util.Objects;

public class Student implements Comparable<Student> {
    private int code;
    private String name;
    private double finalGrade;

    public Student(int code, String name, double finalGrade) {
        this.code = code;
        this.name = name;
        this.finalGrade = finalGrade;
    }

    public int getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public double getFinalGrade() {
        return this.finalGrade;
    }

    @Override
    public int compareTo(Student o) {
        if (this.code < o.code) {
            return -1;
        }
        if (this.code > o.code) {
            return 1;
        }
        return 0;
    }

    @Override
    public int hashCode() {
        return this.code;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Student student = (Student) obj;
        
        return this.code == student.code && Double.compare(this.finalGrade, student.finalGrade) == 0 && Objects.equals(this.name, student.name);
    }

    @Override
    public String toString() {
        return String.format("Student(code: %d, name: %s, finalGrade: %.1f)", code, name, finalGrade);
    }
}