import com.sun.jdi.CharValue;

public class Main {

  public static void main(String[] args) {
    System.out.println("Максимум типа double = " + Double.MAX_VALUE);
    System.out.println("Минимум типа double = " + Double.MIN_VALUE);

    System.out.println("Максимум типа float = " + Float.MAX_VALUE);
    System.out.println("Минимум типа float = " + Float.MIN_VALUE);

    System.out.println("Максимум типа int = " + Integer.MAX_VALUE);
    System.out.println("Минимум типа int = " + Integer.MIN_VALUE);

    System.out.println("Максимум типа byte = " + Byte.MAX_VALUE);
    System.out.println("Минимум типа byte = " + Byte.MIN_VALUE);

    System.out.println("Максимум типа long = " + Long.MAX_VALUE);
    System.out.println("Минимум типа long = " + Long.MIN_VALUE);

    System.out.println("Максимум типа short = " + Short.MAX_VALUE);
    System.out.println("Минимум типа short = " + Short.MIN_VALUE);

    char c = (char)-1;
    System.out.println("Максимум типа char = " + (int)c);
    System.out.println("Минимум типа char = " + 0);
  }
}
