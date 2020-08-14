import java.util.HashMap;

public class CustomerStorage {

  private HashMap<String, Customer> storage;

  public CustomerStorage() {
    storage = new HashMap<>();
  }

  public void addCustomer(String data) {
    String[] components = data.split("\\s+");
    if (components.length != 4) {
      throw new IllegalArgumentException("Wrong format. Correct format: \n" +
          "add Василий Петров vasily.petrov@gmail.com +79215637722");
    } else if (!components[2]
        .matches("^[(a-zA-Z-0-9-\\_\\+\\.)]+@[(a-z-A-z)]+\\.[(a-zA-z)]{2,3}$")) {
      throw new IllegalArgumentException("Wrong format eMail. Correct format: \n" +
          "vasily.petrov@gmail.com");
    } else if (!components[3].matches("^(\\+7)\\d{10}$")) {
      throw new IllegalArgumentException("Wrong format phone. Correct format: \n" +
          "+79215637722");
    }
    String name = components[0] + " " + components[1];
    storage.put(name, new Customer(name, components[3], components[2]));
  }

  public void listCustomers() {
    storage.values().forEach(System.out::println);
  }

  public void removeCustomer(String name) throws ArrayIndexOutOfBoundsException {
    String[] components = name.split("\\s+");
    if (components.length != 2) {
      throw new IllegalArgumentException("Wrong format. Correct format: \n" +
          "remove Василий Петров");
    }
    storage.remove(name);
  }

  public int getCount() {
    return storage.size();
  }
}