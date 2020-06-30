import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Loader {

  public static void main(String[] args) {
    String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";

    int v1 = text.indexOf("Вася заработал");
    int v2 = text.indexOf("руб");
    String str1 = text.substring(v1 + 14, v2)
        .trim();

    int m1 = text.indexOf("Маша - ");
    int m2 = text.lastIndexOf("руб");
    String str2 = text.substring(m1 + 6, m2)
        .trim();

    int symma = Integer.parseInt(str1) + Integer.parseInt(str2);
    System.out.println("Сумма зарблат Васи и Маши = " + symma + " руб.");
    //==================================================================================
    int sumAll = 0;
    Pattern pat = Pattern.compile("\\d+");
    Matcher matcher = pat.matcher(text);
    while (matcher.find()) {
      sumAll += Integer.parseInt(matcher.group());
    }
    System.out.println("Сумма всех зарплат = " + sumAll + " руб.");
  }
}