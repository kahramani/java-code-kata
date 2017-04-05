package com.kahramani.codeKata.sorting;

/**
 * Created by kahramani on 4/4/2017.
 */
public class SelectionSort {

    public static int[] sort(int[] array) {
        if(array == null)
            return null;

        for (int i = 0; i < array.length-1; i++) {
            int min = i; // index
            for (int j = i+1; j < array.length; j++)
                if (array[j] < array[min])
                    min = j;
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }

        return array;
    }

}
