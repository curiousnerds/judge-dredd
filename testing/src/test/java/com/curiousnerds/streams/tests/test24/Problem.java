package com.curiousnerds.streams.tests.test24;

import com.curiousnerds.streams.common.Data;
import com.curiousnerds.streams.common.Item;
import com.curiousnerds.streams.common.Shop;

import java.util.List;
import java.util.stream.LongStream;

public class Problem extends Data {
    LongStream longStream;

    public long getAllItemPrice() {
        List<Shop> shops = this.getShops();
        longStream= shops.stream().flatMap(shop -> shop.getItems().stream()).mapToLong(Item::getPrice);
        return longStream.sum();
    }


}

