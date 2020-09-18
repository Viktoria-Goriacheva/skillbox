import core.Line;
import core.Station;
import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;

public class RouteCalculatorTest extends TestCase {

  /*
   * line1 : i, i1, i2;
   * line2 : k, k1, k2, k3;
   * line3 : n, n1, n2;
   *
   * Connections: i1/k1, i2/n1;
   *
   *                     line1
   *                       i
   *                       |
   *                       |
   *       line2   k - - i1/k1 - - k2 - - k3
   *                       |
   *                       |
   *       line3   n - - i2/n1 - - n2
   */
  List<Station> routeWithTwoConnections;
  List<Station> routeOnTheLineConnections;
  List<Station> routeWithOneConnections;
  StationIndex stationIndex;
  RouteCalculator routeCalculator;

  @Override
  protected void setUp() {

    stationIndex = new StationIndex();
    routeCalculator = new RouteCalculator(stationIndex);
    List<Station> connectionLine1Line2 = new ArrayList<>();
    List<Station> connectionLine1Line3 = new ArrayList<>();

    Line line1 = new Line(1, "Первая");
    Line line2 = new Line(2, "Вторая");
    Line line3 = new Line(3, "Третья");

    stationIndex.addLine(new Line(1, "Первая"));
    stationIndex.addLine(new Line(2, "Вторая"));
    stationIndex.addLine(new Line(3, "Третья"));

    stationIndex.addStation(new Station("i", line1));
    stationIndex.addStation(new Station("i1", line1));
    stationIndex.addStation(new Station("i2", line1));
    stationIndex.addStation(new Station("k", line2));
    stationIndex.addStation(new Station("k1", line2));
    stationIndex.addStation(new Station("k2", line2));
    stationIndex.addStation(new Station("k3", line2));
    stationIndex.addStation(new Station("n", line3));
    stationIndex.addStation(new Station("n1", line3));
    stationIndex.addStation(new Station("n2", line3));
    line1.addStation(stationIndex.getStation("i"));
    line1.addStation(stationIndex.getStation("i1"));
    line1.addStation(stationIndex.getStation("i2"));
    line2.addStation(stationIndex.getStation("k"));
    line2.addStation(stationIndex.getStation("k1"));
    line2.addStation(stationIndex.getStation("k2"));
    line2.addStation(stationIndex.getStation("k3"));
    line3.addStation(stationIndex.getStation("n"));
    line3.addStation(stationIndex.getStation("n1"));
    line3.addStation(stationIndex.getStation("n2"));
    connectionLine1Line2.add(stationIndex.getStation("i1", 1));
    connectionLine1Line2.add(stationIndex.getStation("k1", 2));
    connectionLine1Line3.add(stationIndex.getStation("i2", 1));
    connectionLine1Line3.add(stationIndex.getStation("n1", 3));

    stationIndex.addConnection(connectionLine1Line2);
    stationIndex.addConnection(connectionLine1Line3);

    routeWithTwoConnections = new ArrayList<>();
    routeWithTwoConnections.add(stationIndex.getStation("n"));
    routeWithTwoConnections.add(stationIndex.getStation("n1"));
    routeWithTwoConnections.add(stationIndex.getStation("i2"));
    routeWithTwoConnections.add(stationIndex.getStation("i1"));
    routeWithTwoConnections.add(stationIndex.getStation("k1"));
    routeWithTwoConnections.add(stationIndex.getStation("k2"));
    routeWithTwoConnections.add(stationIndex.getStation("k3"));

    routeOnTheLineConnections = new ArrayList<>();
    routeOnTheLineConnections.add(stationIndex.getStation("n"));
    routeOnTheLineConnections.add(stationIndex.getStation("n1"));

    routeWithOneConnections = new ArrayList<>();
    routeWithOneConnections.add(stationIndex.getStation("k2"));
    routeWithOneConnections.add(stationIndex.getStation("k1"));
    routeWithOneConnections.add(stationIndex.getStation("i1"));
    routeWithOneConnections.add(stationIndex.getStation("i"));
  }

  public void testCalculateDuration() {

    double actual = RouteCalculator.calculateDuration(routeWithTwoConnections);
    double expected = 17;
    assertEquals(expected, actual);
  }

  public void testGetShortestRoute() {

    List<Station> actual = routeCalculator
        .getShortestRoute(stationIndex.getStation("n"), stationIndex.getStation("k3"));
    List<Station> expected = routeWithTwoConnections;
    String actualLine = actual.toString();
    String expectedLine = expected.toString();
    assertEquals(actualLine, expectedLine);
  }

  public void testGetRouteOnTheLine() {
    List<Station> actual = routeCalculator
        .getShortestRoute(stationIndex.getStation("n"), stationIndex.getStation("n1"));
    List<Station> expected = routeOnTheLineConnections;
    String actualLine = actual.toString();
    String expectedLine = expected.toString();
    assertEquals(actualLine, expectedLine);
  }

  public void testGetRouteWithOneConnection() {
    List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("k2"), stationIndex.getStation("i"));
    List<Station> expected = routeWithOneConnections;
    String actualLine = actual.toString();
    String expectedLine = expected.toString();
    assertEquals(actualLine, expectedLine);
  }
  public void testGetRouteWithTwoConnections() {

    List<Station> actual = routeCalculator
        .getShortestRoute(stationIndex.getStation("n"), stationIndex.getStation("k3"));
    List<Station> expected = routeWithTwoConnections;
    String actualLine = actual.toString();
    String expectedLine = expected.toString();
    assertEquals(actualLine, expectedLine);
  }
  @Override
  protected void tearDown() {

  }
}
