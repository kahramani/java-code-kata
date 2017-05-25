package com.kahramani.sandpit;

import org.junit.Assert;
import org.junit.Test;
import sandpit.DecimalZip;

/**
 * Created by kahramani on 5/3/2017.
 */
public class DecimalZipTest {

    @Test
    public void test_for_case1() {
        int A = 12;
        int B = 56;
        Assert.assertEquals(1526, DecimalZip.solution(A, B));
    }

    @Test
    public void test_for_case2() {
        int A = 56;
        int B = 12;
        Assert.assertEquals(5162, DecimalZip.solution(A, B));
    }

    @Test
    public void test_for_Case3() {
        int A = 12345;
        int B = 678;
        Assert.assertEquals(16273845, DecimalZip.solution(A, B));
    }

    @Test
    public void test_for_Case4() {
        int A = 123;
        int B = 67890;
        Assert.assertEquals(16273890, DecimalZip.solution(A, B));
    }

    @Test
     public void test_for_Case5() {
        int A = 1234;
        int B = 0;
        Assert.assertEquals(10234, DecimalZip.solution(A, B));
    }

    @Test
    public void test_for_Case6() {
        int A = 10000000;
        int B = 0;
        Assert.assertEquals(100000000, DecimalZip.solution(A, B));
    }

    @Test
    public void test_for_Case7() {
        int A = 10000000;
        int B = 1;
        Assert.assertEquals(-1, DecimalZip.solution(A, B));
    }

    @Test
    public void test_for_Case8() {
        int A = 10026500;
        int B = 1145;
        Assert.assertEquals(-1, DecimalZip.solution(A, B));
    }
}
