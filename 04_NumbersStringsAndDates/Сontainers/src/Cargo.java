public class Cargo {


  private static int truck = 1;
  private static int container = 1;
  private int box;
  final int CONTAINERS_IN_TRUCK = 12;
  final int BOXES_IN_CONTAINER = 27;


  public Cargo(int box) {
    this.box = box;
  }

  public static int getCountTruck() {
    return truck - 1;
  }

  public static int getCountContainer() {
    return container - 1;
  }

  public int getBox() {
    return box;
  }

  public void count() {
    System.out.println("truck number: " + truck + "\n");
    truck++;
    System.out.println("\tContainer number: " + container + "\n");
    container++;

    for (int i = 1; i <= box; i++) {
      System.out.println("\t\tBox number: " + i);

      if (i % BOXES_IN_CONTAINER == 0) {
        System.out.println("\t\nContainer number: " + container + "\n");
        container++;

        if (i % (BOXES_IN_CONTAINER * CONTAINERS_IN_TRUCK) == 0) {
          System.out.println("truck number: " + truck + "\n");
          truck++;

        }
      }
    }
  }
}




