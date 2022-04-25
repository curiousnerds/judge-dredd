package com.curiousnerds.streams.tests.test9;

import com.curiousnerds.framework.testing.CuriousTestable;
import com.curiousnerds.framework.testing.LoggerExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import javax.crypto.interfaces.PBEKey;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(LoggerExtension.class)
public class ProblemTest extends CuriousTestable {
    @Test
    @DisplayName("test if the items wanted is 32")
    public void richestCustomer() {
        Problem problem = new Problem();
        this.actual = problem.richestCustomer().get();
        this.expected = 12000;
        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("Test if the comparator is of NaturalOrderComparator")
    public void testNaturalOrderComparator(){
        Problem problem = new Problem();
        this.expected="NaturalOrderComparator";
        this.actual = problem.comparator.getClass().getSimpleName();
        assertEquals(this.expected, this.actual);
    }

}
