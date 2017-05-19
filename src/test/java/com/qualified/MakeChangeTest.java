package com.qualified;


import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MakeChangeTest {

    private MakeChange countChange;

    @Before
    public void setUp() {
         countChange = new MakeChange();
    }

    @Test
    public void shouldHandleTheExampleCase() {
        assertThat(countChange.countChange(4, Arrays.asList(1,2)), is(3l));
    }

    @Test
    public void shouldHandleAnotherSimpleCase() {
        assertThat(countChange.countChange(10, Arrays.asList(5,2,3)), is(4l));
    }

    @Test
    public void shouldReturn0IfIsInvalidValueForChange() {
        assertThat(countChange.countChange(-1, Arrays.asList(5,2,3)), is(0l));
    }

    @Test
    public void shouldReturn0IfIsInvalidDenominations() {
        assertThat(countChange.countChange(10, Arrays.asList()), is(0l));
    }
}