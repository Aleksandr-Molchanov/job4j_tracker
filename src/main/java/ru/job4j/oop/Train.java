package ru.job4j.oop;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " передвигается по рельсам.");
    }

    @Override
    public void fillUp() {
        System.out.println(getClass().getSimpleName() + " заправляют дизельным топливом.");
    }
}
