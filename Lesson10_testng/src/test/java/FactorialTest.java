import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigInteger;
import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialTest {
    @Test
    public void factorialTest() {
        Factorial Fact = new Factorial();
        Assert.assertEquals(Factorial.factorial(0), BigInteger.valueOf(1));
        Assert.assertEquals(Factorial.factorial(1), BigInteger.valueOf(1));
        Assert.assertEquals(Factorial.factorial(10), BigInteger.valueOf(3628800));
        InputMismatchException thrown = assertThrows(InputMismatchException.class, () -> {
            BigInteger result = Fact.factorial(-3);
        });
        assertEquals("Число должно быть неотрицательным!", thrown.getMessage());
    }
}
