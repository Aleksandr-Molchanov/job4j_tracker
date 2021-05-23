package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Alexander Molchanov");
        student.setGroup("#1");
        student.setDate("1.1.2021");
        System.out.println("Student " + student.getName()
                + " joined the group " + student.getGroup()
                + " " + student.getDate());
    }
}
