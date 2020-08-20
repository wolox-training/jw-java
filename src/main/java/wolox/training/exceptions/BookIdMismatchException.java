package wolox.training.exceptions;

public class BookIdMismatchException extends RuntimeException{

    public  BookIdMismatchException(){
        super("The id value of book is not the same of the parameter");

    }
}
