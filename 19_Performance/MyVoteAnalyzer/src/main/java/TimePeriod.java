import java.text.SimpleDateFormat;

public class TimePeriod implements Comparable<TimePeriod> {

  private static final long msInDay = 24 * 60 * 60 * 1000;
  private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm");
  private static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

  private long from;
  private long to;

  /**
   * Time period within one day
   *
   * @param from
   * @param to
   */
  public TimePeriod(long from, long to) {
    this.from = from;
    this.to = to;
    if (from / msInDay != to / msInDay) {
      throw new IllegalArgumentException("Dates 'from' and 'to' must be within ONE day!");
    }
  }

  public void appendTime(long visitTime) {
    if (visitTime / msInDay != this.from / msInDay) {
      throw new IllegalArgumentException(
          "Visit time must be within the same day as the current TimePeriod!");
    }
    if (visitTime < from) {
      from = visitTime;
    }
    if (visitTime > to) {
      to = visitTime;
    }
  }

  public String toString() {
    String from = dateFormat.format(this.from);
    String to = timeFormat.format(this.to);
    return from.concat("-").concat(to);
  }

  @Override
  public int compareTo(TimePeriod period) {
    long current = from;
    long compared = period.from;
    return Long.compare(current / msInDay, compared / msInDay);
  }
}

