package com.curiousnerds.streams.tests.test10;

import com.curiousnerds.streams.common.Customer;
import com.curiousnerds.streams.common.Data;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Problem extends Data {

    public Optional<Customer> test(){
        List<Customer> customers = this.getCustomers();
        Comparator<Customer> comparator = (o1, o2)->o1.getAge()-o2.getAge();
        Optional<Customer> youngestCustomer = customers.stream().min(comparator) ;
        return youngestCustomer;
    }
    public List<Customer> getCustomer() {
        return this.getCustomers();
    }
}
