package biblio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Author {

    private String name;
    private Set<Book> bookList = new HashSet<>();


    public int countBooks() {
        return  this.bookList.size();
    }


    public void addBook(Book book) {
        //if(this.bookList.contains(book)) return;
        this.bookList.add(book);
    }
}
