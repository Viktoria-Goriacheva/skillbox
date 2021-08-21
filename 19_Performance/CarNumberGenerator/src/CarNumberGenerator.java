import java.io.IOException;
import java.io.PrintWriter;

public class CarNumberGenerator implements Runnable {
  private int regionStart;
  private int regionCount;
  private  String name;
  PrintWriter writer;
  StringBuilder str;
  private char letters[] = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};

  public CarNumberGenerator(int regionStart, int regionCount, String name) {
    this.regionStart = regionStart;
    this.regionCount = regionCount;
    this.name = name;
  }




  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName());
    try {
      writer = new PrintWriter(name);
      for (int regionCode = regionStart; regionCode < regionStart + regionCount; regionCode++) {
        if (regionCode == 0) {
          continue;
        }
        str = new StringBuilder();
        for (int number = 1; number < 1000; number++) {
          for (char firstLetter : letters) {
            for (char secondLetter : letters) {
              for (char thirdLetter : letters) {
                str.append(firstLetter);
                str.append(padNumber(number, 3));
                str.append(secondLetter);
                str.append(thirdLetter);
                str.append(padNumber(regionCode, 2));
                str.append("\n");

              }
            }
          }
        }
        writer.write(str.toString());
      }
      writer.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static String padNumber(int number, int numberLength) {
    String numberStr = Integer.toString(number);
    int padSize = numberLength - numberStr.length();
    for (int i = 0; i < padSize; i++) {
      numberStr = "0".concat(numberStr);
    }
    return numberStr;
  }
}

