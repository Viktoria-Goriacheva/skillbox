package clients;

public abstract class Client {

  private String name;
  protected double sumMoney;

  public Client(String name, double sumMoney) {

    this.name = name;
    this.sumMoney = sumMoney;

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

  public String getName() {
    return name;
  }

  public double getSumMoney() {
    return sumMoney;
  }

  public abstract void concludedInfo();
}
