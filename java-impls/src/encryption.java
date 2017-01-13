import helper.Logger;
import util.Validation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by kahramani on 1/6/2017.
 * --------------------------------------------------------------------------------------------------------------------
 *
 * Question Owner   : https://www.hackerrank.com/
 * Id/URL           : Encryption (https://www.hackerrank.com/challenges/encryption)
 * Difficulty       : Medium (marked by them)
 * Solution In      : Java 1.7
 *
 * --------------------------------------------------------------------------------------------------------------------
 *
 * What is needed to be done:
 *
 * 1. Get the sentence
 * 2. Remove spaces if exist and measure length(L) of the remaining
 * 3. Get square root of L (srL)
 * 4. Ensure that (floor of srL) <= rows <= columns <= (ceil of srL)
 * 5. Ensure that rows x columns >= L
 * 6. Set every char of the given sentence to rows and columns
 * 7. Then read them column by column as String
 * 8. Print the result
 *
 * Sample: chill out
 * Format: chi
 *         llo
 *         ut
 * Result: clu hlt io
 *
 * Run command example: java Encryption inputs/encryption-default.txt
 */
public class Encryption {

    public static void main(String[] args) throws FileNotFoundException {
        Validation.checkArgument(args, 0, Validation.MESSAGE_MISSING_FILE +
                " Example: java Encryption {input-file-path}");
        Scanner sc = new Scanner(new FileReader(args[0])); // default file --> inputs/encryption-default.txt
        Logger logger = new Logger(Encryption.class);
        logger.start();

        while(sc.hasNextLine()) {
            String sentence = sc.nextLine();
            logger.print(sentence + " -> " + encrypt(sentence));
        }

        logger.end();
    }

    private static String encrypt(String sentence) {
        sentence = sentence.replaceAll("\\s+", ""); // remove whitespaces if exist
        double srL = Math.sqrt((double) sentence.length());
        int rowCount = (int) Math.floor(srL);
        int columnCount = (int) Math.ceil(srL);
        // ensure that rows x columns >= L
        if(rowCount*columnCount < sentence.length()){
            rowCount++;
        }
        String[] encryptedWords = new String[columnCount];
        for(int i = 0; i < columnCount; i++) {
            StringBuilder encryptedWord = new StringBuilder();
            for(int j = 0; j < rowCount; j++) {
                int lookUpIndex = j * columnCount + i;
                if(lookUpIndex < sentence.length())
                    encryptedWord.append(sentence.charAt(lookUpIndex));
            }
            encryptedWords[i] = encryptedWord.toString();
        }

        String result = Arrays.toString(encryptedWords).replaceAll(",", "");
        result = result.substring(result.indexOf("[") + 1, result.lastIndexOf("]")); // clean array

        return result;
    }
}
