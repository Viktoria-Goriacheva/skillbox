import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<>();
    String[] bukvy = {"С", "М", "Т", "В", "А", "Р", "О", "Н", "Е", "У", "Х"};

    for (int p = 1; p <= 199; p++) {
      for (int i = 111; i <= 999; i += 111) {
        for (int j = 0; j < bukvy.length; j++) {
          for (int h = 0; h < bukvy.length; h++) {
            for (int k = 0; k < bukvy.length; k++) {
              String number = String.format("%s%03d%s%02d%n", bukvy[j], i, bukvy[h] + bukvy[k], p)
                  .trim();
              list.add(number);
            }
          }
        }
      }
    }


    Collections.sort(list);
    HashSet<String> hashSet = new HashSet<>();
    hashSet.addAll(list);
    TreeSet<String> treeSet = new TreeSet<>();
    treeSet.addAll(list);
    System.out.println("Введите номер авто для поиска: ");
    Scanner scanner = new Scanner(System.in);
    String searchRooms = scanner.nextLine();
//====================================================================
    long start0 = System.nanoTime();
    if (list.contains(searchRooms)) {
      System.out.print("Поиск перебором: номер найден");
    } else {
      System.out.print("Поиск перебором: номер не найден");
    }
    long duration0 = System.nanoTime() - start0;
    System.out.println(", поиск занял " + duration0 + "нс");
//====================================================================
    long start1 = System.nanoTime();
    if (Collections.binarySearch(list, searchRooms) >= 0) {
      System.out.print("Бинарный поиск: номер найден");
    } else {
      System.out.print("Бинарный поиск: номер не найден");
    }long duration1 = System.nanoTime() - start1;
    System.out.println(", поиск занял " + duration1 + "нс");
//====================================================================
    long start2 = System.nanoTime();
    if (hashSet.contains(searchRooms)) {
      System.out.print("Поиск в HashSet: номер найден");
    } else {
      System.out.print("Поиск в HashSet: номер не найден");
    }long duration2 = System.nanoTime() - start2;
    System.out.println(", поиск занял " + duration2 + "нс");
//====================================================================
    long start3 = System.nanoTime();
    if (treeSet.contains(searchRooms)) {
      System.out.print("Поиск в TreeSet: номер найден");
    } else {
      System.out.print("Поиск в TreeSet: номер не найден");
    }long duration3 = System.nanoTime() - start3;
    System.out.println(", поиск занял " + duration3 + "нс");
  }
}

