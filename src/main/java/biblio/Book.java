package biblio;

public class Book {
    private Author author;
    private String title;

    private boolean isRent;


    public Book(String title, Author author) {
        author.addBook(this);
        this.author = author;
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean getIsRent() {
        return isRent;
    }

    public boolean setIsRent(boolean bool) {
        this.isRent = bool;
        return bool;
    }


}
