package accounts;

public class Card extends BankAccount {

  private final double COMISSION = 1;


  public Card(String name, double account) {
    super(name, account);

  }

  public void withdrawMoney(double amount) {  //снять деньги со счета
    account = super.balance() - (amount * COMISSION / 100) - amount;
  }

}

