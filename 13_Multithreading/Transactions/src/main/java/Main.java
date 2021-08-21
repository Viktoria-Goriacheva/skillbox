import java.util.Map;
import java.util.Random;

public class Main {

  private static final int PROCESSORS = Runtime.getRuntime().availableProcessors();

  public static void main(String[] args) {
    Bank bank = new Bank();
    Random random = new Random();
    Map<String, Account> accounts = bank.getAccounts();
    for (int i = 0; i < PROCESSORS; i++) {
      new Thread(() -> {
        for (int j = 0; j < 1_000_000; j++) {
          System.out.println("ДО ---" + bank.getSumAllAccounts());
          Account from = accounts.get(accounts.keySet().toArray()[random.nextInt(accounts.size())]);
          Account to = accounts.get(accounts.keySet().toArray()[random.nextInt(accounts.size())]);
          bank.transfer(from.getAccNumber(), to.getAccNumber(), 31000 + random.nextInt(20_000));
          System.out.println("ПОСЛЕ ---" + bank.getSumAllAccounts());
        }
      }).start();

    }
  }
}
