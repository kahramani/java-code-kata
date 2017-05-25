package com.kahramani.sandpit;

import org.junit.Assert;
import org.junit.Test;
import sandpit.ElevatorStop;

/**
 * Created by kahramani on 5/3/2017.
 */
public class ElevatorStopTest {

    @Test
    public void test_for_case1() {
        int[] A = {60, 80, 40};
        int[] B = {2, 3, 5};
        int M = 5;
        int X = 2;
        int Y = 200;
        Assert.assertEquals(5, ElevatorStop.solution(A, B, M, X, Y));
    }

    @Test
    public void test_for_case2() {
        int[] A = {60, 80, 40, 70};
        int[] B = {2, 3, 5, 5};
        int M = 5;
        int X = 2;
        int Y = 200;
        Assert.assertEquals(5, ElevatorStop.solution(A, B, M, X, Y));
    }
}
