public class Main {

  public static void main(String[] args) {
    String[][] chessBoard = new String[7][7];
    for (int i = 0; i < chessBoard.length; i++) {

      for (int j = 0; j < chessBoard[0].length; j++) {
        if (i == j || (i + j) % 6 == 0) {
          chessBoard[i][j] = "X";
        } else {
          chessBoard[i][j] = " ";
        }
      }
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
