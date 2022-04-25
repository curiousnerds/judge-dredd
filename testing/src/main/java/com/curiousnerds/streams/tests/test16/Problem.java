package com.curiousnerds.streams.tests.test16;

import com.curiousnerds.streams.common.Customer;
import com.curiousnerds.streams.common.Data;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem extends Data {

    public Set<Integer> ageSet(){
        List<Customer> customers = this.getCustomers();
        Set<Integer> set= customers.stream().map(customer -> customer.getAge()).collect(Collectors.toSet());
        return set;
    }

}

