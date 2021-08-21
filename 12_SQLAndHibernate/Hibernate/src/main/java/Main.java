import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {

  public static void main(String[] args) {
    StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
        .configure("hibernate.cfg.xml").build();
    Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
    SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
    Session session = sessionFactory.openSession();
    List<Course> courses = session.createNativeQuery(
        "SELECT * FROM Courses")
        .addEntity(Course.class).list();

    Integer sum = courses.stream().filter(c -> c.getType() == CourseType.PROGRAMMING)
        .map(o -> o.getStudentsCount()).reduce(0, Integer::sum);
    System.out
        .println("Имя курса: " + CourseType.PROGRAMMING + "\n" + "Количество студенотов: " + sum);
    sessionFactory.close();
  }
}
