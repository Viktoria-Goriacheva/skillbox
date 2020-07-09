import java.util.Map;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;


public class Main {

  public static void main(String[] args) {
    String input0;
    String phoneModel = "^((\\+?7|8)?((-)|(\\s*))?)?((\\(\\d{3}\\))|(\\d{3})|(\\s\\d{3}\\s))?((-)|(\\s*))?(\\d{3}((-)|(\\s*))?\\d{2}((-)|(\\s*))?\\d{2})$";
    String nameModel = "^[^(LIST)][^(EXIT)]\\D+";
    TreeMap<String, String> telefonAndNames = new TreeMap<>();

    System.out.println(
        "Выберите действие и введите одну из комманд:\n Имя или номер телефона \n LIST\n EXIT\n");

    telefonAndNames.put("79152354258", "Виктория Евгеньевна Щукина");
    telefonAndNames.put("79165342536", "Сэм Винчестер");
    telefonAndNames.put("79165346737", "Агра Винчестер");
    telefonAndNames.put("76153254859", "Барроу Шенк");
    System.out.println(telefonAndNames);

    do {

      Scanner scanner = new Scanner(System.in);
      input0 = scanner.nextLine();

      if (input0.matches(phoneModel)) {
        if (telefonAndNames.containsKey(phoneVerification(input0, phoneModel))) {
          System.out.println(telefonAndNames.get(phoneVerification(input0, phoneModel)));
        } else {
          System.out.println("Такого номера нет в списке,введите ФИО контакта");

          String input1 = scanner.nextLine();
          telefonAndNames.put(phoneVerification(input0, phoneModel), input1);
        }
      } else if (input0.matches(nameModel)) {
        if (telefonAndNames.containsValue(input0)) {
          for (String key : telefonAndNames.keySet()) {
            if (input0.equals(telefonAndNames.get(key))) {
              System.out.println(key);
              continue;
            }
          }
        } else {
          System.out.println("Такого контакта нет в списке,введите телефон контакта");

          String input2 = scanner.nextLine();
          telefonAndNames.put(phoneVerification(input2, phoneModel), input0);
        }

      } else if (input0.equals("LIST")) {

        SortedSet<Map.Entry<String, String>> sortedMap = new TreeSet<>(
            (e1, e2) -> {
              int res = e1.getValue().compareTo(e2.getValue());
              return res != 0 ? res : 1;
            }
        );
        sortedMap.addAll(telefonAndNames.entrySet());

        for (Map.Entry sorted : sortedMap) {

          System.out.println(sorted.getValue() + "==>" + sorted.getKey());
        }
      } else if (input0.equals("EXIT")) {
        System.out.println("Редактирование списка завершено");
      } else {
        System.out.println("ошибка ввода");
      }

    } while (!input0.equals("EXIT"));
  }

  public static String phoneVerification(String input, String phoneModel) {

    if (input.matches(phoneModel)) {
      String phone = input.replaceAll("(\\D)*", "");
      int len = phone.length();

      if (phone.matches("^8\\d{10}$")) {
        phone = phone.substring(len - 10);
        phone = "7" + phone;
        return phone;
      } else if (phone.matches("^\\d{10}$")) {
        phone = "7" + phone;
        return phone;
      } else {
        return phone;
      }
    } else {
      return null;
    }
  }
}