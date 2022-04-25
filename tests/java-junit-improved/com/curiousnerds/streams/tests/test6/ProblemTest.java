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


    @Easy @Test
    public void distinctAge() {
        List<Customer> customerList = this.mall.getCustomerList();

        /**
         * Create a stream with distinct age values using {@link Stream#distinct}
         */
        Stream<Integer> distinctAgeStream = null;

        List<Integer> distinctAgeList = distinctAgeStream.collect(Collectors.toList());
        assertThat(distinctAgeList, contains(22, 27, 28, 38, 26, 32, 35, 21, 36));
    }
//    @Test
//    @DisplayName("Find top Tree rich customers")
//    public void findTopThreeRichCustomers() {
//        Problem sol = new Problem();
//        Stream<String> topThreerichCustomers = sol.getCustomerAgeListByDesc();
//        List<String> collect = topThreerichCustomers.collect(Collectors.toList());
//        this.actual = String.valueOf(collect);
//        this.expected = "[Diana, Andrew, Chris]";
//        assertEquals(this.expected, this.actual);
//    }
}
