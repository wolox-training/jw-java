package wolox.training.exceptions;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(){
        super("The book can not be found");
    }

    public BookNotFoundException(long id){
        super(String.format("The book with id : %d, not found"));
    }
}
