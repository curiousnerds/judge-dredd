package com.curiousnerds.streams.tests.test2;

import com.curiousnerds.streams.common.Customer;
import com.curiousnerds.streams.common.Data;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem extends Data {
    Function<Customer, Integer> getAgeFunction = customer -> customer.getAge(); // Your code here

    public List<Integer> customerAgeList() {
        List<Customer> customers = this.getCustomers();
        Stream<Integer> ageStream = customers.stream().map(getAgeFunction);
      return ageStream.collect(Collectors.toList());
    }
}

