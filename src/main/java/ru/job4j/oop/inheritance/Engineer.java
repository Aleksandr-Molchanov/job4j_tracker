package ru.job4j.oop.inheritance;

public class Engineer extends Profession {
    private int completed;

    public Engineer(String name, String surname, String education, String birthday, int completed) {
        super(name, surname, education, birthday);
        this.completed = completed;
    }

    public Work execution (Project project) {

    }
}
