import java.io.File;
import java.util.Scanner;
import org.apache.commons.io.FileUtils;

public class Main {

  public static void main(String[] args) {
    Scanner console = new Scanner(System.in);
    System.out.println("Введите путь до копируемой папки: ");
    String src = console.nextLine();
    System.out.println("Введите путь до папки куда будем копировать: ");
    String dest = console.nextLine();
    try {
      File srcFolder = new File(src);
      File destFolder = new File(dest);
      FileUtils.copyDirectory(srcFolder, destFolder);
      System.out.println("Копирование завершено");
    } catch (Throwable ex) {
      ex.printStackTrace();
    }
  }
}
