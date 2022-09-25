package com.curiousnerds.streams.tests.test5;

import com.curiousnerds.streams.common.Customer;
import com.curiousnerds.streams.common.Data;

import java.util.List;
import java.util.stream.Stream;

public class Problem extends Data {
    public Stream<String> getTopRichCustomersName() {
        List<Customer> customerList = this.getCustomers();
        Stream<String> top3RichCustomerStream = customerList.stream()
                .sorted((o2,o1)->o2.getBudget()- o1.getBudget())
                .limit(3)
                .map(Customer::getName);
        return top3RichCustomerStream;
    }
}

