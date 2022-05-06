package com.curiousnerds.streams.tests.test7;

import com.curiousnerds.framework.testing.CuriousTestable;
import com.curiousnerds.framework.testing.LoggerExtension;
import com.curiousnerds.streams.common.AssertUtil;
import com.curiousnerds.streams.common.Customer;
import com.curiousnerds.streams.common.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(LoggerExtension.class)
public class ProblemTest extends CuriousTestable {

    @Test
    @DisplayName("Check lambda")
    public void checkLambda() {
        Problem problem = new Problem();

        this.expected = AssertUtil.isLambda(problem.getItemStream);

        this.actual = true;
        assertEquals(this.expected, this.actual);
    }
     @Test
     @DisplayName("Check the items customer wants to buy")
    public void itemsCustomersWantToBuy() {
         Problem problem = new Problem();
         List<String> strings = problem.itemsCustomersWantToBuy();

         /**
         * Create a stream with items' names stored in {@link Customer.wantToBuy}
         * Use {@link Stream#flatMap} to create a stream from each element of a stream.
         */
        Function<Customer, Stream<Item>> getItemStream = null;
        Stream<String> itemStream = null;
         this.expected = "[small table, plate, fork, ice cream, screwdriver, cable, earphone, onion, ice cream, crisps, chopsticks, cable, speaker, headphone, saw, bond, plane, bag, cold medicine, chair, desk, pants, coat, cup, plate, fork, spoon, ointment, poultice, spinach, ginseng, onion]";
         this.actual=String.valueOf(strings);
         assertEquals(this.expected, this.actual);

    }



}
