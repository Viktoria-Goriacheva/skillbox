import java.util.Collections;

public class Main {

  public static void main(String[] args) {
    String fraze = "Каждый охотник желает знать, где сидит фазан.";
    String[] words = fraze.split("[,.\\s]+");

    for (int i = 0; i < words.length / 2; i++) {
      String interim = words[words.length - 1 - i];
      words[words.length - 1 - i] = words[i];
      words[i] = interim;
    }
    for (int i = 0; i < words.length; i++) {
      System.out.println(words[i]);
    }
  }
}

