package com.curiousnerds.streams.tests.test17;

import com.curiousnerds.framework.testing.CuriousTestable;
import com.curiousnerds.framework.testing.LoggerExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(LoggerExtension.class)
public class ProblemTest extends CuriousTestable {

    @Test
    @DisplayName("get names formatted [nam1,name2] ")
    public void nameInCsv() {

        /**
         * Create a csv string of customer names in brackets "[]" by using {@link Collectors#joining}
         */
        Problem problem = new Problem();
        this.expected = "[Joe,Steven,Patrick,Diana,Chris,Kathy,Alice,Andrew,Martin,Amy]";
        this.actual = problem.getNamesFormatted();
        assertEquals(this.expected, this.actual);
    }
}
