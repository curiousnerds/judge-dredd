package com.curiousnerds.streams.tests.test11;

import com.curiousnerds.streams.common.Customer;
import com.curiousnerds.streams.common.Data;

import java.util.List;
import java.util.Optional;

public class Problem extends Data {


    public Optional<Customer> findFirstCustomer() {
        List<Customer> customers = this.getCustomers();
        Optional<Customer> firstEverCustomer = customers.stream().findFirst();
        return firstEverCustomer;
    }
}
