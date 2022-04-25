package com.curiousnerds.streams.tests.test8;

import com.curiousnerds.streams.common.Customer;
import com.curiousnerds.streams.common.Data;

import java.util.List;

public class Problem extends Data {
    public long howmanywanted(){
        List<Customer> customers = this.getCustomers();
        return customers.stream().flatMap(customer->customer.getItems().stream()).count();
    }
}
