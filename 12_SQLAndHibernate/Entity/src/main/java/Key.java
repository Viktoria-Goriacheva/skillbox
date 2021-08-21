import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Embeddable
public class Key implements Serializable {

  @ManyToOne
  @JoinColumn(name = "student_id")
  private Student student;

  @ManyToOne
  @JoinColumn(name = "course_id")
  private Course course;

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Key)) {
      return false;
    }
    Key key = (Key) o;
    return getStudent() == key.getStudent() && getCourse() == key.getCourse();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getStudent(), getCourse());
  }

}