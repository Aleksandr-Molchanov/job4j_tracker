package ru.job4j.oop.inheritance;

public class Builder extends Engineer {
    private boolean toolkit;

    public Builder(String name, String surname, String education, String birthday, int completed, boolean toolkit) {
        super(name, surname, education, birthday, completed);
        this.toolkit = toolkit;
    }

    public void build() {

    }
}
