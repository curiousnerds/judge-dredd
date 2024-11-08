package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.curiousnerds.framework.testing.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(LoggerExtension.class)
public class ProblemTest extends CuriousTestable {


    @Test
    @DisplayName("Check if richCustomerCondition is a lambda")
    public void findRichCustomers() {

        Solution sol = new Solution();
        List<Customer> customerList = sol.findRichCustomers();
        this.actual = AssertUtil.isLambda(sol.richCustomerCondition);
        this.expected = true;
        assertEquals(this.expected, this.actual);
    }
    @Test
    @DisplayName("check if the size is 2")
    public void findRichCustomersSize() {

        Solution sol = new Solution();
        List<Customer> customerList = sol.findRichCustomers();
        this.actual = String.valueOf(customerList.size());
        this.expected = "2";
        assertEquals(customerList.size(), 2);

    }

}
