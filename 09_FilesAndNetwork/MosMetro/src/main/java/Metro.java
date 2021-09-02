import java.util.List;
import java.util.Map;
import java.util.Set;


public class Metro {

  private List<Line> lines;
  private Map<String, List<String>> stations;
  private Set<Set<Station>> connections;

  public Metro() {
  }

  public List<Line> getLines() {
    return lines;
  }

  public void setLines(List<Line> lines) {
    this.lines = lines;
  }

  public Map<String, List<String>> getStations() {
    return stations;
  }

  public void setStations(Map<String, List<String>> stations) {
    this.stations = stations;
  }

  public Set<Set<Station>> getConnections() {
    return connections;
  }

  public void setConnections(Set<Set<Station>> connections) {
    this.connections = connections;
  }

  public void printStation() {
    for (String key : stations.keySet()) {
      System.out.printf("Линия: %4s, количество станций: %d.%n", key, stations.get(key).size());
    }
    System.out.printf("\n" + "Общее число переходов метро : " + connections.size());

  }
}


