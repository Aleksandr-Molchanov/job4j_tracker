package ru.job4j.oop.inheritance;

public class Programmer extends Engineer {
    private String lang;

    public Programmer(String name, String surname, String education, String birthday, int completed, String lang) {
        super(name, surname, education, birthday, completed);
        this.lang = lang;
    }

    public void coding() {

    }
}
