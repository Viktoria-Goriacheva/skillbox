import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {

  private static int newWidth = 300;
  private static int processors = Runtime.getRuntime().availableProcessors();

  public static void main(String[] args) {
    String pictures = "src/Picture";
    String newPictures = "src/NewPicture";

    File srcDir = new File(pictures);

    long start = System.currentTimeMillis();

    File[] files = srcDir.listFiles();
    for (File[] part : getArrayParts(files)) {
      new ImageResizer(part, newWidth, newPictures, start).start();

    }
  }

  public static List<File[]> getArrayParts(File[] array) {
    List<File[]> parts = new ArrayList<>();
    if (processors == 1) {
      parts.add(array);
      return parts;
    }
    int sizePartOne = array.length / processors;   //  = 6
    int smallPartSize = array.length % processors;  //  = 1
    int remain = sizePartOne + smallPartSize; // = 7
    int remainPosition = remain * (processors - 2); // = 42
    File[] part;
    for (int i = 0; i < processors - 1; i++) {
      part = new File[sizePartOne];
      System.arraycopy(array, i * sizePartOne, part, 0, sizePartOne);
      parts.add(part);
    }
    if (array.length % processors != 0) {
      part = new File[remain];
      System.arraycopy(array, remainPosition, part, 0, remain);
      parts.add(part);
    }
    return parts;
  }
}
