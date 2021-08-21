import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "linkedpurchaselist")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkedPurchaseList implements Serializable {

  @Id
  private int studentId;

  @Id
  private int courseId;

  @Column(name = "student_name")
  private String studentName;

  @Column(name = "course_name")
  private String courseName;

  private int price;

  @Column(name = "subscription_date")
  private Date subscriptionDate;
}
