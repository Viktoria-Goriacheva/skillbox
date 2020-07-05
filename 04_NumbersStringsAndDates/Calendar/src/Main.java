import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Main {

  public static void main(String[] args) {
    int day = 12;
    int month = 03;
    int myYear = 1989;
    int year = Calendar.getInstance().get(Calendar.YEAR);
    int old = year - myYear;
    Calendar c = Calendar.getInstance();
    Date currentDate = new Date();
    c.set(Calendar.MONTH, month - 1);
    c.set(Calendar.DATE, day);
    Date dateOne = c.getTime();
    int i = -1;
    while (currentDate.after(dateOne) && myYear <= year) {

      c.set(myYear, month - 1, day);
      myYear++;
      SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy '-' E", Locale.ENGLISH);
      i++;
      System.out.println(i + " - " + dateFormat.format(c.getTime()));

    }
  }
}

