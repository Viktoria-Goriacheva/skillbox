public class Manager implements Employee {

  private int salary;
  private int moneyByManager;

  public Manager() {
    moneyByManager = getRandomIntBetweenRange(MANAGER_LOWER_BORDER, MANAGER_UPPER_BORDER);
    salary = (int) (getRandomIntBetweenRange(MANAGER_LOWER_PART, MANAGER_UPPER_PART)
        + moneyByManager * BONUS_INCOME);
  }

  @Override
  public int getMonthSalary() {
    return salary;
  }
}
