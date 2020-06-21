import com.skillbox.airport.Airport;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Airport airport = Airport.getInstance();
        System.out.println(airport.getAllAircrafts());
        System.out.println("количество самолетов: " + airport.getAllAircrafts().size());
        System.out.println(airport.getAllAircrafts().get(0));

    }
}
