import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    int m = 11;
    int n = 11;
    String[][] chessBoard = new String[m][n];

    for (int i = 0; i < m; i++) {

      chessBoard[i][i] = "X";
      chessBoard[i][m - i - 1] = "X";

    }
    String mas = Arrays.deepToString(chessBoard);
    StringBuffer sb = new StringBuffer(mas);
    StringBuffer hoi = sb.insert(0, " ");
    String resu = hoi.toString();
    String rez = resu.replaceAll("null", " ").replaceAll("\\[", "").replaceAll(",", "");
    String[] words = rez.split("\\]");
    for (int i = 0; i < words.length; i++) {

      System.out.println(words[i]);
    }
    // show(chessBoard);

  }

  // private static void show(String[][] arr) {
  // for (String[] anArr : arr) {
  //   for (String anAnArr : anArr) {
  //    System.out.print(anAnArr + " ");
  //  }
  //  System.out.println();
  // }
//  }
}
