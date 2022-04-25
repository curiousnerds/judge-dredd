package com.curiousnerds.streams.tests.test15;

import com.curiousnerds.streams.common.Customer;
import com.curiousnerds.streams.common.Data;

import java.util.List;
import java.util.stream.Collectors;

public class Problem extends Data {

    public List<String> nameList(){
        List<Customer> customers = this.getCustomers();
        List<String> list= customers.stream().map(customer -> customer.getName()).collect(Collectors.toList());
        return list;
    }

}

