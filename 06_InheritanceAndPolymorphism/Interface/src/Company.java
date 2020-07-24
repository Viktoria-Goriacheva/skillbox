import java.util.ArrayList;
import java.util.Collections;

public class Company {

  protected ArrayList<Employee> people = new ArrayList<>();

  public void getPeople() {
    int n = 0;
    for (int i = 0; i < people.size(); i++) {
      n++;
      System.out.println(
          "Зарплата № " + n + " : " + people.get(i).getMonthSalary() + "руб." + "    ID: " + people
              .get(i).getNumberID());
    }
    System.out.println("\n" + "Всего работников в компании: " + people.size());
  }

  public void getTopSalaryStaff(int count) {
    if (count > 0 && count < people.size()) {
      Collections.sort(people, (o1, o2) -> {
        if (o1.getMonthSalary() > o2.getMonthSalary()) {
          return -1;
        }
        if (o1.getMonthSalary() < o2.getMonthSalary()) {
          return 1;
        }
        return 0;
      });
      System.out.println(count + " самых высоких зарплат : \n");
      for (int i = 0; i < count; i++) {
        System.out.println(" * " + people.get(i).getMonthSalary() + " руб.");

      }
      System.out.println("\n");
    } else {
      System.out.println("Некорректное количество сотрудников");
    }
  }

  public void getLowesSalaryStaff(int count) {
    if (count > 0 && count < people.size()) {
      Collections.sort(people, (o1, o2) -> {
        if (o1.getMonthSalary() > o2.getMonthSalary()) {
          return 1;
        }
        if (o1.getMonthSalary() < o2.getMonthSalary()) {
          return -1;
        }
        return 0;
      });
      System.out.println(count + " самых низких зарплат : \n");
      for (int i = 0; i < count; i++) {
        System.out.println(" * " + people.get(i).getMonthSalary() + " руб.");

      }
      System.out.println("\n");
    } else {
      System.out.println("Некорректное количество сотрудников");
    }
  }

  public void hire(Employee employee) {

    people.add(employee);

  }

  public void hireAll(ArrayList<Employee> employee) {
    people.addAll(employee);
  }

  public void fire(int count) {
    if (count > 0 && count < people.size()) {
      for (int i = 0; i < count; i++) {
        int random = (int) (Math.random() * people.size());
        people.remove(random);
      }
    } else {
      System.out.println("Некорректное число увольняемых сотрудников");
    }
  }

  public long getIncome() {
    long summa = 0;
    for (Employee p : people) {
      if (p instanceof Manager) {
        summa = p.getMonthSalary() + summa;
      }
    }
    return summa;
  }
}
