package com.curiousnerds.streams.tests.test1;

import com.curiousnerds.framework.testing.CuriousTestable;
import com.curiousnerds.framework.testing.LoggerExtension;
import com.curiousnerds.streams.common.AssertUtil;
import com.curiousnerds.streams.common.Customer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(LoggerExtension.class)
public class ProblemTest extends CuriousTestable{

    @Test
    @DisplayName("Check if richCustomerCondition is a lambda")
    public void findRichCustomers() {

        Problem sol = new Problem();
        List<Customer> customerList = sol.findRichCustomers();

        this.actual = String.valueOf(AssertUtil.isLambda(sol.richCustomerCondition));
        this.expected = "true";
        assertEquals(this.expected, this.actual, "check if richCustomerCondision is a lambda");
    }

    @Test
    @DisplayName("check if the size is 2")
    public void findRichCustomersSize() {

        Problem sol = new Problem();
        List<Customer> customerList = sol.findRichCustomers();
        this.actual = String.valueOf(customerList.size());
        this.expected = "2";
        assertEquals(customerList.size(), 2);

    }

}
