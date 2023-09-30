package by.bsuir.ratkevich.library.catalog;

import java.util.ArrayList;
import java.io.*;

import by.bsuir.ratkevich.library.book.Book;
import by.bsuir.ratkevich.library.book.BookType;

public class Catalog {

    private ArrayList <Book> books;

    private String fileName = "Books.txt";

    public Catalog () {

        books = new ArrayList <> ();
        readCatalogFromFile();

    }

    public ArrayList<Book> getBooks () {

        return books;
    }

    public void addBookToCatalog ( Book book) {

        books.add(book);
        writeBookToFile (book);
    }

    public Book findBook(String bookName, String bookAuthor) {

        for (Book book: books) {

            if (book.getBookName().equals(bookName)
                    && book.getBookAuthor().equals(bookAuthor))
            {

                return book;
            }

        }

        return null;
    }

    public void readCatalogFromFile () {

        String bookName;

        String bookAuthor;

        BookType bookType;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            String[] buffer;

            while ((line = reader.readLine()) != null) {
                buffer = line.split("\\|");

                bookName = buffer[0];
                bookAuthor = buffer[1];
                bookType = BookType.valueOf(buffer[2]);

                books.add(new Book(bookName, bookAuthor, bookType ));
            }

        } catch (IOException e) {

        }
    }

    public void writeBookToFile (Book book) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {

            writer.write(book.getBookName() + "|" + book.getBookAuthor() + "|"+ book.getBookType() + "\n");

        } catch (IOException e) {

        }

    }
}
