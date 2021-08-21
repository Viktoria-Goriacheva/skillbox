import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Courses")
public class Course {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;
  private int duration;
  @Enumerated(EnumType.STRING)
  @Column(columnDefinition = "enum")
  private CourseType type;
  private String description;
  private int price;
  @Column(name = "price_per_hour")
  private float pricePerHour;
  @ManyToOne(cascade = CascadeType.ALL)
  private Teacher teacher;
  @Column(name = "students_count", nullable = true)
  private Integer studentsCount;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "Subscriptions",
      joinColumns = {@JoinColumn(name = "course_id")},
      inverseJoinColumns = {@JoinColumn(name = "student_id")})
  private List<Student> students;

  @Override
  public String toString() {
    return "Course{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", duration=" + duration +
        ", type=" + type +
        ", description='" + description + '\'' +
        ", teacher=" + teacher +
        ", studentsCount=" + studentsCount +
        ", price=" + price +
        ", pricePerHour=" + pricePerHour +
        '}';
  }

}
