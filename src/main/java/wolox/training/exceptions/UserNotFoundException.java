package wolox.training.exceptions;

import wolox.training.utils.Constants;

public class UserNotFoundException extends  RuntimeException {

    public UserNotFoundException(){
        super(Constants.MESSSAGE_USER_NOT_FOUND);
    }

    public UserNotFoundException(long id){
        super(String.format(Constants.FORMAT_MESSSAGE_USER_NOT_FOUND,id));
    }
}
