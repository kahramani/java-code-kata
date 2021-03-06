package com.kahramani.codeKata.sorting;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by kahramani on 4/4/2017.
 */
public class BubbleSortTest {

    @Test
    public void test_for_null() {
        Assert.assertArrayEquals(null, BubbleSort.sort(null));
    }

    @Test
    public void test_for_empty_array() {
        Assert.assertArrayEquals(new int[0], BubbleSort.sort(new int[0]));
    }

    @Test
    public void test_for_sample_with_non_repetitive_items() {
        int[] sample = {5, 3, 2, 8, 6};
        Assert.assertArrayEquals(new int[]{2, 3, 5, 6,8}, BubbleSort.sort(sample));
    }

    @Test
    public void test_for_sample_with_repetitive_items() {
        int[] sample = {9, 8, 1, 3, 8};
        Assert.assertArrayEquals(new int[]{1, 3, 8, 8, 9}, BubbleSort.sort(sample));
    }
}
