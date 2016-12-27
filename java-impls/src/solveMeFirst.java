import helper.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by kahramani on 12/27/2016.
 * --------------------------------------------------------------------------------------------------------------------
 *
 * Question Owner   : https://www.hackerrank.com/
 * Question Id      : Solve Me First (https://www.hackerrank.com/challenges/solve-me-first)
 * Difficulty       : Easy (marked by them)
 * Solution By      : Java 1.7
 *
 * --------------------------------------------------------------------------------------------------------------------
 *
 * What is needed to be done:
 *
 * 1. Get two integers as inputs
 * 2. Sum them up
 * 3. Print the result
 *
 */
public class solveMeFirst {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader(args[0]));
        Logger logger = new Logger(solveMeFirst.class);
        logger.start();
        int result = solveMeFirst(sc.nextInt(), sc.nextInt());
        logger.result(Integer.toString(result));
        logger.end();
    }

    private static int solveMeFirst(int a, int b) {
        return a+b;
    }
}