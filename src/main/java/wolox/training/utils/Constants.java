package wolox.training.utils;

public class Constants {

    public static String FORMAT_MESSSAGE_BOOK_NOT_FOUND = "The book with id : %d, not found";
    public static String MESSSAGE_BOOK_NOT_FOUND = "The book can not be found";
    public static String MESSSAGE_BOOK_ID_MISSMATCH = "The id value of book is not the same of the parameter";
    public static String MESSSAGE_BOOK_ALREADY_OWNED = "This book already added for this user";
    public static String FORMAT_MESSSAGE_BOOK_ALREADY_OWNED = "The book %s already added for this user";

    public static String FORMAT_MESSSAGE_USER_NOT_FOUND = "The user with id : %d, not found";
    public static String MESSSAGE_USER_NOT_FOUND = "The user can not be found";
    public static String MESSSAGE_USER_ID_MISSMATCH = "The id value of user is not the same of the parameter";


    public static String getValidationMessage(String field){
        return String.format("The field %s cannot be null or empty");
    }


}
