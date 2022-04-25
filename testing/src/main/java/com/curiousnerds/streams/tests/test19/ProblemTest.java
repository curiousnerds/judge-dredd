package com.curiousnerds.streams.tests.test19;

import com.curiousnerds.framework.testing.CuriousTestable;
import com.curiousnerds.framework.testing.LoggerExtension;
import com.curiousnerds.streams.common.Customer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(LoggerExtension.class)
public class ProblemTest extends CuriousTestable {
    /**
     //         * Create a map of age as key and number of customers as value
     //         * using {@link Collectors#groupingBy} and {@link Collectors#counting}
     //         */
    @Test
    @DisplayName("age group count ")

    public void ageDistribution() {
        Problem problem = new Problem();

        this.expected = 9;
        this.actual = problem.groupCustomerByAge().size();
        assertEquals(this.expected, this.actual);
    }

    @Test
    @DisplayName("Check age distribution of customer")
    public void checkAgeDisributionCustomers() {

        Problem problem = new Problem();
        Map<Integer, Long> integerCustomerMap = problem.groupCustomerByAge();
        integerCustomerMap.forEach((k, v) -> {
            if (k.equals(22)) {
                this.expected = 2L;
                this.actual=v;
                assertEquals(this.expected,this.actual);
            } else {
                this.expected = 1L;
                this.actual=v;
                assertEquals(this.expected,this.actual);
            }
        });

    }
}
