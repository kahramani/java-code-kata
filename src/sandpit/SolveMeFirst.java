package sandpit;

import helper.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by kahramani on 12/27/2016.
 * --------------------------------------------------------------------------------------------------------------------
 *
 * Question Owner   : https://www.hackerrank.com/
 * Id/URL           : Solve Me First (https://www.hackerrank.com/challenges/solve-me-first)
 * Difficulty       : Easy (marked by them)
 * Solution In      : Java 1.8
 *
 * --------------------------------------------------------------------------------------------------------------------
 *
 * What is needed to be done:
 *
 * 1. Get two integers as inputs
 * 2. Sum them up
 * 3. Print the result
 *
 * Run command example: java raw.SolveMeFirst inputs/solveMeFirst-default.txt
 */
public class SolveMeFirst {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader(args[0])); // default file --> inputs/solveMeFirst-default.txt
        Logger logger = new Logger(SolveMeFirst.class);
        logger.start();
        int first = sc.nextInt();
        int second = sc.nextInt();
        int result = solveMeFirst(first, second);
        logger.print(first + "+" + second + " = " + Integer.toString(result));
        logger.end();
        if(sc != null)
            sc.close();
    }

    private static int solveMeFirst(int a, int b) {
        return a+b;
    }
}