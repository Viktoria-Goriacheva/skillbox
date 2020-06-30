import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    String text =
        "Black holes are areas in the universe where gravity pulls in everything, even light. Nothing can get out and all objects are squeezed into a tiny space. "
            + "Because there is no light in black holes we cannot see them. But scientists can detect the immense gravity and radiation around them. "
            + "They are the most mysterious objects in astronomy. Scientists think that the first black holes were formed when the universe began about "
            + "13 billion of years ago.Albert Einstein was the first scientist to predict that black holes existed. But it was in 1971 that the first black hole was actually discovered.\n"
            + "Black holes can have various sizes, some may be even as small as an atom. But they all have one thing in common – a very large mass.";
    String[] words = text.split("(?U)\\W+");
    int wordCount = text.split("\\s+").length;
    System.out.println("Количество слов в статье = " + wordCount + "\n");
    for (int i = 0; i < words.length; i++) {
      System.out.println(words[i]);

    }
  }
}

