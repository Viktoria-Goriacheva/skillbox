package accounts;

public class BankAccount {

  private String name;
  protected double account;
// допущение - вновь созданный клиент уже имеет какую-то сумму (account) на счету.

  public BankAccount(String name, double account) {

    this.account = account;
    this.name = name;
  }

  public void withdrawMoney(double amount) {  //снять деньги со счета
    account = account - amount;
  }

  public void makeMoney(double amount) {   //положить деньги на счет
    account = account + amount;
  }

  public double balance() {
    return account;
  }

  public boolean send(BankAccount from, BankAccount to, double amount) { //перевод с первого счета на второй на указанную сумму
    from.withdrawMoney(amount);
    to.makeMoney(amount);
    return true;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getAccount() {
    return account;
  }

  public void setAccount(double account) {
    this.account = account;
  }

}
