import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

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

  @JoinColumn(name = "student_name", referencedColumnName = "name")
  @ManyToOne(optional = false, fetch = FetchType.EAGER)
  private Student student;

  public String getStudentName() {
    return studentName;
  }

  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public Date getSubscriptionDate() {
    return subscriptionDate;
  }

  public void setSubscriptionDate(Date subscriptionDate) {
    this.subscriptionDate = subscriptionDate;
  }

}
