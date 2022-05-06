package com.curiousnerds.streams.tests.test18;

import com.curiousnerds.framework.testing.CuriousTestable;
import com.curiousnerds.framework.testing.LoggerExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(LoggerExtension.class)
public class ProblemTest extends CuriousTestable {

    @Test
    @DisplayName("get oldest customer ")
    public void oldestCustomer() {
        Problem problem = new Problem();
        /**
         //         * Get the oldest customer by using {@link Collectors#maxBy}.
         //         * Don't use any intermediate operations.
         //         */

        this.expected = problem.getCustomers().get(3);
        this.actual = problem.getNamesFormatted().get();
        assertEquals(this.expected, this.actual);
    }
}
