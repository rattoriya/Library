package by.bsuir.ratkevich.library.authorization;

import by.bsuir.ratkevich.library.user.User;
import by.bsuir.ratkevich.library.user.UserHandler;

import java.util.Scanner;

public class Authorization {

    private UserHandler userHandler = new UserHandler ();

    public User logIn () {

        Scanner in = new Scanner (System.in);

        String userName;
        String password;
        boolean isAdmin;

        while (true) {

            System.out.println("Введите логин/имя пользователя:");
            userName = in.nextLine();

            System.out.println("Введите пароль:");
            password = in.nextLine();


            int choice;

            while (true) {


                System.out.println("Являетесь ли вы администратором (1-да, 2-нет):");
                choice = in.nextInt();

                switch (choice) {

                    case 1:
                        isAdmin = true;
                        break;

                    case 2:
                        isAdmin = false;
                        break;

                    default:
                        continue;
                }

                break;
            }

            User user = userHandler.isLoginCorrect (userName, password, isAdmin);

            if (user!= null) {

                return user;

            }
            else {

                System.out.println ("Неверно введенная комбинация логина/пароля");
                in.nextLine();
            }

        }

    }

    public User signUp () {

        Scanner in = new Scanner (System.in);

        String userName;
        String password;
        boolean isAdmin;

        while (true) {

            System.out.println("Введите логин/имя пользователя:");
            userName = in.nextLine();

            System.out.println("Введите пароль:");
            password = in.nextLine();


            int choice;

            while (true) {


                System.out.println("Являетесь ли вы администратором (1-да, 2-нет):");
                choice = in.nextInt();

                switch (choice) {

                    case 1:
                        isAdmin = true;
                        break;

                    case 2:
                        isAdmin = false;
                        break;

                    default:
                        continue;
                }

                break;
            }

            if (userHandler.addUser(userName, password, isAdmin)) {

                return new User (userName, password.hashCode(), isAdmin);
            }

            else {

                System.out.println ("Логин/имя пользователя уже занято");
                in.nextLine();

            }

        }

    }

}
