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


    public static String getNullOrEmptyValidationMessage(String field){
        return String.format("The field %s cannot be null or empty",field);
    }

    public static String getNumberValidationMessage(String field){
        return String.format("The number of %s must be greather than 0",field);
    }

    public static String getNotNullalidationMessage(String field){
        return String.format("The field %s cannot be null",field);
    }

    public static String getEmptyListValidationMessage(String field){
        return String.format("The list of %s must have at least one item",field);
    }



}
