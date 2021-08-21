import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class Bank {

  private Map<String, Account> accounts;
  private final Random random = new Random();
  private final long SUM_LIMIT = 50000;

  public Bank() {
    accounts = new ConcurrentHashMap<>();
    for (int i = 0; i < 100; i++) {
      String name = "accNumber - " + (i + 1);
      accounts.put(name, new Account((long) (Math.random() * 500000), name));
    }
  }

  public Bank(Map<String, Account> accounts) {
    this.accounts = accounts;
  }

  public Map<String, Account> getAccounts() {
    return accounts;
  }

  public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
      throws InterruptedException {
    Thread.sleep(1000);
    return random.nextBoolean();
  }

  public void transfer(String fromAccountNum, String toAccountNum, long amount) {
    Account fromAcc = accounts.get(fromAccountNum);
    Account toAcc = accounts.get(toAccountNum);
    synchronized (fromAcc.compareTo(toAcc) > 0 ? toAcc : fromAcc) {
      synchronized (toAcc.compareTo(fromAcc) > 0 ? fromAcc : toAcc) {
        if (fromAcc.isLock() || toAcc.isLock() || fromAcc.equals(toAcc)) {
          System.out.println("счет заблокировaн");
          return;
        }
        if (amount <= 0 || fromAcc.getMoney() < amount) {
          System.out.println("неверная сумма перечисления");
          return;
        }

        fromAcc.withdraw(amount);
        toAcc.deposit(amount);
        if (amount >= SUM_LIMIT) {
          try {
            if (isFraud(fromAccountNum, toAccountNum, amount)) {
              fromAcc.setLock(true);
              toAcc.setLock(true);
              System.out.println("счета заблокировaны");

            }
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }
  }

  public long getBalance(String accountNum) {
    return accounts.get(accountNum).getMoney();
  }

  public long getSumAllAccounts() {
    return accounts.values().stream()
        .map(Account::getMoney)
        .mapToLong(money -> money).sum();
  }
}
