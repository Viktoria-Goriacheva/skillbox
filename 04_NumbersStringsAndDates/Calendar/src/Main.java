import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Main {

  public static void main(String[] args) {
    int day = 12;
    int month = 03;
    int myYear = 1989;
    int year = Calendar.getInstance().get(Calendar.YEAR);
    int old = year-myYear;
    Calendar c = Calendar.getInstance();
    for (int i=0; i <= old; i++){
    c.set(myYear, month-1, day);
    myYear++;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy '-' E", Locale.ENGLISH );
    System.out.println(i + " - " + dateFormat.format(c.getTime()));}
  }
}
