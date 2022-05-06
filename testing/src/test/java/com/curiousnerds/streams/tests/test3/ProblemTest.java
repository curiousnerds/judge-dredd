package com.curiousnerds.streams.tests.test3;

import com.curiousnerds.framework.testing.CuriousTestable;
import com.curiousnerds.framework.testing.LoggerExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(LoggerExtension.class)
public class ProblemTest extends CuriousTestable {


    @Test
    @DisplayName("Check if the order of customer age is in ascending")
    public void checkTheOrderOfCustomerAge() {

        Problem sol = new Problem();
        List<Integer> customerAgeListByAsc = sol.getCustomerAgeListByAsc();

        this.actual = String.valueOf(customerAgeListByAsc);
        this.expected = "[21, 22, 22, 26, 27, 28, 32, 35, 36, 38]";
        assertEquals(this.expected, this.actual);
    }
}
