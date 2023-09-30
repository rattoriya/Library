package by.bsuir.ratkevich.library;

import by.bsuir.ratkevich.library.user.User;
import by.bsuir.ratkevich.library.authorization.Authorization;
import by.bsuir.ratkevich.library.console.Console;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        User user;

        int choice;

        do {
            System.out.println(
                    "1 - Войти\n"
                    + "2 - Зарегистрироваться");

            while (!scanner.hasNextInt()) {
                scanner.next();
            }

            choice = scanner.nextInt();

        } while (choice != 1 && choice != 2);

        Authorization authorization = new Authorization();
        Console console = new Console();

        switch (choice) {

            case 1:

                user = authorization.logIn();
                console.getConsole(user);

                break;

            case 2:

                user = authorization.signUp();
                console.getConsole(user);

                break;

            default:

                System.out.println("Что-то пошло не так");
                System.exit(0);

                break;
        }

    }

}
