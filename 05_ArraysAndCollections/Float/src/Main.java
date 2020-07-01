import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

public class Main {

  final static double MAX_TEMP = 40.0;
  final static double MIN_TEMP = 32.0;
  final static int PATIENT = 30;
  final static float NORMAL_MAX_TEMP = 36.9f;
  final static float NORMAL_MIN_TEMP = 36.2f;
  private static int count = 0;


  public static double rnd(double MIN_TEMP, double MAX_TEMP) {

    double random = (Math.random() * (MAX_TEMP - MIN_TEMP) + MIN_TEMP);
    double round = new BigDecimal(random).setScale(1, RoundingMode.HALF_UP).floatValue();
    return round;
  }

  public static void main(String[] args) {

    float[] temp = new float[PATIENT];
    for (int i = 0; i < PATIENT; i++) {
      temp[i] = (float) rnd(MIN_TEMP, MAX_TEMP);
    }
    System.out.println(
        "Температуры пациентов: " + Arrays.toString(temp).replace("[", "").replace("]", "")
            .replace(",", ""));

    float sum = 0;
    for (int i = 0; i < PATIENT; i++) {
      sum = sum + temp[i];
    }
    System.out.println(
        "Средняя температура: " + new BigDecimal(sum / PATIENT).setScale(2, RoundingMode.HALF_UP)
            .floatValue());

    for (int i = 0; i < PATIENT; i++) {
      if (temp[i] >= NORMAL_MIN_TEMP && temp[i] <= NORMAL_MAX_TEMP) {
        count++;
      }
    }
    System.out.println(
        "Количество здоровых: " + count);
  }
}
