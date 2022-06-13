package biblio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {


    @Test
    void usersCanRentABook(){
        User user = new User("Eric");
        Author Dani = new Author ();
        Book book = new Book ("A la recerca del català autèntic", Dani);

        user.rentABook(book);

        var result = book.getIsRent();



        assertEquals(true, result);
    }

    @Test
    void getLengthOfListOfBooks(){
        User Eric = new User("Eric");
        Author author = new Author();
        Book book = new Book ("A la recerca del català autèntic", author);
        Book book1 = new Book ("A la recerca del català autèntic", author);
        Book book2 = new Book ("A la recerca del català autèntic", author);


        Eric.rentABook(book);
        Eric.rentABook(book1);
        Eric.rentABook(book2);

        var result = Eric.getLengthOfRentedBooksList();

        assertEquals(3, result);

    }

    @Test
    void usersCantRentABookAlreadyRented(){
        User user = new User("user");
        User Eric = new User("Eric");
        Author Dani = new Author ();
        Author author = new Author();
        Book book = new Book ("A la recerca del català autèntic", Dani);
        Book DragonBall = new Book("dragon ball", author);

        user.rentABook(book);
        Eric.rentABook(book);
        Eric.rentABook(DragonBall);

        var result = Eric.getListOfRentedBooks();
        var lenghtListOfBooks = Eric.getLengthOfRentedBooksList();

        var bookResult = result.get(0).getTitle();

        assertEquals(1, lenghtListOfBooks);

    }




}