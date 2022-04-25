package com.curiousnerds.streams.tests.test23;

import com.curiousnerds.framework.testing.CuriousTestable;
import com.curiousnerds.framework.testing.LoggerExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(LoggerExtension.class)
public class ProblemTest extends CuriousTestable {

    @Test
    @DisplayName("Check if LongStream is used ")
    public void checkIfLongStream() {
        Problem problem = new Problem();

        /**
         * Create {@link LongStream} with all items' prices using {@link Stream#mapToLong}
         * Then calculate the sum of prices using {@link LongStream#sum}
         */
        problem.getAllItemPrice();
        this.expected = "LongStream";
        this.actual = problem.longStream instanceof LongStream ? "LongStream" : "Not a LongStream";
        assertEquals(this.expected, this.actual);
    }
    @Test
    @DisplayName("Calculate all the items in shop")
    public void howMuchToBuyAllItems() {
        Problem problem = new Problem();

        /**
         * Create {@link LongStream} with all items' prices using {@link Stream#mapToLong}
         * Then calculate the sum of prices using {@link LongStream#sum}
         */
        this.expected = problem.getShops().stream().flatMap(shop -> shop.getItems().stream()).mapToLong(item -> item.getPrice()).sum();
        this.actual = problem.getAllItemPrice();
        assertEquals(this.expected, this.actual);

    }

}
