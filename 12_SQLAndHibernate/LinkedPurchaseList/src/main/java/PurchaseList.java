import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import lombok.Data;

@Data
@Entity
@Table(name = "purchaselist")
public class PurchaseList implements Serializable {

  @Id
  @Column(name = "student_name")
  private String studentName;

  @Id
  @Column(name = "course_name")
  private String courseName;

  private int price;

  @Column(name = "subscription_date")
  private Date subscriptionDate;

}
