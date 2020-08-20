package wolox.training.exceptions;

import wolox.training.utils.Constants;

public class BookAlreadyOwnedException extends RuntimeException{

    public BookAlreadyOwnedException(){
        super(Constants.MESSSAGE_BOOK_ALREADY_OWNED);
    }

    public BookAlreadyOwnedException(String title){
        super(String.format(Constants.FORMAT_MESSSAGE_BOOK_ALREADY_OWNED, title));
    }
}
