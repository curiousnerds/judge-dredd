package com.curiousnerds.streams.tests.test22;

import com.curiousnerds.streams.common.Data;

import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class Problem extends Data {
    IntStream ageStream = null;

    public OptionalDouble calculateAvgCustomerAge() {
        ageStream = this.getCustomers().stream().mapToInt(customer -> customer.getAge());
        OptionalDouble result= ageStream.average();
        return result;
    }

}

