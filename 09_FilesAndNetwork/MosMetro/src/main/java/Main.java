import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Main {

  private static final String URL = "https://www.moscowmap.ru/metro.html#lines";
  private static final String FILE = "src/main/resources/map.json";

  public static void main(String[] args) {

    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    try {
      Document doc = Jsoup.connect(URL).maxBodySize(0).get();
      PrintWriter pw = new PrintWriter(FILE);
      pw.print("");
      pw.write(gson.toJson(createElements(doc.getElementById("metrodata"))));
      pw.flush();
      pw.close();
      Metro metroFromFile = getMetro();
      metroFromFile.printStation();


    } catch (Exception exception) {
      exception.printStackTrace();
    }
  }

  private static Metro getMetro() {
    List<String> list = null;
    try {
      list = Files.readAllLines(Paths.get(FILE));
    } catch (IOException e) {
      e.printStackTrace();
    }
    StringBuilder sb = new StringBuilder();
    if (list != null) {
      list.forEach(sb::append);
    }
    String gsonString = sb.toString();
    return new Gson().fromJson(gsonString, Metro.class);
  }


  private static Metro createElements(Element element) {
    Metro metro = new Metro();
    metro.setLines(parseLines(element));
    metro.setStations(parseStations(element));
    metro.setConnections(parseConnections(element));
    return metro;
  }

  private static List<Line> parseLines(Element element) {
    List<Line> lines = new ArrayList<>();
    element.select("div.js-toggle-depend").select("span")
        .forEach(e -> lines.add(new Line(e.attr("data-line"), e.text())));
    return lines;
  }

  private static Map<String, List<String>> parseStations(Element element) {
    Map<String, List<String>> stations = new LinkedHashMap<>();
    element.select("div.t-metrostation-list-table").forEach(e -> {
      String numberLine = e.attr("data-line");

      List<String> stationsNames = new ArrayList<>();
      e.select("p").forEach(el -> stationsNames.add(el.select("span.name").text()));

      stations.put(numberLine, stationsNames);
    });
    return stations;
  }

  private static Set<Set<Station>> parseConnections(Element element) {
    Set<Set<Station>> connections = new HashSet<>();

    element.select("div.t-metrostation-list-table")
        .forEach(line -> line.select("p")
            .forEach(station -> station.select("span.t-icon-metroln")
                .forEach(el -> {

                  Set<Station> connectedStations = new HashSet<>();

                  Station from = new Station(line.attr("data-line"),
                      station.select("span.name").text());
                  Station to = new Station(
                      el.attr("class").substring(18),
                      getNameOfConnectedStation(el));
                  connectedStations.add(from);
                  connectedStations.add(to);
                  connections.add(connectedStations);
                })));
    return connections;
  }

  private static String getNameOfConnectedStation(Element element) {
    String description = element.toString();
    description = description.substring(description.indexOf("\u00ab") + 1);
    description = description.substring(0, description.indexOf("\"")).replaceFirst("\u00bb", "");
    return description;
  }
}
