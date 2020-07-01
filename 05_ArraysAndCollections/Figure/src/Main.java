import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    String[][] chessBoard = new String[9][9];
    if (chessBoard.length % 2 == 1) {
      for (int i = 0; i < chessBoard.length; i++) {

        for (int j = 0; j < chessBoard[0].length; j++) {
          if (i == j || j == (chessBoard.length - 1 - i)) {
            chessBoard[i][j] = "X";
          } else {
            chessBoard[i][j] = " ";
          }
        }
      }
      show(chessBoard);
    } else {
      for (int i = 0; i < chessBoard.length; i++) {

        for (int j = 0; j < chessBoard[0].length; j++) {
          if (i == j || j == (chessBoard.length - i)) {
            chessBoard[i][j] = "X";
          } else {
            chessBoard[i][j] = " ";
          }
        }
      }
      show(chessBoard);
    }
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
