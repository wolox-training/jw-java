package wolox.training.exceptions;

import wolox.training.utils.Constants;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(){
        super(Constants.MESSSAGE_BOOK_NOT_FOUND);
    }

    public BookNotFoundException(long id){
        super(String.format(Constants.FORMAT_MESSSAGE_BOOK_NOT_FOUND,id));
    }
}
