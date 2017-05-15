package com.qualified;


import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class Challenge1Test {

    private Challenge1 countChange;

    @Before
    public void setUp() {
         countChange = new Challenge1();
    }

    @Test
    @Ignore
    public void shouldHandleTheExampleCase() {
        assertEquals((Integer)3, countChange.countChange(4, Arrays.asList(1,2)));
    }

    @Test
    @Ignore
    public void shouldHandleAnotherSimpleCase() {
        assertEquals((Integer)4, countChange.countChange(10, Arrays.asList(5,2,3)));
    }

    @Test
    @Ignore
    public void shouldReturn0IfIsInvalidValueForChange() {
        assertEquals((Integer)0, countChange.countChange(-1, Arrays.asList(5,2,3)));
    }

    @Test
    @Ignore
    public void shouldReturn0IfIsInvalidDenominations() {
        assertEquals((Integer)0, countChange.countChange(10, Arrays.asList()));
    }
}