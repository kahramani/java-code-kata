package util;

/**
 * Created by kahramani on 1/12/2017.
 */
public class Validation {

    public static final String MESSAGE_MISSING_FILE = "You need to specify an input file to run!";
    public static final String MESSAGE_MISSING_SORT_TYPE = "You need to specify a sort type. (bubble, selection etc.)";
    public static final String MESSAGE_WRONG_SORT_TYPE = "There is no defined sort type named: ";

    public static void checkArgument(String[] args, int index, String message) {
        if(args == null || args.length <= index || args[index] == null || "".equals(args[index].trim()))
            throw new NullPointerException(message);
    }
}
