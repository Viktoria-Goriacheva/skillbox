import clients.Businessman;
import clients.Client;
import clients.Individual;
import clients.LegalEntity;

public class Main {

  public static void main(String[] args) {
    Client[] clients = new Client[3];
    clients[0] = new LegalEntity("Вася", 100);
    clients[1] = new Businessman("Оля", 10000);
    clients[2] = new Individual("Дуся", 8500);

    for (Client person : clients) {
      person.concludedInfo();
      person.withdrawMoney(50);
      person.makeMoney(50);
      person.makeMoney(5000);
      System.out.println(person.balance());
    }
  }
}
