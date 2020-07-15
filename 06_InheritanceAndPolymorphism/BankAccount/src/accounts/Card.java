package accounts;

public class Card extends BankAccount {

  private final double COMISSION = 1;


  public Card(String name) {
    super(name);

  }

  public void withdrawMoney(double amount) {  //снять деньги со счета
    sumMoney = super.balance() - (amount * COMISSION / 100) - amount;
  }

}

