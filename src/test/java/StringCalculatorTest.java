import org.junit.jupiter.api.BeforeAll;

class StringCalculatorTest {

    static private StringCalculator stringCalculator;

    @BeforeAll
    static void initAll() {
        stringCalculator = new StringCalculator();
    }

}
