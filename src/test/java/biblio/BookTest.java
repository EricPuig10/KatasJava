package biblio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @BeforeEach
    void setUp (){

    }

    @Test
    void bookCanCreateWithAttributes(){
        Author author = new Author();
        Book book = new Book("Clean Architecture", author);



        assertEquals("Clean Architecture",book.getTitle());
        assertEquals(author, book.getAuthor());
    }

    @Test
    void bookCanBeRent(){
        Author akira = new Author();
        Book book = new Book("Dragon Ball", akira);

        var result = book.setIsRent(true);


        assertEquals(true, result);

    }





}