package com.kahramani.codeKata.sorting;

/**
 * Created by kahramani on 4/4/2017.
 */
public class MergeSort {

    public static int[] sort(int[] array) {
        if(array == null)
            return null;
        else if(array.length == 0)
            return array;

        return merge(array, 0, array.length-1);
    }

    private static int[] merge(int[] array, int left, int right) {
        if(left < right) {
            int middle = (left + right) / 2;
            merge(array, left, middle);
            merge(array, middle + 1, right);

            // merge process starts here
            int length1 = middle - left + 1;
            int length2 = right - middle;

            Integer[] leftArray = new Integer[length1];
            Integer[] rightArray = new Integer[length2];

            for (int i=0; i < length1; ++i)
                leftArray[i] = array[left + i];
            for (int j=0; j < length2; ++j)
                rightArray[j] = array[middle + 1+ j];

            int i = 0, j = 0, k = left;

            while (i < length1 && j < length2) {
                if(leftArray[i] < rightArray[j]) {
                    array[k] = leftArray[i];
                    i++;
                } else {
                    array[k] = rightArray[j];
                    j++;
                }
                k++;
            }

            while (i < length1) {
                array[k] = leftArray[i];
                i++;
                k++;
            }

            while (j < length2) {
                array[k] = rightArray[j];
                j++;
                k++;
            }
        }

        return array;
    }
}
