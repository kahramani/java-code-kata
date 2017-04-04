package com.kahramani.codeKata.sorting;

/**
 * Created by kahramani on 4/4/2017.
 */
public class BubbleSort {

    public static int[] sort(int[] array) {
        if(array == null)
            return null;

        int i = (array.length - 1);
        for (; i >= 0; i--) {
            for (int j = 1; j <= i; j++) {
                if (array[j-1] > array[j]) {
                    int temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }
            }
        }

        return array;
    }

}
