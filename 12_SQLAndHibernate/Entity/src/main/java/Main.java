import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
    Transaction transaction = session.beginTransaction();
    Course course = session.get(Course.class, 1);
    Student student = session.get(Student.class, 2);
    Key key = new Key();
    key.setCourse(course);
    key.setStudent(student);
    Subscription subscription = session.get(Subscription.class, key);
    System.out.println(subscription.getSubscriptionDate());
    transaction.commit();
    sessionFactory.close();
  }
}
