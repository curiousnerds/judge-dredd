package com.curiousnerds.streams.tests.test1;

import com.curiousnerds.streams.common.Customer;
import com.curiousnerds.streams.common.Data;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem extends Data {

    Predicate<Customer> richCustomerCondition = customer -> customer.getBudget() > 10000;

    public List<Customer> findRichCustomers() {
      Stream<Customer> richCustomerStream = this.getCustomers().stream();
      return richCustomerStream.filter(richCustomerCondition).collect(Collectors.toList());
    }
    public List<Customer> getAllCustomers(){
        return this.getCustomers();
    }
}

