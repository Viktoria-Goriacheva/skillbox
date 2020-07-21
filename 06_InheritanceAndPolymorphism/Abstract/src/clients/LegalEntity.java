package clients;

public class LegalEntity extends Client {

  private final double COMISSION = 1;

  public LegalEntity(String name, double sumMoney) {
    super(name, sumMoney);
  }

  @Override
  public void concludedInfo() {
    System.out.println("Пополнение происходит без комиссии, снятие с комиссией 1%");
    System.out.println("Ваш баланс = " + super.balance());
  }

  public void withdrawMoney(double amount) {  //снять деньги со счета
    sumMoney = super.balance() - (amount * COMISSION / 100) - amount;
  }
}
