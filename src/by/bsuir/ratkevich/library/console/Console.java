package by.bsuir.ratkevich.library.console;

import by.bsuir.ratkevich.library.user.User;
import by.bsuir.ratkevich.library.catalog.Catalog;
import by.bsuir.ratkevich.library.book.Book;
import by.bsuir.ratkevich.library.book.BookType;
import by.bsuir.ratkevich.library.email.EmailHandler;
import by.bsuir.ratkevich.library.email.Email;

import java.util.Scanner;
import java.util.ArrayList;

import static by.bsuir.ratkevich.library.book.BookType.ELECTRONICBOOK;


public class Console {

    private Catalog catalog;
    private EmailHandler emailHandler;

    public Console () {

        catalog = new Catalog();
        emailHandler = new EmailHandler ();
    }

    public void getConsole(User user) {

        if (user.getIsAdmin()) {

            getAdminConsole(user);

        } else {

            getUserConsole(user);
        }
    }

    private void getUserConsole(User user) {

        Scanner scanner = new Scanner (System.in);

        int choice;

        while (true) {

            do {
                System.out.println(
                        "1 - Просмотреть книги в каталоге\n" +
                        "2 - Поиск книги в каталоге\n" +
                        "3 - Предложить добавить книгу\n" +
                        "0 - Выход из библиотеки");

                while (!scanner.hasNextInt()) {
                    scanner.nextLine();
                }

                choice = scanner.nextInt();

                scanner.nextLine();

            } while (choice < 0 || choice > 3);

            switch (choice) {

                case 1:

                    ArrayList <Book> books = catalog.getBooks();

                    for (Book book: books) {
                        System.out.println (book.toString());
                    }

                    break;

                case 2:

                    String bookName;
                    String bookAuthor;

                    System.out.println("Введите название книги, которую вы ищете:");
                    bookName = scanner.nextLine();

                    System.out.println("Введите автора книги, которую вы ищете:");
                    bookAuthor = scanner.nextLine();


                    Book book = catalog.findBook(bookName, bookAuthor);

                    if (book == null) {

                        System.out.println("Такой книги нет в каталоге");

                    } else {

                        System.out.println(book.toString());
                    }

                    break;

                case 3:

                    BookType bookType = ELECTRONICBOOK;

                    System.out.println("Введите название книги, которую вы предлагаете:");
                    bookName = scanner.nextLine();

                    System.out.println("Введите автора книги, которую вы предлагаете:");
                    bookAuthor = scanner.nextLine();

                    emailHandler.addEmail(new Email (user.getUserName(), new Book (bookName, bookAuthor, bookType)));

                    break;

                case 0:
                    return;

                default:
                    System.out.println("Ошибка");
            }
        }
    }

    private void getAdminConsole(User user) {

        Scanner scanner = new Scanner (System.in);

        int choice;

        while (true) {

            do {

                System.out.println(
                        "1 - Просмотреть книги в каталоге\n" +
                        "2 - Добавить книгу в каталог\n" +
                        "3 - Проверить почту\n" +
                        "0 - Выйти");

                while (!scanner.hasNextInt()) {
                    scanner.next();
                }

                choice = scanner.nextInt();

                scanner.nextLine();

            } while (choice < 0 || choice > 4);

            switch (choice) {

                case 1:

                    ArrayList <Book> books = catalog.getBooks();

                    for (Book book: books) {
                        System.out.println (book.toString());
                    }

                    break;

                case 2:

                    String bookName;
                    String bookAuthor;
                    BookType bookType = ELECTRONICBOOK;

                    System.out.println("Введите название книги, которую вы хотите добавить:");
                    bookName = scanner.nextLine();

                    System.out.println("Введите автора книги, которую вы хотите добавить:");
                    bookAuthor = scanner.nextLine();

                    catalog.addBookToCatalog(new Book (bookName, bookAuthor,bookType  ));

                    System.out.println("Книга была добавлена");

                    break;

                case 3:

                    for (Email email : emailHandler.getEmails()) {

                        System.out.println (email.toString());
                    }

                    break;

                case 0:

                    return;

                default:

                    System.out.println("Ошибка");
            }
        }
    }

}
