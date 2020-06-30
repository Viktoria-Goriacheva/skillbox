import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String text = sc.nextLine();
      String placeholder = "***";
      String textNew = text.replaceAll("\\<\\W*|\\w*\\>",placeholder);
      text = textNew;System.out.println(text);

  }
}