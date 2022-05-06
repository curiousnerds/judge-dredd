package com.curiousnerds.streams.tests.test6;

import com.curiousnerds.framework.testing.CuriousTestable;
import com.curiousnerds.framework.testing.LoggerExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(LoggerExtension.class)
public class ProblemTest extends CuriousTestable {


    @Test
    @DisplayName("Get the distinct age of customers")
    public void distinctAge() {
        Problem p = new Problem();
        List<Integer> distinctCustomerAge = p.getDistinctCustomerAge();

        /**
         * Create a stream with distinct age values using {@link Stream#distinct}
         */
        this.actual = String.valueOf(distinctCustomerAge);
       this.expected= "[22, 27, 28, 38, 26, 32, 35, 21, 36]";
        assertEquals(this.expected, this.actual);
    }

}
