
public class Cat
{
    private double originWeight;
    private double weight;
    private double WeightFood;
    public static final int EYES = 2;
    public static final double MIN_WEIGHT = 1000;
    public static final double MAX_WEIGHT = 9000;
    public static int count = 0;
    private boolean live = true;
    private String ColorCat;

    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        count++;
    }

    public Cat(double weight){
        this();
        this.weight = weight;
    }
    public void setColor(String ColorCat){
        this.ColorCat = ColorCat;
    }
    public void getColor(){
    System.out.println("цвет кошки: " + ColorCat);
}
    public static int getCount(){
        return count;
    }
    public String isAlive() {

        if (live) {
            return "кошка жива";
        } else {
            return "кошка мертва";
        }
    }

    public void meow()
    {
        weight = weight - 1;
        System.out.print("Meow");
        if (weight < MIN_WEIGHT || weight > MAX_WEIGHT) {live = false;}

    }

    public void pee()
    {weight = weight - 1;
        System.out.println("Mrrrrrh");
        if (weight < MIN_WEIGHT || weight > MAX_WEIGHT) {live = false;}}

public double getWeightFood(){
    return WeightFood;
}
    public void feed(Double amount)
    {
        weight = weight + amount;
        WeightFood = amount;
        if (weight < MIN_WEIGHT || weight > MAX_WEIGHT) {live = false;}
    }

    public void drink(Double amount)
    {
        weight = weight + amount;
        if (weight < MIN_WEIGHT || weight > MAX_WEIGHT) {live = false;}
    }

    public Double getWeight()
    {
        return weight;
    }

    public String getStatus()
    {
        if(weight < MIN_WEIGHT) {
            count--;
            return "Dead";
        }
        else if(weight > MAX_WEIGHT) {
            count--;
            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }
}