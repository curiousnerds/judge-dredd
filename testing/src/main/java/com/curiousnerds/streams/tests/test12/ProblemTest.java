package com.curiousnerds.streams.tests.test12;


import com.curiousnerds.framework.testing.CuriousTestable;
import com.curiousnerds.framework.testing.LoggerExtension;
import com.curiousnerds.streams.common.Customer;
import com.curiousnerds.streams.tests.test12.Problem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(LoggerExtension.class)
public class ProblemTest extends CuriousTestable {
    @Test
    @DisplayName("Is there anyone Over 40")

    public void isThereAnyoneOlderThan40() {
        Problem problem = new Problem();

        /**
         * Check whether any customer older than 40 exists or not, by using {@link Stream#anyMatch}
         */

        this.expected = false;
        this.actual = problem.isThereAnyoneOlderThan40();
        Assertions.assertEquals(this.expected, this.actual);

    }
}
