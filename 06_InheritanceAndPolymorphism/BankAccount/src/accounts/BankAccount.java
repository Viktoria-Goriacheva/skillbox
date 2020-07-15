package accounts;

public class BankAccount {

  private String name;
  protected double sumMoney;


  public BankAccount(String name) {

    this.name = name;

  }

  public void withdrawMoney(double amount) {  //снять деньги со счета
    sumMoney = sumMoney - amount;
  }

  public void makeMoney(double amount) {   //положить деньги на счет
    sumMoney = sumMoney + amount;
  }

  public double balance() {
    return sumMoney;
  }

  public boolean send(BankAccount from, BankAccount to,
      double amount) { //перевод с первого счета на второй на указанную сумму
    from.withdrawMoney(amount);
    to.makeMoney(amount);
    return true;
  }

  public String getName() {
    return name;
  }

  public double getSumMoney() {
    return sumMoney;
  }

}
