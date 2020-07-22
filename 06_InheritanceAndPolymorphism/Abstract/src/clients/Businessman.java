package clients;

public class Businessman extends Client {

  private final double LIMIT = 1000;

  public Businessman(String name, double sumMoney) {
    super(name, sumMoney);
  }

  @Override
  public void concludedInfo() {
    System.out.println("Снятие происходит без комиссии. "
        + "Пополнение с комиссией 1%, если сумма меньше 1000 рублей. "
        + "И с комиссией 0,5%, если сумма больше либо равна 1000 рублей.");
    System.out.println("Ваш баланс = " + super.balance());
  }

  @Override
  protected double getWithdrawalComission(double amount) {
    return 0;
  }

  @Override
  protected double getDepositComission(double amount) {
    if (amount < LIMIT) {
      return 1;
    } else {
      return 0.5;
    }
  }
}
