import java.util.Scanner;
import java.util.ArrayList;

public class Main {

  public static void main(String[] args) {
    String deals0;
    int number;
    String deals1;
    String deals2;
    String deals3;
    System.out.println(
        "Выберите действие и введите одну из комманд:\n ADD \n EDIT\n DELETE\n LIST\n EXIT\n");
    ArrayList<String> toDoList = new ArrayList<>();
    toDoList.add("Поиграть в приставку");
    toDoList.add("Приготовить всем еды");
    toDoList.add("Позаниматься на тренажере");
    toDoList.add("Сделать домашку скиллбокс");
    toDoList.add("Почитать книгу");
    System.out.println(toDoList);

    do {

      Scanner scanner = new Scanner(System.in);
      String line = scanner.nextLine();
      deals0 = line.split(" ")[0];
      deals3 = line.replaceFirst(deals0, "").trim();

      if (deals0.equals("ADD")) {

        if (line.matches("^\\D+\\s+\\D(.+)")) {
          toDoList.add(deals3);
          ArrayList<String> newToDoList = toDoList;
          System.out.println(newToDoList);
        } else if (line.matches("^\\D+\\s+\\d+\\s+(.+)")) {
          deals1 = line.split(" ")[1];
          number = Integer.parseInt(deals1);
          deals2 = line.replaceFirst(deals0, "").replaceFirst(deals1, "").trim();
          toDoList.add(number, deals2);
          ArrayList<String> newToDoList = toDoList;
          System.out.println(newToDoList);
        } else {
          System.out.println("ошибка ввода,введите новое дело после команды.");
        }

      } else if (deals0.equals("EDIT")) {
        if (line.matches("^\\D+\\s+\\d+\\s+(.+)")) {
          deals1 = line.split(" ")[1];
          number = Integer.parseInt(deals1);
          toDoList.remove(number);
          deals2 = line.replaceFirst(deals0, "").replaceFirst(deals1, "").trim();
          toDoList.add(number, deals2);
          ArrayList<String> newToDoList = toDoList;
          System.out.println(newToDoList);
        } else {
          System.out.println("ошибка ввода,введите новое дело после команды.");
        }

      } else if (deals0.equals("DELETE")) {
        if (line.matches("^\\D+\\s+\\d+")) {
          deals1 = line.split(" ")[1];
          number = Integer.parseInt(deals1);
          toDoList.remove(number);
          ArrayList<String> newToDoList = toDoList;
          System.out.println(newToDoList);
        } else {
          System.out.println("ошибка ввода,введите новое дело после команды.");
        }
      } else if (deals0.equals("LIST")) {
        int n = 0;
        for (int j = 0; j <= toDoList.size() - 1; j++) {
          n++;
          System.out.println(n + "---" + toDoList.get(j));
        }
      } else if (deals0.equals("EXIT")) {
        System.out.println("Редактирование списка завершено");
      } else {
        System.out.println("ошибка ввода команды.");
      }
    } while (!deals0.equals("EXIT"));
  }
}