import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(LoggerExtension.class)
public class SolutionTest {

    public  Integer  actual;
    public  Integer expected;

    @Test
    @DisplayName("What ever passes")
    public void anem() {
        Solution solution = new Solution();
        solution.checkSqr(3);
        this.actual = solution.checkSqr(3);
        this.expected = 9;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("What ever  fails")
    public void anems() {
        Solution solution = new Solution();
        this.actual = solution.checkSqr(7);
        this.expected = 4;
        assertEquals(expected, actual);
    }

}
