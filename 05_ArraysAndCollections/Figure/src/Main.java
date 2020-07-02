import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    int m = 9;
    int n = 9;
    String[][] chessBoard = new String[m][n];

    for (int i = 0; i < m; i++) {

      chessBoard[i][i] = "X";
      chessBoard[i][m - i - 1] = "X";

}


    show(chessBoard);

  }

  private static void show(String[][] arr) {
    for (String[] anArr : arr) {
      for (String anAnArr : anArr) {
        System.out.print(anAnArr + " ");
      }
      System.out.println();
    }
  }
}
