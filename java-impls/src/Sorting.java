import helper.Logger;
import util.Validation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by kahramani on 1/11/2017.
 * --------------------------------------------------------------------------------------------------------------------
 *
 * Question Owner   : General Algorithm Issue
 * Id/URL           : Sorting
 * Difficulty       : Easy
 * Solution In      : Java 1.7
 *
 * --------------------------------------------------------------------------------------------------------------------
 *
 * What is needed to be done:
 *
 * 1. Get the array
 * 2. Sort them with the given sorting algorithm
 * 3. Print the result
 *
 * Run command example: java Sorting inputs/sorting-default.txt bubble
 */
public class Sorting {

    public static void main(String[] args) throws FileNotFoundException {
        Validation.checkArgument(args, 0, Validation.MESSAGE_MISSING_FILE +
                " Example: java Sorting {input-file-path} {sort-type}");
        Validation.checkArgument(args, 1, Validation.MESSAGE_MISSING_SORT_TYPE);
        Scanner sc = new Scanner(new FileReader(args[0])); // default file --> inputs/sorting-default.txt
        String sortType = args[1];
        Logger logger = new Logger(Sorting.class);
        logger.start();
        Integer[] ar = buildArray(sc);
        switch (sortType) {
            case "built-in": // java built-in sorting
                Arrays.sort(ar);
                break;
            case "bubble":
                bubbleSort(ar);
                break;
            case "selection":
                selectionSort(ar);
                break;
            case "insertion":
                insertionSort(ar);
                break;
            case "quick":
                quickSort(ar, 0, ar.length - 1);
                break;
            case "merge":
                mergeSort(ar, 0, ar.length - 1);
                break;
            default:
                throw new IllegalArgumentException(Validation.MESSAGE_WRONG_SORT_TYPE + sortType);
        }
        logger.print("Sorted array: " + Arrays.toString(ar));
        logger.print("Size: " + ar.length + ", Type: " + sortType);
        logger.end();
    }

    private static Integer[] buildArray(Scanner sc) {
        List<Integer> list = new LinkedList<>();
        while(sc.hasNextInt()) {
            list.add(sc.nextInt());
        }

        Integer[] ar = new Integer[list.size()];
        return list.toArray(ar);
    }

    // O(n^2)
    private static void bubbleSort(Integer ar[]) {
        for (int i = (ar.length - 1); i >= 0; i--) {
            for (int j = 1; j <= i; j++) {
                if (ar[j-1] > ar[j]){
                    int temp = ar[j-1];
                    ar[j-1] = ar[j];
                    ar[j] = temp;
                }
            }
        }
    }

    // O(n^2)
    private static void selectionSort(Integer ar[]) {
        for (int i = 0; i < ar.length-1; i++) {
            int min = i; // index
            for (int j = i+1; j < ar.length; j++)
                if (ar[j] < ar[min])
                    min = j;
            int temp = ar[i];
            ar[i] = ar[min];
            ar[min] = temp;
        }
    }

    // O(n^2)
    private static void insertionSort(Integer ar[]) {
        for (int i=1; i < ar.length; i++) {
            int reference = ar[i];
            int j = i;
            for(; j > 0 && ar[j-1] > reference; j--) {
                ar[j] = ar[j-1];
            }
            ar[j] = reference;
        }
    }

    // O(n^2)
    private static void quickSort(Integer ar[], int lower, int higher) {
        int i = lower;
        int j = higher;

        int reference = ar[lower + (higher-lower) / 2];

        while (i <= j) {
            while (ar[i] < reference) {
                i++;
            }
            while (ar[j] > reference) {
                j--;
            }

            if(i <= j) {
                int temp = ar[i];
                ar[i] = ar[j];
                ar[j] = temp;
                i++;
                j--;
            }

            if (lower < j)
                quickSort(ar, lower, j);
            if (i < higher)
                quickSort(ar, i, higher);
        }
    }

    // O(n log n)
    private static void mergeSort(Integer ar[], int left, int right) {
        if(left < right) {
            int middle = (left + right) / 2;
            mergeSort(ar, left, middle);
            mergeSort(ar, middle + 1, right);

            // merge process starts here
            int length1 = middle - left + 1;
            int length2 = right - middle;

            Integer[] leftArray = new Integer[length1];
            Integer[] rightArray = new Integer[length2];

            for (int i=0; i < length1; ++i)
                leftArray[i] = ar[left + i];
            for (int j=0; j < length2; ++j)
                rightArray[j] = ar[middle + 1+ j];

            int i = 0, j = 0, k = left;

            while (i < length1 && j < length2) {
                if(leftArray[i] < rightArray[j]) {
                    ar[k] = leftArray[i];
                    i++;
                } else {
                    ar[k] = rightArray[j];
                    j++;
                }
                k++;
            }

            while (i < length1) {
                ar[k] = leftArray[i];
                i++;
                k++;
            }

            while (j < length2) {
                ar[k] = rightArray[j];
                j++;
                k++;
            }
        }
    }
}
