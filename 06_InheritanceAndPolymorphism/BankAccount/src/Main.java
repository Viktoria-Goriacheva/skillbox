import accounts.BankAccount;
import accounts.Card;
import accounts.Deposit;

public class Main {

  public static void main(String[] args) {
    BankAccount[] test = new BankAccount[3];
    test[0] = new Card("Вася");
    test[1] = new BankAccount("Оля");
    test[2] = new Deposit("Дуся");
    test[0].makeMoney(100);
    test[1].makeMoney(1500);
    test[2].makeMoney(4500);

    BankAccount roma = new BankAccount("бонусы");
    roma.makeMoney(1000);
    for (BankAccount person : test) {

      System.out.println(
          person.getName() + "\t " + person.send(person, roma, 10) + "\t " + person.balance());

    }
  }
}
