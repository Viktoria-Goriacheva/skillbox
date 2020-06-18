import java.sql.SQLOutput;

public class Loader
{
    public static void main(String[] args)
    {
        Cat basia = new Cat();
        System.out.println("Вес Баси: " + basia.getWeight());
        while (basia.getWeight() > 1000) {
            basia.meow(); }
        System.out.println(basia.getStatus());

        Cat robert = new Cat();
        System.out.println("Вес Роберта: " + robert.getWeight());

        Cat timon = new Cat();
        System.out.println("Вес Тимона: " + timon.getWeight());
        timon.feed(10000.7);
        System.out.print("кормим," + " ");
        System.out.println("новый вес Тимона: " + timon.getWeight());
        System.out.println(timon.getStatus());

        Cat marusia = new Cat();
        System.out.println("Вес Маруси: " + marusia.getWeight());
        marusia.feed(150.00);
        System.out.print("кормим," + " ");
        System.out.println("новый вес Маруси: " + marusia.getWeight());
        marusia.getWeightFood();
        marusia.pee();
        marusia.pee();
        marusia.pee();
        System.out.println("Вес Маруси: " + marusia.getWeight());
        System.out.println("вес съеденного кошкой:" + marusia.getWeightFood());
        System.out.println("Вес Маруси: " + marusia.getWeight());

        Cat pit = new Cat();
        System.out.println(timon.isAlive());
        System.out.println(marusia.isAlive());

        System.out.println("Количество кошек: " + Cat.getCount());


    }
}