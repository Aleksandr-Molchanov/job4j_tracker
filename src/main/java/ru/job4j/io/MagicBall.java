package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        System.out.println("Я великий Оракул. Что ты хочешь узнать? ");
        Scanner in = new Scanner(System.in);
        String question = in.nextLine();
        int answer = new Random().nextInt(3);
        switch (answer) {
            case (0):
                System.out.println("Да");
                break;
            case (1):
                System.out.println("Нет");
                break;
            default:
                System.out.println("Может быть");
                break;
        }
    }
}
