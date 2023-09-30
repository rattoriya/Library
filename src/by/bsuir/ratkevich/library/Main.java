package by.bsuir.ratkevich.library;

import by.bsuir.ratkevich.library.user.User;
import by.bsuir.ratkevich.library.authorization.Authorization;
import by.bsuir.ratkevich.library.console.Console;

import java.util.Scanner;

/*
Задание 1: создать консольное приложение “Учет книг в домашней библиотеке”.
Общие требования к заданию:
• Система учитывает книги как в электронном, так и в бумажном варианте.
• Существующие роли: пользователь, администратор.
• Пользователь может просматривать книги в каталоге книг, осуществлять поиск
книг в каталоге.
• Администратор может модифицировать каталог.
• *При добавлении описания книги в каталог оповещение о ней рассылается на
e-mail всем пользователям
• **При просмотре каталога желательно реализовать постраничный просмотр
• ***Пользователь может предложить добавить книгу в библиотеку, переслав её
администратору на e-mail.
• Каталог книг хранится в текстовом файле.
• Данные аутентификации пользователей хранятся в текстовом файле. Пароль
не хранится в открытом виде
 */

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
