package com.curiousnerds.streams.tests.test20;

import com.curiousnerds.framework.testing.CuriousTestable;
import com.curiousnerds.framework.testing.LoggerExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import javax.swing.*;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(LoggerExtension.class)
public class ProblemTest extends CuriousTestable {
    @Test
    @DisplayName("get stream from values")
    public void streamFromValues() {
        Problem problem = new Problem();

        /**
         * Create a stream with string values "a" "b" "c" by using {@link Stream#of}
         */

        this.expected = problem.streamOf().collect(Collectors.toList());
        this.actual = Stream.of("a", "b", "c").collect(Collectors.toList());

        assertEquals(this.expected, this.actual);
    }



}
