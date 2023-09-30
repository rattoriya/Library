package by.bsuir.ratkevich.library.email;

import java.io.*;
import java.util.ArrayList;

import by.bsuir.ratkevich.library.book.Book;
import by.bsuir.ratkevich.library.book.BookType;

public class EmailHandler {

    private ArrayList <Email> emails;

    private String fileName = "Emails.txt";

    public EmailHandler () {

        emails = new ArrayList <Email> ();
        readEmailsFromFile();
    }

    public ArrayList <Email> getEmails () {

        return emails;
    }

    public Email findEmail (Email findEmail) {

        for (Email email: emails) {

            if (email.getUserName().equals(findEmail.getUserName())
                && email.getBook().equals(findEmail.getBook()))
            {

                return email;
            }
        }

        return null;
    }

    public void addEmail (Email email) {

        emails.add(email);

        writeEmailToFile(email);
    }

    public void readEmailsFromFile() {

        String userName;
        String bookName;
        String bookAuthor;
        BookType bookType;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            String [] buffer;

            while ((line = reader.readLine()) != null) {

                buffer = line.split("\\|");

                userName = buffer[0];
                bookName = buffer[1];
                bookAuthor = buffer[2];
                bookType = BookType.valueOf(buffer[3]);

                emails.add(new Email (userName, new Book (bookName, bookAuthor, bookType)));
            }

        } catch (IOException e) {

        }
    }

    public void writeEmailToFile (Email email) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {

            writer.write(email.getUserName()+ "|" + email.getBook().getBookName() + "|" + email.getBook().getBookAuthor() + "|" + email.getBook().getBookType() + "\n");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
