import java.util.TreeSet;

public class WorkTime {

  private TreeSet<TimePeriod> periods;

  /**
   * Set of TimePeriod objects
   */
  public WorkTime() {
    periods = new TreeSet<>();
  }

  public void addVisitTime(long visitTime) {
    TimePeriod newPeriod = new TimePeriod(visitTime, visitTime);
    for (TimePeriod period : periods) {
      if (period.compareTo(newPeriod) == 0) {
        period.appendTime(visitTime);
        return;
      }
    }
    periods.add(new TimePeriod(visitTime, visitTime));
  }

  public String toString() {
    StringBuilder st = new StringBuilder();
    for (TimePeriod period : periods) {
      if (st.length() > 0) {
        st.append(", ");
      }
      st.append(period);
    }
    return st.toString();
  }
}
