import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceTest {
    CalculatorService calculatorService = new CalculatorService();

    @Test
    public void plus() {
        int actual = calculatorService.sum(5, 5);
        assertEquals(10, actual);
    }

    @Test
    public void minus(int num1, int num2) {
        int actual = calculatorService.subtract(5, 5);
        assertEquals(0, actual);
    }

    @Test
    public void multiply(int num1, int num2) {
        int actual = calculatorService.subtract(5, 5);
        assertEquals(25, actual);
    }

    public void divide(int num1, int num2) {
        int actual = calculatorService.subtract(5, 5);
        assertEquals(1, actual);
    }
}
