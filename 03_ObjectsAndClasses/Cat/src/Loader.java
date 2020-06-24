import java.awt.*;
import java.awt.color.ColorSpace;
import java.sql.SQLOutput;

public class Loader {

  public static Cat getKitten() {
    return new Cat(1100);
  }

  public static void main(String[] args) {
    Cat kitten1 = getKitten();
    Cat kitten2 = getKitten();
    Cat kitten3 = getKitten();
    System.out.println(kitten1.getWeight());

    Cat basia = new Cat();
    System.out.println("Вес Баси: " + basia.getWeight());
    while (basia.getStatus() != "Dead") {
      basia.meow();
    }
    basia.pee();
    System.out.println(basia.getWeight());
    Cat robert = new Cat();
    System.out.println("Вес Роберта: " + robert.getWeight());

    Cat timon = new Cat();
    System.out.println("Вес Тимона: " + timon.getWeight());
    timon.feed(10.0);
    System.out.println(timon.getWeightFood());
    timon.feed(20.0);
    System.out.println(timon.getWeightFood());
    timon.pee();
    timon.pee();
    timon.pee();
    timon.feed(30.0);
    System.out.println(timon.getWeightFood());
    timon.feed(10000.0);
    timon.feed(1.0);
    System.out.println("новый вес Тимона: " + timon.getWeight());

    Cat tod = new Cat(basia);

    Cat marusia = new Cat();
    System.out.println("Вес Маруси: " + marusia.getWeight());
    marusia.feed(150.00);
    System.out.print("кормим," + " ");
    System.out.println("новый вес Маруси: " + marusia.getWeight());
    marusia.pee();
    marusia.pee();
    marusia.pee();
    System.out.println("Вес Маруси: " + marusia.getWeight());
    marusia.isAlive();
    System.out.println("Количество кошек: " + Cat.getCount());

    marusia.setColor(ColorsCat.BLACK);
    marusia.getColor();


  }
}