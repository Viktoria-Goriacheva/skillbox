public interface Employee {

  int MANAGER_LOWER_BORDER = 115000;
  int MANAGER_UPPER_BORDER = 140000;
  int MANAGER_LOWER_PART = 80000;
  int MANAGER_UPPER_PART = 110000;
  double BONUS_INCOME = 0.05;
  int OPERATOR_LOWER_PART = 40000;
  int OPERATOR_UPPER_PART = 60000;
  int TOP_LOWER_PART = 120000;
  int TOP_UPPER_PART = 160000;
  long INCOME_BORDER = 10000000;

  int getMonthSalary();

  default int getNumberID() {
    int numberID = getRandomIntBetweenRange(100000, 999999);
    return numberID;
  }

  default int getRandomIntBetweenRange(int min, int max) {
    return (int) (Math.random() * ((max - min) + 1) + min);
  }
}
