package com.kahramani.codeKata.sorting;

/**
 * Created by kahramani on 4/4/2017.
 */
public class InsertionSort {

    public static int[] sort(int[] array) {
        if(array == null)
            return null;

        for (int i=1; i < array.length; i++) {
            int reference = array[i];
            int j = i;
            for(; j > 0 && array[j-1] > reference; j--) {
                array[j] = array[j-1];
            }
            array[j] = reference;
        }

        return array;
    }
}
