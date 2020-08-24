package wolox.training.factories;

import java.util.Random;
import wolox.training.models.Book;

public class BookFactory {

    public static Book build(){
        Random random = new Random();
        Book book = new Book();
        book.setGenre("Genre_"+random.nextInt());
        book.setAuthor("Author_"+random.nextInt());
        book.setImage(random.nextInt()+".jpg");
        book.setTitle("Book "+random.nextInt());
        book.setSubtitle("sub_"+random.nextInt());
        book.setPublisher("Publisher-"+random.nextInt());
        book.setPages(100);
        book.setYear("2020");
        book.setIsbn("12345678"+random.nextInt());

        return book;
    }

}
