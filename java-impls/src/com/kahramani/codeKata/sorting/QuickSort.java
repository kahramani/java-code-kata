package com.kahramani.codeKata.sorting;

/**
 * Created by kahramani on 4/4/2017.
 */
public class QuickSort {

    public static int[] sort(int[] array) {
        if(array == null)
            return null;
        else if(array.length == 0)
            return array;

        return adjust(array, 0, array.length-1);
    }

    private static int[] adjust(int[] array, int lower, int higher) {
        int i = lower;
        int j = higher;

        int reference = array[lower + (higher-lower) / 2];

        while (i <= j) {
            while (array[i] < reference) {
                i++;
            }
            while (array[j] > reference) {
                j--;
            }

            if(i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }

            if (lower < j)
                adjust(array, lower, j);
            if (i < higher)
                adjust(array, i, higher);
        }

        return array;
    }
}
