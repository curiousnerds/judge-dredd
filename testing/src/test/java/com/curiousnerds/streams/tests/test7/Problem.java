package com.curiousnerds.streams.tests.test7;

import com.curiousnerds.streams.common.Customer;
import com.curiousnerds.streams.common.Data;
import com.curiousnerds.streams.common.Item;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem extends Data {
    Function<Customer, Stream<Item>> getItemStream = customer -> customer.getItems().stream();


    public List<String> itemsCustomersWantToBuy() {
        List<Customer> customerList = this.getCustomers();
        Stream<String> itemStream = customerList.stream()
                .flatMap(getItemStream)
                .map(item -> item.getName());
        return itemStream.collect(Collectors.toList());

    }
}

