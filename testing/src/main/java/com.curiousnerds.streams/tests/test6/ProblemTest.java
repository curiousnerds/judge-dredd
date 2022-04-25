//package com.curiousnerds.streams.tests.test6;
//
//import com.curiousnerds.framework.testing.CuriousTestable;
//import com.curiousnerds.framework.testing.LoggerExtension;
//import com.curiousnerds.streams.common.Customer;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@ExtendWith(LoggerExtension.class)
//public class ProblemTest extends CuriousTestable {
//
//    @Test
//    @DisplayName("Get all distinct age of customers")
//    public void distinctAge() {
//        Problem sol = new Problem();
//        List<Integer> listOfDistinctAge = sol.getListOfDistinctAge();
//        this.actual = String.valueOf(listOfDistinctAge);
//        this.expected = "[22, 27, 28, 38, 26, 32, 35, 21, 36]";
//        assertEquals(this.expected, this.actual);
//    }
//}
