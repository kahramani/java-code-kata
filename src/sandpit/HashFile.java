package sandpit;

import helper.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by kahramani on 3/14/2017.
 */
public class HashFile {

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        Logger logger = new Logger(HashFile.class);
        logger.start();
        String algorithm = "SHA-256"; // SHA-1, SHA-256, SHA-384, SHA-512 etc.
        String filePath = "C:\\hdfs\\README.txt";
        logger.print(filePath + ", " + algorithm + " -> " + sha1(filePath, algorithm));
        logger.end();
    }

    private static String sha1(String filePath, String algorithm) throws NoSuchAlgorithmException, IOException {
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        FileInputStream fis = new FileInputStream(filePath);
        byte[] data = new byte[1024];
        int c;
        while ((c = fis.read(data)) != -1) {
            messageDigest.update(data, 0, c);
        }
        byte[] hashBytes = messageDigest.digest();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < hashBytes.length; i++) {
            sb.append(Integer.toString((hashBytes[i] & 0xff) + 0x100, 16).substring(1));
        }

        if(fis != null)
            fis.close();

        return sb.toString();
    }
}
