package ru.job4j.oop;

public class PolyUsage {
    public static void main(String[] args) {
        Vehicle plane1 = new Plane();
        Vehicle plane2 = new Plane();
        Vehicle train1 = new Train();
        Vehicle train2 = new Train();
        Vehicle bus1 = new Bus();
        Vehicle bus2 = new Bus();

        Vehicle[] vehicles = new Vehicle[]{plane1, plane2, train1, train2, bus1, bus2};
        for (Vehicle veh : vehicles) {
            veh.move();
            veh.fillUp();
        }
    }
}