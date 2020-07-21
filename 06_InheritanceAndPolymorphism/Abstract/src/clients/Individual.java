package clients;

public class Individual extends Client {

  public Individual(String name, double sumMoney) {
    super(name, sumMoney);
  }

  @Override
  public void concludedInfo() {
    System.out.println("Пополнение и снятие происходит без комиссии");
    System.out.println("Ваш баланс = " + super.balance());
  }
}
