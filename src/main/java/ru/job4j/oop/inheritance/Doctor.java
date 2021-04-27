package ru.job4j.oop.inheritance;

public class Doctor extends Profession {
    private int cured;

    public Doctor(String name, String surname, String education, String birthday, int cured) {
        super(name, surname, education, birthday);
        this.cured = cured;
    }

    public Diagnosis heal(Pacient pacient) {
        return new Diagnosis();
    }
}
