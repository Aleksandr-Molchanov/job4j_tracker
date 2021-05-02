package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Автобус едет.");
    }

    @Override
    public void passengers(int number) {
        System.out.println("В автобусе  " + (40 - number) + " свободных мест.");
    }

    @Override
    public double fillUp(double liter) {
        return liter * 43.50;
    }
}
