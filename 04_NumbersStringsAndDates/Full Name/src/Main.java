import java.util.Arrays;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String fullName = sc.nextLine();
    int space = fullName.length() - fullName.replaceAll(" ", "").length();
    String[] strings = fullName.split("\\s+");
    if (space == 2){
      System.out.println("Фамилия : " + strings[0]);
    System.out.println("Имя : " + strings[1]);
    System.out.println("Отчество : " + strings[2]);}
    else if (space ==1){
      System.out.println("Фамилия : " + strings[0]);
      System.out.println("Имя : " + strings[1]);}
    else {
      System.out.println("некорректный ввод ФИО");
    }
   // int firstIndex = fullName.indexOf(" ");
   // int lastIndex = fullName.lastIndexOf(" ");



   // if (lastIndex != firstIndex && space <= 2) {
     // String firstName = fullName.substring(0, firstIndex);
     // String lastName = fullName.substring(firstIndex + 1, lastIndex);
     // String otherName = fullName.substring(lastIndex + 1);

     // System.out.println("Фамилия: " + firstName);
     // System.out.println("Имя: " + lastName);
     // System.out.println("Отчество: " + otherName);

   // } else if (lastIndex == firstIndex && space <= 2) {
   //   String firstName = fullName.substring(0, firstIndex);
   //   String lastName = fullName.substring(firstIndex + 1);
    //  System.out.println("Фамилия: " + firstName);
     // System.out.println("Имя: " + lastName);
    //} else {
    //  System.out.println("некорректный ввод ФИО");
   // }
  }
}

