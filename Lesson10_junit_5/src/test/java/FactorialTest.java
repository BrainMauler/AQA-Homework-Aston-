import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialTest {

    Factorial Fact = new Factorial();

    @Test
    public void factorialTestOne() {
        BigInteger result = Fact.factorial(10);
        assertEquals(BigInteger.valueOf(3628800), result);
    }

    @Test
    public void factorialTestTwo() {
        InputMismatchException thrown = assertThrows(InputMismatchException.class, () -> {
            BigInteger result = Fact.factorial(-3);
        });
        assertEquals("Число должно быть неотрицательным!", thrown.getMessage());
    }

    @Test
    public void factorialTestThree() {
        BigInteger result = Fact.factorial(1);
        assertEquals(BigInteger.valueOf(1), result);
    }

    @Test
    public void factorialTestFour() {
        BigInteger result = Fact.factorial(0);
        assertEquals(BigInteger.valueOf(1), result);
    }

}
