package com.curiousnerds.streams.tests.test4;

import com.curiousnerds.streams.common.Customer;
import com.curiousnerds.streams.common.Data;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem extends Data {
    public List<Integer> getCustomerAgeListByDesc() {
        List<Customer> customerList = this.getCustomers();
        Stream<Integer> sortedAgeStream = customerList.stream().sorted((o1, o2) -> o2.getAge() - o1.getAge()).map(customer -> customer.getAge());
      return  sortedAgeStream.collect(Collectors.toList());
    }
}

