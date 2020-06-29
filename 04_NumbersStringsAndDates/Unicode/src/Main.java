public class Main {

  public static void main(String args[]) {
    char[] abc = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    System.out.println("Unicode lowercase letters:");
    for (int i = 0; i < abc.length; i++) {
      System.out.println("Element [" + i + "]: " + abc[i] + "\t" + (int) abc[i]);
    }
    System.out.println("\n");
    char[] ABC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    System.out.println("Unicode Latin capital letters:");
    for (int i = 0; i < ABC.length; i++) {
      System.out.println("Element [" + i + "]: " + ABC[i] + "\t" + (int) ABC[i]);
    }
    System.out.println("\n");
    char[] rus = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя".toCharArray();
    System.out.println("Unicode lowercase letters:");
    for (int i = 0; i < rus.length; i++) {
      System.out.println("Element [" + i + "]: " + rus[i] + "\t" + (int) rus[i]);
    }
    System.out.println("\n");
    char[] RUS = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ".toCharArray();
    System.out.println("Unicode Latin capital letters:");
    for (int i = 0; i < RUS.length; i++) {
      System.out.println("Element [" + i + "]: " + RUS[i] + "\t" + (int) RUS[i]);
    }
    System.out.println("\n");
  }
}

