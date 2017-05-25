package sandpit;

/**
 * Created by kahramani on 5/3/2017.
 * Zalando Task-1
 */
public class PasswordCatcher {

    public static int solution(String S) {
        String delimiterRegex = "[0-9]";
        String validPasswordRegex = "[a-z]*[A-Z]{1}[a-z]*";
        String[] splitArray = S.split(delimiterRegex);
        int longest = -1;
        for(int i = 0; i < splitArray.length; i++) {
            String candidate = splitArray[i];
            if(candidate.matches(validPasswordRegex) && candidate.length() >= longest)
                longest = candidate.length();
        }

        return longest;
    }
}
