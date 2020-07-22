package clients;

public class LegalEntity extends Client {

  public LegalEntity(String name, double sumMoney) {
    super(name, sumMoney);
  }

  @Override
  public void concludedInfo() {
    System.out.println("Пополнение происходит без комиссии, снятие с комиссией 1%");
    System.out.println("Ваш баланс = " + super.balance());
  }

  @Override
  protected double getWithdrawalComission(double amount) {
    return 1;
  }

  @Override
  protected double getDepositComission(double amount) {
    return 0;
  }
}
