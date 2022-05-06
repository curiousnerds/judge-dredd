package com.curiousnerds.streams.tests.test24;

import com.curiousnerds.framework.testing.CuriousTestable;
import com.curiousnerds.framework.testing.LoggerExtension;
import com.curiousnerds.streams.common.Customer;
import com.curiousnerds.streams.common.Shop;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(LoggerExtension.class)
public class ProblemTest extends CuriousTestable {

    @Test
    @DisplayName("Items that are not all sell count")
    public void itemsNotOnSale() {
        Problem problem = new Problem();
        Stream<Customer> customerStream =problem.getCustomers().stream();
        Stream<Shop> shopStream = problem.getShops().stream();

        /**
         * Create a set of item names that are in {@link Customer.wantToBuy} but not on sale in any shop.
         */
        List<String> itemListOnSale = shopStream.flatMap(shop -> shop.getItems().stream()).map(item -> item.getName()).collect(Collectors.toList());
        Set<String> itemSetNotOnSale = customerStream.flatMap(customer -> customer.getItems().stream()).map(item -> item.getName()).filter(itemName -> !itemListOnSale.contains(itemName)).collect(Collectors.toSet());
        this.expected=3;
        this.actual= itemSetNotOnSale.size();
        assertEquals(this.expected, this.actual);
        //assertThat(itemSetNotOnSale, hasSize(3));
//        assertThat(itemSetNotOnSale, hasItems("bag", "pants", "coat"));
    }
//    @Test
//    @DisplayName("Items that are on sell")
//    public void itemsNotOnSale() {
//        Stream<Customer> customerStream = this.mall.getCustomerList().stream();
//        Stream<Shop> shopStream = this.mall.getShopList().stream();
//
//        /**
//         * Create a set of item names that are in {@link Customer.wantToBuy} but not on sale in any shop.
//         */
//        List<String> itemListOnSale = null;
//        Set<String> itemSetNotOnSale = null;
//
//        assertThat(itemSetNotOnSale, hasSize(3));
//        assertThat(itemSetNotOnSale, hasItems("bag", "pants", "coat"));
//    }
}
