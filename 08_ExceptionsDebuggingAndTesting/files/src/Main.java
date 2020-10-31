import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
public class Main {

  public static void main(String[] args) {
    Scanner console = new Scanner(System.in);
    String name = null;
    long size = 0;
    System.out.println("Введите путь до папки: ");
    try {
      name = console.nextLine();
      size = Files.walk(Paths.get(name))
          .filter(p -> p.toFile().isFile())
          .mapToLong(p -> p.toFile().length())
          .sum();
    } catch (Throwable ex) {
      ex.printStackTrace();
    }

    System.out.println("Размер папки " + name + " составляет " + getReadableSize(size));
  }

  private static String getReadableSize(long sizeInBytes) {
    double sizeInKBytes = (double) sizeInBytes / 1024;
    double sizeInMBytes = sizeInKBytes / 1024;
    double sizeInGBytes = sizeInMBytes / 1024;

    if (sizeInKBytes > 1 && sizeInKBytes <= 1024) {
      return String.format("%,.2f kB.%n", sizeInKBytes);
    }

    if (sizeInMBytes > 1 && sizeInMBytes <= 1024) {
      return String.format("%,.2f MB.%n", sizeInMBytes);
    }

    if (sizeInGBytes > 1 && sizeInGBytes <= 1024) {
      return String.format("%,.2f GB.%n", sizeInGBytes);
    }
    return String.format("%,d В.%n", sizeInBytes);
  }
}
