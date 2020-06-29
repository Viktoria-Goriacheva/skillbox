import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String text = sc.nextLine();

    int bracket = text.length() - text.replaceAll("<", "").length();

    for (int i = 1; i <= bracket; i++) {
      int firstIndex = text.indexOf("<");
      int secondIndex = text.indexOf(">");
      String placeholder = "***";
      String index = text.substring(firstIndex, secondIndex + 1);
      String textNew = text.replaceAll(index,placeholder);
      text = textNew;
    }
    System.out.println(text);
  }
}
