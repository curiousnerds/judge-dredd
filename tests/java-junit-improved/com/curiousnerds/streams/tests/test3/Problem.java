package com.curiousnerds.streams.tests.test3;

import com.curiousnerds.streams.common.Customer;
import com.curiousnerds.streams.common.Data;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem extends Data {
    public List<Integer> getCustomerAgeListByAsc() {
        List<Customer> customerList = this.getCustomers();
        Stream<Integer> sortedAgeStream = customerList.stream().sorted((o1, o2) -> o1.getAge() - o2.getAge()).map(customer -> customer.getAge());
        return sortedAgeStream.collect(Collectors.toList());
    }
}

