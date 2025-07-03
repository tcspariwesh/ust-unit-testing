import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import com.ust.Calculator;
public class TestCalculator {
    @Rule
    public ExpectedException monitor = ExpectedException.none();

    Calculator calculator = new Calculator();
    @Test
    public void testDivideforException(){
        monitor.expect(IllegalArgumentException.class);
        calculator.divide(100  , 0);
    }

}