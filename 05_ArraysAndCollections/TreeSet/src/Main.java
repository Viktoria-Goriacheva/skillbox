import java.util.Scanner;
import java.util.TreeSet;

public class Main {

  public static void main(String[] args) {
    String deals0;
    String deals1;
    TreeSet<String> email = new TreeSet<>();
    System.out.println("Выберите действие и введите одну из комманд:\n ADD \n LIST\n EXIT\n");
    email.add("grumbla@yandex.ru");
    email.add("reta234@mail.com");
    email.add("tigr1989@gmail.com");
    System.out.println(email);

    do {

      Scanner scanner = new Scanner(System.in);
      String adress = scanner.nextLine();
      deals0 = adress.split(" ")[0];

      if (deals0.equals("ADD")) {
        deals1 = adress.replaceFirst(deals0, "").trim();
        if (deals1.matches("^[(a-zA-Z-0-9-\\_\\+\\.)]+@[(a-z-A-z)]+\\.[(a-zA-z)]{2,3}$")) {
          email.add(deals1);
          TreeSet<String> newEmail = email;
          System.out.println(newEmail);
        } else {
          System.out.println("Неверно введен email");
        }
      } else if (deals0.equals("LIST")) {

        for (String list : email) {

          System.out.println(list);
        }
      } else if (deals0.equals("EXIT")) {
        System.out.println("Редактирование списка завершено");
      } else {
        System.out.println("ошибка ввода команды.");
      }

    } while (!deals0.equals("EXIT"));
  }
}
