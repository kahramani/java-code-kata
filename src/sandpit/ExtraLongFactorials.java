package sandpit;

import helper.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by kahramani on 1/6/2017.
 * --------------------------------------------------------------------------------------------------------------------
 *
 * Question Owner   : https://www.hackerrank.com/
 * Id/URL           : Extra Long Factorials (https://www.hackerrank.com/challenges/extra-long-factorials)
 * Difficulty       : Medium (marked by them)
 * Solution In      : Java 1.8
 *
 * --------------------------------------------------------------------------------------------------------------------
 *
 * What is needed to be done:
 *
 * 1. Get the integer
 * 2. Calculate factorial
 * 3. Print the result
 *
 * Run command example: java raw.ExtraLongFactorials inputs/extraLongFactorials-default.txt
 */
public class ExtraLongFactorials {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader(args[0])); // default file --> inputs/extraLongFactorials-default.txt
        Logger logger = new Logger(ExtraLongFactorials.class);
        logger.start();
        while(sc.hasNext()) {
            int n = sc.nextInt();
            BigInteger result = calculateFactorial(n);
            logger.print(n + "! = " + result.toString());
        }
        logger.end();
        if(sc != null)
            sc.close();
    }

    private static BigInteger calculateFactorial(int n) {
        if(n == 1)
            return BigInteger.valueOf(1);

        return BigInteger.valueOf(n).multiply(calculateFactorial(n-1));
    }
}
