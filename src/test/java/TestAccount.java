import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.ust.Account;

public class TestAccount {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

   Account account;

  @Before //use it for every time initialization per test method
  public  void init() {
    account = new Account();
  }

  @After
  public void clean() {
    account = null;
    System.out.println("clean up");
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
