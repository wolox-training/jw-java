package wolox.training.exceptions;

import wolox.training.utils.Constants;

public class BookIdMismatchException extends RuntimeException{

    public  BookIdMismatchException(){
        super(Constants.MESSSAGE_BOOK_ID_MISSMATCH);

    }
}
