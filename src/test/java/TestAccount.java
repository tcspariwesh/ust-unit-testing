import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.ust.Account;

public class TestAccount {

  @Rule
  public ExpectedException thrown = ExpectedException.none(); //define a monitor

  static Account account;

  @BeforeClass //use it for every time initialization per test method
  public static void initOnce() {
    System.out.println("before class called only once");
    account = new Account();
  }

  @Before //use it for every time initialization per test method
  public void initForEveryTest() {
    account = new Account();
    System.out.println("before each test ");

  }

  @After
  public  void clean() {
    account = null;
    System.out.println("clean up after each test");
  }

  @Test
  public void testReturnTrue() {
    boolean result = account.withdraw(200); //MUT-method under test
    org.junit.Assert.assertEquals(true, result);
    System.out.println("testReturnTrue");
  }

  @Test
  public void testThrowsException() {
    thrown.expect(IllegalArgumentException.class);
    account.withdraw(-200);
    System.out.println("testThrowsException");
  }

  @AfterClass
  public static void cleanFinal(){
    System.out.println("cleanFinal");
  }
}
