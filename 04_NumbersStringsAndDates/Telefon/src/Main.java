import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    System.out.println("Введите номер телефона");
    String phone = scn.nextLine();

    String phoneModel = "^((\\+?7|8)?(( \\-)|(\\s*))?)?((\\(\\d{3}\\))|(\\d{3})|(\\s\\d{3}\\s))?(( \\-)|(\\s*))?(\\d{3}(( \\-)|(\\s*))?\\d{2}(( \\-)|(\\s*))?\\d{2})$";
    Pattern pattern = Pattern.compile(phoneModel);

    phone = phone.replaceAll("(\\D)*", "");
    int len = phone.length();
    Matcher matcher = pattern.matcher(phone);
    if (len == 10 || len == 11 && matcher.matches()) {
      phone = phone.substring(len - 10);
      phone = "7" + phone;
      System.out.println(phone);
    } else {
      System.out.println("Неверный формат номера ");
    }
  }
}

