import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.stream.Collectors;
import javax.imageio.ImageIO;
import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

public class Main {

  private static final String url = "https://lenta.ru/";
  private static ArrayList<String> list;

  public static void main(String[] args) {
    String destination = "src/main/pics";
    try {
      Document document = Jsoup.parse(parseHtml(url));
      Elements elements = document.select("img.g-picture");
      list = elements.stream().map(e -> e.attr("src"))
          .collect(Collectors.toCollection(ArrayList::new));
      list.forEach(url -> downloadPicture(url, destination));
    } catch (Exception exception) {
      exception.printStackTrace();
    }
    System.out.println("Копирование завершено");
  }

  public static void downloadPicture(String urlString, String destination) {
    try {
      String fileName = urlString.substring(urlString.lastIndexOf("/") + 1);
      String formatName = urlString.substring(urlString.lastIndexOf(".") + 1);
      String savingFileName = destination + "/" + fileName;
      BufferedImage image = ImageIO.read(new URL(urlString));
      ImageIO.write(image, formatName, new File(savingFileName));
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  public static String parseHtml(String url) throws IOException {
    URL oracle = new URL(url);
    BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));
    StringBuilder builder = new StringBuilder();
    String inputLine;
    while ((inputLine = in.readLine()) != null) {
      builder.append(inputLine).append("\n");
    }
    in.close();
    return builder.toString();
  }
}
