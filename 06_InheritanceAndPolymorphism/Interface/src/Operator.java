public class Operator implements Employee {

  private int salary;

  public Operator() {
    salary = getRandomIntBetweenRange(OPERATOR_LOWER_PART, OPERATOR_UPPER_PART);
  }

  @Override
  public int getMonthSalary() {
    return salary;
  }
}
