package com.curiousnerds.streams.tests.test8;

import com.curiousnerds.framework.testing.CuriousTestable;
import com.curiousnerds.framework.testing.LoggerExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(LoggerExtension.class)
public class ProblemTest extends CuriousTestable {
    @Test
    @DisplayName("test if the items wanted is 32")
    public void howManyItemsWanted() {
        Problem problem = new Problem();
        long sum = problem.howmanywanted();
        this.actual = sum;
        this.expected=32L;
        assertEquals(this.expected,this.actual);
    }
}
