package com.curiousnerds.streams.tests.test10;

import com.curiousnerds.framework.testing.CuriousTestable;
import com.curiousnerds.framework.testing.LoggerExtension;
import com.curiousnerds.streams.common.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

@ExtendWith(LoggerExtension.class)
public class ProblemTest extends CuriousTestable {

    @Test
    @DisplayName("test if youngest customer matches")
    public void youngestCustomer() {
        Problem problem = new Problem();
        List<Customer> customerList = problem.getCustomer();

        /**
         * Find the youngest customer by using {@link Stream#min}
         * Don't use {@link Stream#sorted}
         */

        this.expected =problem.test().get();
        this.actual = customerList.get(8);
        Assertions.assertEquals(this.expected, this.actual);
    }
}
