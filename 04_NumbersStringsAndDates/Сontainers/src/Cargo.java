public class Cargo {


  private int truck;
  private int container;
  private int box;

  public Cargo(int box) {
    this.box = box;
    container = box % 27 == 0 ? box / 27 : box / 27 + 1;
    truck = container % 12 == 0 ? container / 12 : container / 12 + 1;
  }

  public int getTruck() {
    return truck;
  }

  public int getContainer() {
    return container;
  }

  public int getBox() {
    return box;
  }

  public void count() {
    int b = 1;
    int c = 1;
    for (int i = 1; i <= truck; i++) {
      System.out.println("Truck number: " + i);
      int j = 0;
      while (j < 12 && c <= container) {
        System.out.println(" Container number: " + c);
        int k = 0;
        while (k < 27 && b <= box) {
          System.out.println("  Box number: " + b);
          k++;
          b++;
        }
        j++;
        c++;
        System.out.println();
      }
    }
  }
}

