package com.curiousnerds.streams.tests.test15;

import com.curiousnerds.framework.testing.CuriousTestable;
import com.curiousnerds.framework.testing.LoggerExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.stream.Collectors;

@ExtendWith(LoggerExtension.class)
public class ProblemTest extends CuriousTestable {

    @Test
    @DisplayName("Check the names list")

    public void nameList() {
        Problem problem = new Problem();

        /**
         * Check whether all customer are older than 20 or not, by using {@link Stream#allMatch}
         *
         */


        this.expected = problem.getCustomers().stream().map(customer -> customer.getName()).collect(Collectors.toList());
        this.actual = problem.nameList();

        Assertions.assertEquals(this.expected, this.actual);
    }

}
