package com.kahramani.codeKata.sorting;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by kahramani on 4/4/2017.
 */
public class InsertionSortTest {

    @Test
    public void test_for_null() {
        Assert.assertArrayEquals(null, InsertionSort.sort(null));
    }

    @Test
    public void test_for_empty() {
        Assert.assertArrayEquals(new int[0], InsertionSort.sort(new int[0]));
    }

    @Test
    public void test_for_sample_with_non_repetitive_items() {
        int[] sample = {5, 3, 2, 8, 6};
        Assert.assertArrayEquals(new int[]{2, 3, 5, 6,8}, InsertionSort.sort(sample));
    }

    @Test
    public void test_for_sample_with_repetitive_items() {
        int[] sample = {9, 8, 1, 3, 8};
        Assert.assertArrayEquals(new int[]{1, 3, 8, 8, 9}, InsertionSort.sort(sample));
    }
}
