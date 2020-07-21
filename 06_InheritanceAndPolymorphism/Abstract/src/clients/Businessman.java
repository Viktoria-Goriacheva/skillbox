package clients;

public class Businessman extends Client {

  private final double COMISSION_MIN_LIMIT = 1;
  private final double COMISSION_MAX_LIMIT = 0.5;
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

  public void makeMoney(double amount) {  //положить деньги на счет
    if (amount < LIMIT) {
      sumMoney = super.balance() - (amount * COMISSION_MIN_LIMIT / 100) + amount;
    } else {
      sumMoney = super.balance() - (amount * COMISSION_MAX_LIMIT / 100) + amount;
    }
  }
}
