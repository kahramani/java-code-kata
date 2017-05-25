package sandpit;

/**
 * Created by kahramani on 5/3/2017.
 * Zalando Task-2
 */
public class DecimalZip {

    public static int solution(int A, int B) {
        StringBuilder zippedStr = new StringBuilder(A + "");
        String partB = B + "";

        for(int i = 0; i < partB.length(); i++) {
            int insertIndex = (i*2)+1 > zippedStr.length() ? zippedStr.length() : (i*2)+1;
            zippedStr.insert(insertIndex, partB.charAt(i));
        }

        try {
            int candidate = Integer.parseInt(zippedStr.toString());
            if(candidate <= 100000000)
                return candidate;
        } catch (Exception e) {} // If it exceeds max integer value

        return -1;
    }
}
