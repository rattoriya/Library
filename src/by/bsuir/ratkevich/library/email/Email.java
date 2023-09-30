package by.bsuir.ratkevich.library.email;

import by.bsuir.ratkevich.library.book.Book;

public class Email {

    private String userName;

    private Book book;

    public Email (String userName, Book book) {

        this.userName = userName;
        this.book = book;
    }

    public void setUserName (String userName) {

        this.userName = userName;
    }

    public void setBook (Book book) {

        this.book = book;
    }

    public String getUserName () {

        return userName;
    }

    public Book getBook () {

        return book;
    }

    @Override

    public String toString () {

        return "Email: "+ userName
                + "\nBook: " + book.toString();
    }

}
