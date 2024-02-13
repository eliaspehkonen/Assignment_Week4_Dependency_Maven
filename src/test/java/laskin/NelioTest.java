package laskin;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NelioTest {

    private Laskin laskin = new Laskin();
    private final double DELTA = 0.001;

    @ParameterizedTest(name = "Square root of {0} is {1}")
    @CsvSource({ "0, 0", "1, 1", "2, 1.4142135623730951", "4, 2", "5, 2.23606797749979", "6, 2.449489742783178" })
    public void testSquareroot(double input, double expected) {
        laskin.squareroot(input);
        assertEquals(expected, laskin.returnResult(), 0.00000001, "Square root operation is incorrect");
    }

    @ParameterizedTest(name = "Square root of negative number {0}")
    @CsvSource({ "-1", "-2", "-3", "-4" })
    public void testSquarerootNegative(double input) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> laskin.squareroot(input));
        assertEquals("Cannot take the square root of a negative number", exception.getMessage());
    }
}
