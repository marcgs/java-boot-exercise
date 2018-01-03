package com.exercise.util;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ScheduledTasksTest {

    @Test
    public void testCalculateMedianValue() {
        ScheduledTasks scheduledTasks = new ScheduledTasks();
        List<BigDecimal> medianValuesOddNumberOfElements = Arrays.asList(new BigDecimal(2.5), new BigDecimal(4.0), new BigDecimal(8.52));
        List<BigDecimal> medianValuesEvenNumberOfElements = Arrays.asList(new BigDecimal(2.5), new BigDecimal(4.0), new BigDecimal(8.52), new BigDecimal(15.0));
        assertEquals(new BigDecimal(4.0), scheduledTasks.calculateMedianValue(medianValuesOddNumberOfElements));
        assertEquals(new BigDecimal(6.26), scheduledTasks.calculateMedianValue(medianValuesEvenNumberOfElements));
    }

}
