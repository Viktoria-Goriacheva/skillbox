import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Students")
@Data

public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private int age;
  private String name;

  @ManyToMany
  @JoinTable(name = "subscriptions",
      joinColumns = {@JoinColumn(name = "student_id")},
      inverseJoinColumns = {@JoinColumn(name = "course_id")})
  private List<Course> courses;


  @Column(name = "registration_date")
  private Date registrationDate;

}
