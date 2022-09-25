package com.curiousnerds.streams.tests.test6;

import com.curiousnerds.framework.testing.CuriousTestable;
import com.curiousnerds.framework.testing.LoggerExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(LoggerExtension.class)
public class ProblemTest extends CuriousTestable {
    @Test
    @DisplayName("Get Top three richest customers names")
    public void distinctAge() {
        Problem p = new Problem();
        Stream<String> distinctCustomerAge = p.getTopRichCustomersName();

        this.actual = String.valueOf(distinctCustomerAge.collect(Collectors.toList()));
        this.expected= "";
        assertEquals(this.expected, this.actual);
    }
}
