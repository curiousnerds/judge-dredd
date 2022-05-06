package com.curiousnerds.streams.tests.test17;

import com.curiousnerds.streams.common.Customer;
import com.curiousnerds.streams.common.Data;

import java.util.List;
import java.util.stream.Collectors;

public class Problem extends Data {

    public String getNamesFormatted(){
        List<Customer> customers = this.getCustomers();
        String stringFormatted = customers.stream().map(customer -> customer.getName()).collect(Collectors.joining(",", "[", "]"));
        return stringFormatted;
    }

}

