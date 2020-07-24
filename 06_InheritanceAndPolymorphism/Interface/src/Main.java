import java.util.ArrayList;

public class Main {

  public static void main(String[] args) {
    ArrayList<Employee> list = new ArrayList<>();
    Company company = new Company();

    for (int i = 0; i < 80; i++) {
      list.add(new Manager());
    }
    for (int i = 0; i < 180; i++) {
      list.add(new Operator());
    }
    for (int i = 0; i < 10; i++) {
      list.add(new TopManager(company.getIncome()));
    }
    company.hireAll(list);
    company.getTopSalaryStaff(10);
    company.getLowesSalaryStaff(30);
    company.fire(list.size() / 2);
    company.getTopSalaryStaff(10);
    company.getLowesSalaryStaff(30);
  }
}
