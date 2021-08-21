public class Account implements Comparable<Account>{

  private long money;
  private String accNumber;
  private boolean isLock;

  public Account(long money, String accNumber) {
    this.money = money;
    this.accNumber = accNumber;
    isLock = false;
  }

  public synchronized boolean isLock() {
    return isLock;
  }

  public void setLock(boolean lock) {
    isLock = lock;
  }

  public void deposit(long amount) {
    money += amount;
  }

  public void withdraw(long amount) {
    money -= amount;
  }

  public long getMoney() {
    return money;
  }

  public void setMoney(long money) {
    this.money = money;
  }

  public String getAccNumber() {
    return accNumber;
  }

  public void setAccNumber(String accNumber) {
    this.accNumber = accNumber;
  }
  @Override
  public int compareTo(Account o) {
    int result = this.getAccNumber().compareTo(o.accNumber);
    if (result == 0) {
      result = ((Long)this.money).compareTo(o.getMoney());
    }
    return result;
  }

}
