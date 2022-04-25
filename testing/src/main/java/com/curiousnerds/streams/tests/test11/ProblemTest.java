package com.curiousnerds.streams.tests.test11;


import com.curiousnerds.framework.testing.CuriousTestable;
import com.curiousnerds.framework.testing.LoggerExtension;
import com.curiousnerds.streams.common.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(LoggerExtension.class)
public class ProblemTest extends CuriousTestable {
    @Test
    @DisplayName("Check the first customer")
    public void firstRegistrant() {
        Problem problem = new Problem();


        /**
         * Find the first customer who registered this online store by using {@link Stream#findFirst}
         * The customerList are ascending ordered by registered timing.
         */
        Optional<Customer> firstCustomer = problem.findFirstCustomer();;
        this.expected=firstCustomer.get();
        this.actual = problem.getCustomers().get(0);
        assertEquals(this.expected, this.actual);
    }
}
