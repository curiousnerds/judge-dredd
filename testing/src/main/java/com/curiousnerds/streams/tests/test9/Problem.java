package com.curiousnerds.streams.tests.test9;

import com.curiousnerds.streams.common.Customer;
import com.curiousnerds.streams.common.Data;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Problem extends Data {

    Comparator<Integer> comparator = Comparator.naturalOrder();

    public Optional<Integer> richestCustomer(){
        List<Customer> customers = this.getCustomers();

        /**
         * Find the richest customer's budget by using {@link Stream#max} and {@link Comparator#naturalOrder}
         * Don't use {@link Stream#sorted}
         */

        Optional<Integer> richestCustomer = customers.stream()
                .map(customer -> customer.getBudget())
                .max(comparator);

        return richestCustomer;
    }
}
