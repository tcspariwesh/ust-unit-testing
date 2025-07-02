import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.ust.Account;

public class TestAccount {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  static Account account;
  @BeforeClass //use it for one time initialization per test class
  public static void init() {
    account = new Account();
    
  }

  @Test
  public void testReturnTrue() {
    boolean result = account.withdraw(200);
    org.junit.Assert.assertEquals(true, result);
  }

  @Test
  public void testThrowsException() {
    thrown.expect(IllegalArgumentException.class);
    account.withdraw(-200);
  }
}