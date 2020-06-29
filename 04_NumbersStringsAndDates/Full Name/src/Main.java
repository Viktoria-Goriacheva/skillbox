import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String fullName = sc.nextLine();
    int space = fullName.length() - fullName.replaceAll(" ", "").length();
    int firstIndex = fullName.indexOf(" ");
    int lastIndex = fullName.lastIndexOf(" ");

    if (lastIndex != firstIndex && space <= 2) {
      String firstName = fullName.substring(0, firstIndex);
      String lastName = fullName.substring(firstIndex + 1, lastIndex);
      String otherName = fullName.substring(lastIndex + 1);

      System.out.println("Фамилия: " + firstName);
      System.out.println("Имя: " + lastName);
      System.out.println("Отчество: " + otherName);

    } else if (lastIndex == firstIndex && space <= 2) {
      String firstName = fullName.substring(0, firstIndex);
      String lastName = fullName.substring(firstIndex + 1);
      System.out.println("Фамилия: " + firstName);
      System.out.println("Имя: " + lastName);
    } else {
      System.out.println("некорректный ввод ФИО");
    }
  }
}

