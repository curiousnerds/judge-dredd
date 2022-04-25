package com.curiousnerds.streams.tests.test5;

import com.curiousnerds.streams.common.Customer;
import com.curiousnerds.streams.common.Data;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem extends Data {
    public Stream<String> getCustomerAgeListByDesc() {
        List<Customer> customerList = this.getCustomers();
        Stream<String> top3RichCustomerStream = customerList.stream().sorted((o2,o1)->o1.getBudget()- o2.getBudget()).limit(3).map(Customer::getName);
        return top3RichCustomerStream;
    }
}

