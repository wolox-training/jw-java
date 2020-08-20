package wolox.training.exceptions;

import wolox.training.utils.Constants;

public class UserIdMismatchException extends RuntimeException{

    public UserIdMismatchException(){
        super(Constants.MESSSAGE_USER_ID_MISSMATCH);
    }

}
