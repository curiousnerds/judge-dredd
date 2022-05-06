package com.curiousnerds.streams.tests.test19;

import com.curiousnerds.streams.common.Data;

import java.util.Map;
import java.util.stream.Collectors;

public class Problem extends Data {


    public Map<Integer, Long> groupCustomerByAge() {

        Map<Integer, Long> group = this.getCustomers().stream().collect(Collectors.groupingBy(customer -> customer.getAge(),Collectors.counting()));
        return group;
    }
}

