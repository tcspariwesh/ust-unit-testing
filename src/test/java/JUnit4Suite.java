import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({TestAccount.class, TestCalculator.class})
public class JUnit4Suite {
    @BeforeClass
    public  static void runBeforeTestSuite(){
        System.out.println("test suite is running");
    }
}