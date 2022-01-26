package com.example.sqldatabase;

public class Student {
    private String studentName;
    private String studentUsn;
    private int studentMarks;
    private int studentSem;

    public Student() {}

    public Student(String name, String usn, int sem, int marks) {
        this.studentName = name;
        this.studentUsn = usn;
        this.studentSem = sem;
        this.studentMarks = marks;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentUsn() {
        return studentUsn;
    }

    public int getStudentSem() {
        return studentSem;
    }

    public int getStudentMarks() {
        return studentMarks;
    }
}
