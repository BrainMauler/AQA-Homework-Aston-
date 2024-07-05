import java.math.BigInteger;
import java.util.InputMismatchException;

public class Factorial {
    static BigInteger factorial(int x) {
        if (x < 0)
            throw new InputMismatchException("Число должно быть неотрицательным!");
        int fact = 1;
        if (x == 1)
            return BigInteger.valueOf(1);
        for (int i = 1; i <= x; i++)
            fact *= i;
        return BigInteger.valueOf(fact);
    }
}
