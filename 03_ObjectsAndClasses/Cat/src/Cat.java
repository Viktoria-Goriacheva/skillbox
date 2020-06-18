
public class Cat
{
    private double originWeight;
    private double weight;
    private double WeightFood;
    private double minWeight;
    private double maxWeight;
    public static int count = 0;
    private boolean live = true;

    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;
        count++;

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
        if (weight > maxWeight || weight > maxWeight) {live = false;}

    }

    public void pee()
    {weight = weight - 1;
        System.out.println("Mrrrrrh");
        if (weight > maxWeight || weight > maxWeight) {live = false;}}

public double getWeightFood(){
    return WeightFood;
}
    public void feed(Double amount)
    {
        weight = weight + amount;
        WeightFood = amount;
        if (weight > maxWeight || weight > maxWeight) {live = false;}
    }

    public void drink(Double amount)
    {
        weight = weight + amount;
        if (weight > maxWeight || weight > maxWeight) {live = false;}
    }

    public Double getWeight()
    {
        return weight;
    }

    public String getStatus()
    {
        if(weight < minWeight) {
            count--;
            return "Dead";
        }
        else if(weight > maxWeight) {
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