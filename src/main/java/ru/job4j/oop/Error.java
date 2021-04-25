package ru.job4j.oop;

public class Error {
    boolean active;
    int status;
    String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printError() {
        System.out.println("Error active: " + active);
        System.out.println("Error status: " + status);
        System.out.println("Message: " + message);
    }

    public static void main(String[] args) {
        Error error1 = new Error();
        Error error404 = new Error(true, 404, "Error 404");
        Error error505 = new Error(false, 505, "Error 505");
        error1.printError();
        error404.printError();
        error505.printError();
    }
}
