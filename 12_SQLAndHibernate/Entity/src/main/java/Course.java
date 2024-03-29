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

@Entity
@Table(name = "Courses")
public class Course {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
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
  @Column(name = "students_count")
  private Integer studentsCount;


  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "Subscriptions",
      joinColumns = {@JoinColumn(name = "course_id")},
      inverseJoinColumns = {@JoinColumn(name = "student_id")})
  private List<Student> students;

  public Teacher getTeacher() {
    return teacher;
  }

  public void setTeacher(Teacher teacher) {
    this.teacher = teacher;
  }

  public List<Student> getStudents() {
    return students;
  }

  public void setStudents(List<Student> students) {
    this.students = students;
  }

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

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getDuration() {
    return duration;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }

  public CourseType getType() {
    return type;
  }

  public void setType(CourseType type) {
    this.type = type;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getStudentsCount() {
    return studentsCount;
  }

  public void setStudentsCount(Integer studentsCount) {
    this.studentsCount = studentsCount;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public float getPricePerHour() {
    return pricePerHour;
  }

  public void setPricePerHour(float pricePerHour) {
    this.pricePerHour = pricePerHour;
  }
}
