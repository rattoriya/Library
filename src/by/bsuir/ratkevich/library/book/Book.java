package by.bsuir.ratkevich.library.book;

public class Book {

    private String bookName;

    private String bookAuthor;


    private BookType bookType;

    public Book (String bookName, String bookAuthor, BookType bookType) {

        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookType = bookType;
    }

    public void setBookName (String bookName) {

        this.bookName = bookName;
    }

    public void setBookAuthor (String bookAuthor) {

        this.bookAuthor = bookAuthor;
    }

    public void setBookType (BookType bookType) {

        this.bookType = bookType;
    }

    public String getBookName (){

        return bookName;
    }

    public String getBookAuthor () {

        return bookAuthor;
    }

    public BookType getBookType () {

        return bookType;
    }

    @Override
    public boolean equals (Object object) {

        Book book = (Book) object;

        return bookName.equals(book.getBookName())
                && bookAuthor.equals(book.getBookAuthor())
                && bookType.equals(book.getBookType());
    }

    @Override

    public String toString () {

        return "Название: "+ bookName + "\nАвтор книги: " + bookAuthor +
                "\nТип Книги: "+ bookType.toString();

    }

}
