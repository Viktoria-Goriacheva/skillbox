import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

  private static final String PATH = "src/data/commands";

  public static void main(String[] args) {
    MongoSale service = new MongoSale();
    service.colCleaner();
    try (Scanner scanner = new Scanner(new File(PATH));) {
      while (scanner.hasNext()) {
        String input = scanner.nextLine();
        String[] tokens = input.split("\\s");
        switch (tokens[0]) {
          case "ДОБАВИТЬ_МАГАЗИН":
            service.addShops(tokens[1]);
            break;
          case "ДОБАВИТЬ_ТОВАР":
            service.addGoods(tokens[1], tokens[2]);
            break;
          case "ВЫСТАВИТЬ_ТОВАР":
            service.putOutGoods(tokens[1], tokens[2]);
            break;
          case "СТАТИСТИКА_ТОВАРОВ":
            service.getStatistics();
            break;
          default:
            System.err.println("Wrong command. Try again.");
        }
      }
    } catch (FileNotFoundException ex) {
      System.out.println(ex.getStackTrace());
    } finally {
      service.allDrop();
    }
  }
}
