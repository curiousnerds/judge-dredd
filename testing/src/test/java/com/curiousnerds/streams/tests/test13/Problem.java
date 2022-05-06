package com.curiousnerds.streams.tests.test13;


import com.curiousnerds.streams.common.Customer;
import com.curiousnerds.streams.common.Data;

import java.util.List;

public class Problem extends Data {

    public boolean test(){
        List<Customer> customers = this.getCustomers();
        Boolean is= customers
                .stream()
                .allMatch(c->c.getAge()>=20);
        return is;
    }
    public List<Customer> getCustomer() {
        return this.getCustomers();
    }
}

