package com.curiousnerds.streams.tests.test1;

import com.curiousnerds.framework.testing.CuriousTestable;
import com.curiousnerds.framework.testing.LoggerExtension;
import com.curiousnerds.streams.common.AssertUtil;
import com.curiousnerds.streams.common.Customer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(LoggerExtension.class)
public class ProblemTest extends CuriousTestable{

    @Test
    @DisplayName("Check if richCustomerCondition is a lambda")
    public void findRichCustomers() {

        Problem sol = new Problem();
        List<Customer> customerList = sol.findRichCustomers();

        this.actual = AssertUtil.isLambda(sol.richCustomerCondition);
        this.expected = true;
        assertEquals(this.expected, this.actual);
    }

    @Test
    @DisplayName("check if the size is 2")
    public void findRichCustomersSize() {

        Problem sol = new Problem();
        List<Customer> customerList = sol.findRichCustomers();
        this.actual = customerList.size();
        this.expected = 2;
        assertEquals(customerList.size(), actual);

    }
    @Test
    @DisplayName("check if the richest customers are one of the given")
    public void checkIfrichestCustomersArePartOfGiven() {

        Problem sol = new Problem();
        List<Customer> customerList = sol.findRichCustomers();
        this.actual = customerList;
        this.expected = new ArrayList<Customer>(){{add(sol.getAllCustomers().get(3));
            add(sol.getCustomers().get(7));}};
        assertEquals(this.expected, this.actual);

    }

}
