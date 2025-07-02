
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.ust.Account;

public class TestAccount {
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void testReturnTrue() {
        Account account = new Account();
        boolean result = account.withdraw(200);
        org.junit.Assert.assertEquals(true, result);
    }
     @Test
    public void testThrowsException() {
        thrown.expect(IllegalArgumentException.class);
        Account account = new Account();
        account.withdraw(-200);
    }
}