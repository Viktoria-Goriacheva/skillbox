import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Subscriptions")
public class Subscription {

  @EmbeddedId
  private Key id;

  @Column(name = "subscription_date")
  private Date subscriptionDate;

  public Key getId() {
    return id;
  }

  public void setId(Key id) {
    this.id = id;
  }

  public Date getSubscriptionDate() {
    return subscriptionDate;
  }

  public void setSubscriptionDate(Date subscriptionDate) {
    this.subscriptionDate = subscriptionDate;
  }
}