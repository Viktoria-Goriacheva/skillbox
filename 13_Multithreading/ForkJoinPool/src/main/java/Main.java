import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ForkJoinPool;

public class Main {

  private static final String URL = "https://skillbox.ru/";

  public static void main(String[] args) {

    int processor = Runtime.getRuntime().availableProcessors();
    Reader reader = new Reader(URL);
    System.out.println("Сканирование сайта...");
    Set<String> map = new ForkJoinPool(processor).invoke(reader);
    System.out.println("Печать карты сайта в файл...");
    writeFile(map);
    System.out.println("Карта создана.");
  }

  private static void writeFile(Set<String> maps) {
    try {
      List<String> map = new ArrayList<>(maps);
      Collections.sort(map);
      List<String> newStrings = new LinkedList<>();
      String fileName = "src/main/resources/map";
      Path filePath = Paths.get(fileName);

      for (String string : map) {
        StringBuilder builder = new StringBuilder();
        string = string.substring(string.indexOf("skill"));
        String[] split = string.split("/");

        builder.append("\t".repeat(split.length));
        builder.append(string);
        builder.insert(builder.indexOf("s"), "https://");
        newStrings.add(builder.toString());
      }

      for (int i = 0; i < newStrings.size(); i++) {
        String string = newStrings.get(i);
        string = string.substring(1);
        newStrings.set(i, string);
      }
      Files.write(filePath, newStrings);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
