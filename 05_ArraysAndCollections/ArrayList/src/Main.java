
import java.util.Scanner;
import java.util.ArrayList;


public class Main {

  public static void main(String[] args) {
    int deals;
    String nameOfDeal;
    int dealNumber;
    String editName;
    int deleteDeal;
    System.out.println(
        "Выберите действие и введите одну из комманд: \\1 ADD \\2 EDIT \\3 DELETE \\4 LIST\\-1 EXIT");
    ArrayList<String> toDoList = new ArrayList<>();
    toDoList.add("Поиграть в приставку");
    toDoList.add("Приготовить всем еды");
    toDoList.add("Позаниматься на тренажере");
    toDoList.add("Сделать домашку скиллбокс");
    toDoList.add("Почитать книгу");
    System.out.println(toDoList);
    do {

      Scanner scanner = new Scanner(System.in);
      deals = scanner.nextInt();

      if (deals == 1) {
        System.out.println("Введите, какое дело вы хотите добавить ");
        Scanner scanner1 = new Scanner(System.in);
        nameOfDeal = scanner1.nextLine();
        toDoList.add(nameOfDeal);
        ArrayList<String> newToDoList = toDoList;
        System.out.println(newToDoList);

      } else if (deals == 2) {
        System.out.println("Введите порядковый номер дела, которое вы хотите изменить");
        Scanner scanner2 = new Scanner(System.in);
        dealNumber = scanner2.nextInt();
        toDoList.remove(dealNumber);
        System.out.println("Введите, новое задание вместо старого");
        Scanner scanner3 = new Scanner(System.in);
        editName = scanner3.nextLine();
        toDoList.add(dealNumber, editName);
        ArrayList<String> newToDoList = toDoList;
        System.out.println(newToDoList);

      } else if (deals == 3) {
        System.out.println("Введите порядковый номер дела, которое вы хотите удалить");
        Scanner scanner4 = new Scanner(System.in);
        deleteDeal = scanner4.nextInt();
        toDoList.remove(deleteDeal);
        ArrayList<String> newToDoList = toDoList;
        System.out.println(newToDoList);

      } else if (deals == 4) {
        System.out.println(toDoList.size());
        int n = 0;
        for (int j = 0; j <= toDoList.size()-1; j++) {
          n++;
          System.out.println(n + "---" + toDoList.get(j));

        }
      }
    } while (deals != -1);
  }
}