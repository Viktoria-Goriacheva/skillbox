package accounts;

import java.util.Date;

public class Deposit extends BankAccount {

  private Date dateLastApplication;
  private int timeDifference;

  public Deposit(String name) {
    super(name);
    dateLastApplication = new Date();
  }

  public void withdrawMoney(double amount) {  //снять деньги со счета
    Date newTime = new Date();
    timeDifference =
        (int) (newTime.getTime() - dateLastApplication.getTime()) / (24 * 60 * 60 * 1000);
    if (timeDifference > 30) {
      sumMoney = sumMoney - amount;
    } else {
      System.out.println("Месяц еще не прошел");
    }
  }

  public boolean send(BankAccount from, BankAccount to, double amount) {
    if (timeDifference > 30) {
      from.withdrawMoney(amount);
      to.makeMoney(amount);
      return true;
    } else {
      return false;
    }
  }

  public void makeMoney(double amount) {   //положить деньги на счет
    sumMoney = sumMoney + amount;
    dateLastApplication = new Date();
  }

  public Date getDateLastApplication() {
    return dateLastApplication;
  }
}


