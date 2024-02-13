package laskin;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LaskinTest {

    private Laskin laskin = new Laskin();
    private final double DELTA = 0.001;

    @BeforeEach
    public void clearCalculator() {
        laskin.setZero();
    }

    @Test
    public void testAdd() {
        laskin.add(1);
        laskin.add(2);
        assertEquals(3, laskin.returnResult(), DELTA, "Numbers 1 and 2 summation is wrong");
    }

    @Test
    public void testSubtract() {
        laskin.add(10);
        laskin.subtract(2);
        assertEquals(8, laskin.returnResult(), DELTA, "Number 10 and 2 difference is wrong");
    }

    @Test
    @DisplayName("Test division: 8 / 2")
    public void testDivision() {
        laskin.add(8);
        laskin.divide(2);
        assertEquals(4, laskin.returnResult(), DELTA, "Division of 8 by 2 is wrong");
    }

    @Test
    @DisplayName("Test division by zero")
    public void testDivisionZero() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> laskin.divide(0));
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}
