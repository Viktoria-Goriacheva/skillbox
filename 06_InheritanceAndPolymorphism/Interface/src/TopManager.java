public class TopManager implements Employee {

  private int salary;

  public TopManager(long income) {
    salary = getRandomIntBetweenRange(TOP_LOWER_PART, TOP_UPPER_PART);
    if (income > INCOME_BORDER) {
      salary = (int) (salary * 1.5);
    }
  }

  @Override
  public int getMonthSalary() {
    return salary;
  }
}
