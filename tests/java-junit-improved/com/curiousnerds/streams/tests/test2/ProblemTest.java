package com.curiousnerds.streams.tests.test2;

import com.curiousnerds.framework.testing.CuriousTestable;
import com.curiousnerds.framework.testing.LoggerExtension;
import com.curiousnerds.streams.common.AssertUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(LoggerExtension.class)
public class ProblemTest extends CuriousTestable {

    @Test
    @DisplayName("Check if getAgeFunction is a lambda")
    public void findRichCustomers() {

        Problem sol = new Problem();
        sol.oldCustomersList();

        this.actual = String.valueOf(AssertUtil.isLambda(sol.getAgeFunction));
        this.expected = "true";
        assertEquals(this.expected, this.actual);
    }
    @Test
    @DisplayName("check old customer size is 10")
    public void oldCustomerSize() {
        Problem sol = new Problem();
        List<Integer> integers = sol.oldCustomersList();

        this.actual = String.valueOf(integers.size());
        this.expected = String.valueOf(10);
        assertEquals(this.expected, this.actual);

    }
    @Test
    @DisplayName("check old customer ages are [22, 27, 28, 38, 26, 22, 32, 35, 21, 36]")
    public void checkOldCustomerAges() {
        Problem sol = new Problem();
        List<Integer> ages = sol.oldCustomersList();

        this.actual = String.valueOf(ages);
        this.expected = String.valueOf("[22, 27, 28, 38, 26, 22, 32, 35, 21, 36]");
        assertEquals(ages.toString(), "[22, 27, 28, 38, 26, 22, 32, 35, 21, 36]");

    }

}
