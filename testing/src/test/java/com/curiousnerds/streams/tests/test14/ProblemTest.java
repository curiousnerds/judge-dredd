package com.curiousnerds.streams.tests.test14;

import com.curiousnerds.framework.testing.CuriousTestable;
import com.curiousnerds.framework.testing.LoggerExtension;
import com.curiousnerds.streams.tests.test13.Problem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(LoggerExtension.class)
public class ProblemTest extends CuriousTestable {

    @Test
    @DisplayName("Check whether all customer are older than 20 or not")

    public void everyoneWantsSomething() {
        Problem problem = new Problem();

        /**
         * Check whether all customer are older than 20 or not, by using {@link Stream#allMatch}
         *
         */


        this.expected = true;
        this.actual = problem.test();

        Assertions.assertEquals(this.expected, this.actual);
    }

}
