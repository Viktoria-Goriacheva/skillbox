
public class Cat
{
    private double originWeight;
    private double weight;
    private double WeightFood;
    private double minWeight;
    private double maxWeight;
    public static int count = 0;

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

    public void meow()
    {
        weight = weight - 1;
        System.out.print("Meow");
    }

    public void pee()
    {weight = weight - 1;
        System.out.println("Mrrrrrh");}

public double getWeightFood(){
    return WeightFood;
}
    public void feed(Double amount)
    {
        weight = weight + amount;
        WeightFood = amount;
    }

    public void drink(Double amount)
    {
        weight = weight + amount;
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