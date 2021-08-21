import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BankTest extends TestCase {

  private Bank bank;
  private Map<String, Account> accounts;

  @Before
  @Override
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    accounts = new ConcurrentHashMap<>();
    accounts.put("name-1", new Account(10000, "name-1"));
    accounts.put("name-2", new Account(20000, "name-2"));
    accounts.put("name-3", new Account(60000, "name-3"));
    accounts.put("name-4", new Account(150000, "name-4"));
    bank = new Bank(accounts);
  }

  @Test
  public void testTransfer() {
    Account fromAcc = accounts.get("name-3");
    Account toAcc = accounts.get("name-4");
    bank.transfer("name-3", "name-4", 20000);
    long actual1 = fromAcc.getMoney();
    long expected1 = 40000;
    assertEquals(expected1, actual1);
    long actual2 = toAcc.getMoney();
    long expected2 = 170000;
    assertEquals(expected2, actual2);
    toAcc.setLock(true); // счет заблокирован
    bank.transfer("name-3", "name-4", 5000);
    long actual3 = fromAcc.getMoney();
    long expected3 = 40000;
    assertEquals(expected3, actual3);
    long actual4 = toAcc.getMoney();
    long expected4 = 170000;
    assertEquals(expected4, actual4);
    toAcc.setLock(false);
  }

  @Test
  public void testGetSumAllAccounts() {
    long actual = bank.getSumAllAccounts();
    long expected = 150000 + 60000 + 20000 + 10000;
    assertEquals(expected, actual);
  }

  @Test
  public void testGetBalance() {
    long actual = bank.getBalance("name-2");
    long expected = 20000;
    assertEquals(expected, actual);
  }
}
