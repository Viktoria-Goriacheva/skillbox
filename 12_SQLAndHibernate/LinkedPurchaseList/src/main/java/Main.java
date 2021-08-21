import java.util.List;
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
    String hql1 = "From " + PurchaseList.class.getSimpleName();
    List<PurchaseList> purchaseList = session.createQuery(hql1).getResultList();

    purchaseList.forEach(purchase -> {
      String hql2 =
          "From " + Student.class.getSimpleName() + " Where name = :name";
      Student student = (Student) session.createQuery(hql2)
          .setParameter("name", purchase.getStudentName()).getSingleResult();
      String hql3 =
          "From " + Course.class.getSimpleName() + " Where name = :name";
      Course course = (Course) session.createQuery(hql3)
          .setParameter("name", purchase.getCourseName()).getSingleResult();
      session.saveOrUpdate(
          new LinkedPurchaseList(
              student.getId(),
              course.getId(),
              purchase.getStudentName(),
              purchase.getCourseName(),
              purchase.getPrice(),
              purchase.getSubscriptionDate()
          ));
    });

    transaction.commit();
    sessionFactory.close();
  }
}
