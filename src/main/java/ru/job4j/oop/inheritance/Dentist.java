package ru.job4j.oop.inheritance;

public class Dentist extends Doctor {
    private int filling;

    public Dentist(String name, String surname, String education,
                   String birthday, int cured, int filling) {
        super(name, surname, education, birthday, cured);
        this.filling = filling;
    }

    public void drillBit() {

    }
}
