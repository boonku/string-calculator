import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringCalculatorTest {

    static private StringCalculator stringCalculator;

    @BeforeAll
    static void initAll() {
        stringCalculator = new StringCalculator();
    }

    @Test
    void When_SumOfEmptyString_Expect_Zero() {
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    void When_SumOfOne_Expect_One() {
        assertEquals(1, stringCalculator.add("1"));
    }

    @Test
    void When_SumOfOneAndTwo_Expect_Three() {
        assertEquals(3, stringCalculator.add("1,2"));
    }

    @Test
    void When_SumOfManyNumbers_Expect_SumOfNumbers() {
        assertEquals(6, stringCalculator.add("1,2,3"));
        assertEquals(53, stringCalculator.add("1,2,5,10,20,15"));
    }

}
