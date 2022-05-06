package com.curiousnerds.streams.tests.test16;

import com.curiousnerds.framework.testing.CuriousTestable;
import com.curiousnerds.framework.testing.LoggerExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(LoggerExtension.class)
public class ProblemTest extends CuriousTestable {

    @Test
    @DisplayName("check distinct age size ")
    public void ageSetSize() {
        Problem problem = new Problem();

        /**
         * Create a set of customer age by using {@link Stream#collect} and {@link Collectors#toSet}
         */
        Set<Integer> ageSet = problem.ageSet();
        this.expected = 9;
        this.actual = ageSet.size();
        assertEquals(this.expected, this.actual);
    }

    @Test
    @DisplayName("check distinct ages from customer")
    public void ageSet(){
        Problem problem = new Problem();
        Set<Integer> integerSet = problem.ageSet();
        this.expected = problem.getCustomers().stream().map(customer -> customer.getAge()).distinct().collect(Collectors.toSet());
        this.actual = integerSet;
        assertEquals(this.expected,this.actual);
    }


}
