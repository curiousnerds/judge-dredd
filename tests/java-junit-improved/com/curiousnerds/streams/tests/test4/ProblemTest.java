package com.curiousnerds.streams.tests.test4;

import com.curiousnerds.framework.testing.CuriousTestable;
import com.curiousnerds.framework.testing.LoggerExtension;
import com.curiousnerds.streams.common.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(LoggerExtension.class)
public class ProblemTest extends CuriousTestable {

    @Test
    @DisplayName("Check if the order of customer age is in descending")
    public void checkTheOrderOfCustomerAge() {

        Problem sol = new Problem();
        List<Integer> customerAgeListByDesc = sol.getCustomerAgeListByDesc();

        this.actual = String.valueOf(customerAgeListByDesc);
        this.expected = "[38, 36, 35, 32, 28, 27, 26, 22, 22, 21]";
        assertEquals(this.expected, this.actual);
    }
}
