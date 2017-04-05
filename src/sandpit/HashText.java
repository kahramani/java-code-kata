package sandpit;

import helper.Logger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by kahramani on 3/14/2017.
 */
public class HashText {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Logger logger = new Logger(HashText.class);
        logger.start();
        String algorithm = "SHA-256"; // SHA-1, SHA-256, SHA-384, SHA-512 etc.
        String text = "test";
        logger.print(text + ", " + algorithm + " -> " + sha1(text, algorithm));
        logger.end();
    }

    private static String sha1(String text, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        byte[] hashBytes = messageDigest.digest(text.getBytes());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < hashBytes.length; i++) {
            sb.append(Integer.toString((hashBytes[i] & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }
}
