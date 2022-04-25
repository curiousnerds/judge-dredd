package com.curiousnerds.streams.tests.test22;

import com.curiousnerds.framework.testing.CuriousTestable;
import com.curiousnerds.framework.testing.LoggerExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(LoggerExtension.class)
public class ProblemTest extends CuriousTestable {

    @Test
    @DisplayName("calculate customers average age")
    public void averageAge() {
       Problem problem = new Problem();
        /**
         * Create {@link IntStream} with customer ages by using {@link Stream#mapToInt}
         * Then calculate the average of ages by using {@link IntStream#average}
         */
        this.actual = problem.calculateAvgCustomerAge().getAsDouble();
        this.expected = problem.getCustomers().stream().mapToInt(custmer -> custmer.getAge()).average().getAsDouble();
        assertEquals(this.expected, this.actual);
    }

}
