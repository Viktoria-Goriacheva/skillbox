import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    final int SIZE = 5;
    char[][] chessBoard = new char[SIZE][SIZE];

    for (int i = 0; i < SIZE; i++) {
      Arrays.fill(chessBoard[i], ' ');

      chessBoard[i][i] = 'X';
      chessBoard[i][SIZE - i - 1] = 'X';

    }
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        System.out.print(chessBoard[i][j] + " ");
      }
      System.out.println("\n");
    }



  show(chessBoard);
}


  private static void show(char[][] arr) {
    for (char[] anArr : arr) {
      for (char anAnArr : anArr) {
        System.out.print(anAnArr);
      }
     System.out.println();
 }
  }
}
