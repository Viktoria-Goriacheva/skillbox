import java.util.Scanner;

public class Main {

  public static void main(String[] args) {


      int box = 0;
      Scanner scanner = new Scanner(System.in);
      System.out.println("How many boxes to be delivered?");
      box = scanner.nextInt();

      Cargo cargo = new Cargo(box);
      System.out.println("To deliver the boxes("+ cargo.getBox()+") you will need: \n" + "Truck: " + cargo.getTruck() + "\nContainer: " + cargo.getContainer());
      System.out.println("==========================");
      cargo.count();
    }
  }



