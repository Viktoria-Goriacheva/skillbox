import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Flight.Type;
import com.skillbox.airport.Terminal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

  private static String staffFile = "data/staff.txt";
  private static String dateFormat = "dd.MM.yyyy";

  public static void main(String[] args) {
    ArrayList<Employee> staff = loadStaffFromFile();
    Collections.sort(staff, (o1, o2) -> {
      int temp = o1.getSalary() - o2.getSalary();
      if (temp == 0) {
        return (o1.getName().compareTo(o2.getName()));
      } else {
        return temp;
      }
    });
    staff.stream()
        .filter(employee -> employee.getYear(employee.getWorkStart()) == 2017)
        .max(Comparator.comparing(Employee::getSalary))
        .ifPresent(System.out::println);

    Airport airport = Airport.getInstance();

    List<Terminal> terminals = airport.getTerminals();
    List<Flight> flights = new ArrayList<>();
    terminals.stream().map(Terminal::getFlights).forEach(flights::addAll);
    Date date1 = new Date();
    flights.stream()
        .sorted(Comparator.comparing(Flight::getDate))
        .filter(x -> x.getType().equals(Type.DEPARTURE))
        .filter(t -> t.getDate().getTime() >= date1.getTime())
        .filter(t -> ((t.getDate().getTime()) - date1.getTime()) <= 7200000)
        .forEach(System.out::println);

  }

  private static ArrayList<Employee> loadStaffFromFile() {
    ArrayList<Employee> staff = new ArrayList<>();
    try {
      List<String> lines = Files.readAllLines(Paths.get(staffFile));
      for (String line : lines) {
        String[] fragments = line.split("\t");
        if (fragments.length != 3) {
          System.out.println("Wrong line: " + line);
          continue;
        }
        staff.add(new Employee(
            fragments[0],
            Integer.parseInt(fragments[1]),
            (new SimpleDateFormat(dateFormat)).parse(fragments[2])
        ));
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return staff;
  }
}