package com.curiousnerds.streams.tests.test18;

import com.curiousnerds.streams.common.Customer;
import com.curiousnerds.streams.common.Data;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Problem extends Data {

    public Optional<Customer> getNamesFormatted(){
        List<Customer> customers = this.getCustomers();
        Optional<Customer> oldestCustomer = customers.stream().collect(Collectors.maxBy((o1, o2) -> o1.getAge() - o2.getAge()));
        return oldestCustomer;
    }

}

