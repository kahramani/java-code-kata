package com.kahramani.sandpit;

import org.junit.Assert;
import org.junit.Test;
import sandpit.PasswordCatcher;

/**
 * Created by kahramani on 5/3/2017.
 */
public class PasswordCatcherTest {

    @Test
    public void test_for_a0bb() {
        String alpha = "a0bb";
        Assert.assertEquals(-1, PasswordCatcher.solution(alpha));
    }

    @Test
    public void test_for_a0Ba() {
        String alpha = "a0Ba";
        Assert.assertEquals(2, PasswordCatcher.solution(alpha));
    }

    @Test
    public void test_for_asdascsasdasdaweq() {
        String alpha = "asdascsasdasdaweq";
        Assert.assertEquals(-1, PasswordCatcher.solution(alpha));
    }
}
