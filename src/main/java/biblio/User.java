package biblio;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;

    private List<Book> listOfRentedBooks = new ArrayList<>();

    public List<Book> getListOfRentedBooks() {
        return listOfRentedBooks;
    }
    public int getLengthOfRentedBooksList(){
        return listOfRentedBooks.size();
    }

    public User (String name){
        this.name= name;
    }

    public void rentABook(Book book){
        if(book.getIsRent()) return;

        book.setIsRent(true);
        this.listOfRentedBooks.add(book);
    }

}
