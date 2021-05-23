package ru.job4j.oop.inheritance;

public class Surgeon extends Doctor {
    private String operations;

    public Surgeon(String name, String surname, String education,
                   String birthday, int cured, String operations) {
        super(name, surname, education, birthday, cured);
        this.operations = operations;
    }

    public void scalpel() {

    }
}
