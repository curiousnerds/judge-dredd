package com.curiousnerds.streams.tests.test5;

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
    @DisplayName("Find top Tree rich customers")
    public void findTopThreeRichCustomers() {
        Problem sol = new Problem();
        Stream<String> topThreerichCustomers = sol.getCustomerAgeListByDesc();
        List<String> collect = topThreerichCustomers.collect(Collectors.toList());
        this.actual = String.valueOf(collect);
        this.expected = "[Diana, Andrew, Chris]";
        assertEquals(this.expected, this.actual);
    }
}
