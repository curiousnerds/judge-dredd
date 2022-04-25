package com.curiousnerds.streams.tests.test21;

import com.curiousnerds.framework.testing.CuriousTestable;
import com.curiousnerds.framework.testing.LoggerExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(LoggerExtension.class)
public class ProblemTest extends CuriousTestable {
    @Test
    @DisplayName("create a stream of multiples of 3 starting from 0 to 10")
    public void numberStream() {

       Problem problem = new Problem();
        /**
         * Create a stream only with multiples of 3, starting from 0, size of 10, by using {@link Stream#iterate}
         */

        Stream.iterate(3, integer -> integer.intValue());
        this.expected = Stream.iterate(0, integer -> integer + 3).limit(10).collect(Collectors.toList());
        this.actual =problem.createStreamMultiplesOfThree().collect(Collectors.toList());

        assertEquals(this.expected, this.actual);
    }
    // TODO: what happens when you run out of heap space , how do you capture those information and put in the response??????



}
