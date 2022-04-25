package com.curiousnerds.streams.tests.test12;

import com.curiousnerds.streams.common.Customer;
import com.curiousnerds.streams.common.Data;

import java.util.List;
import java.util.stream.Collectors;

public class Problem extends Data {

    public boolean isThereAnyoneOlderThan40(){
        List<Customer> customers = this.getCustomers();
        Boolean res = customers.stream().anyMatch(x->x.getAge()>40) ;
        return res;
    }
    public List<Customer> getCustomer() {
        return this.getCustomers();
    }
}
