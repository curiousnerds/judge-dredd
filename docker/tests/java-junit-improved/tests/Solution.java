package tests;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution extends Data {
   public  Predicate<Customer> richCustomerCondition = customer -> customer.getBudget() > 1000;

    public List<Customer> findRichCustomers() {
      Stream<Customer> richCustomerStream = this.getCustomers().stream();
      return richCustomerStream.filter(richCustomerCondition).collect(Collectors.toList());
    }
}

