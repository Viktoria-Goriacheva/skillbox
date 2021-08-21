import java.util.ArrayList;
import java.util.List;

/* По трем измерениям:
С 1м потоком --- 60 сек
С 8ю потоками около --- 17-19 сек (Самое оптимальное количество потоков по числу ядер системы)
С 16ю потоками --- 17-19 сек
С конкатенацией в методе padNumber --- 16-17 сек (Быстрее,чем простое объединение
строк или создание объекта  StringBuilder)
 */

public class Loader {

  private static final int REGION_CAPACITY = 192;
  private static final int PROCESSOR = Runtime.getRuntime().availableProcessors();
  private static String path = "src/file/numbers";
  static final String FILE_EXT = ".txt";
  public static void main(String[] args) throws InterruptedException {
    List<Thread> threads = new ArrayList<>();
    long start = System.currentTimeMillis();
    for (int count = 0; count < PROCESSOR; count++) {
      Thread thread = new Thread(new CarNumberGenerator(count * REGION_CAPACITY / PROCESSOR,
          REGION_CAPACITY / PROCESSOR,path.concat(Integer.toString(count)).concat(FILE_EXT)));
      threads.add(thread);
      thread.start();
    }
    for (Thread thread : threads) {
      thread.join();
    }
    System.out.println((System.currentTimeMillis() - start) + " ms");
  }
}

