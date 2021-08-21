import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Subscriptions")
public class Subscription {

  @EmbeddedId
  private Key id;

  @Column(name = "subscription_date")
  private Date subscriptionDate;

}