
public class Cat {

  private double originWeight;
  private double weight;
  private double weightFood;
  private double sumWeightFood;
  private double allSumWeightFood;
  public static final int EYES = 2;
  public static final double MIN_WEIGHT = 1000;
  public static final double MAX_WEIGHT = 9000;
  private static int count = 0;
  public ColorsCat selectedColors;


  public Cat() {
    weight = 1500.0 + 3000.0 * Math.random();
    originWeight = weight;
    count++;
  }

  public Cat(double weight) {
    this();
    this.weight = weight;
  }

  public Cat(Cat other) {
    this.originWeight = other.originWeight;
    this.weight = other.weight;
    this.weightFood = other.weightFood;
    this.selectedColors = other.selectedColors;
    count++;
  }

  public Cat copy() {

    return new Cat(this);
  }

  public void setColor(ColorsCat selectedColors) {
    this.selectedColors = selectedColors;
  }

  public void getColor() {
    System.out.println("цвет кошки: " + selectedColors);
  }

  public static int getCount() {
    return count;
  }

  public void isAlive() {

    if (weight > MIN_WEIGHT && weight < MAX_WEIGHT) {
      System.out.println("кошка жива");
    } else {
      System.out.println("кошка мертва");
    }
  }

  public void meow() {

    if (weight < MIN_WEIGHT || weight > MAX_WEIGHT) {
      System.out.println("мертвые молчат");


    } else {
      System.out.println("Meow");
      weight = weight - 1;
      if (weight < MIN_WEIGHT || weight > MAX_WEIGHT) {
        count--;
      }
    }
  }

  public void pee() {
    if (weight < MIN_WEIGHT || weight > MAX_WEIGHT) {
      System.out.println("мертвые не ходят в туалет");

    } else {
      weight = weight - 1;
      System.out.println("Mrrrrrh");
      if (weight < MIN_WEIGHT || weight > MAX_WEIGHT) {
        count--;
      }
    }
  }

  public double getWeightFood() {
    allSumWeightFood = weightFood + sumWeightFood;
    sumWeightFood = allSumWeightFood;
    return allSumWeightFood;
  }

  public void feed(Double amount) {

    if (weight < MIN_WEIGHT || weight > MAX_WEIGHT) {
      System.out.println("не пихай еду в трупы");

    } else {
      weight = weight + amount;
      weightFood = amount;
      if (weight < MIN_WEIGHT || weight > MAX_WEIGHT) {
        count--;
      }
    }
  }

  public void drink(Double amount) {
    if (weight < MIN_WEIGHT || weight > MAX_WEIGHT) {
      System.out.println("мертвые не пьют");

    } else {
      weight = weight + amount;
      if (weight < MIN_WEIGHT || weight > MAX_WEIGHT) {
        count--;
      }
    }
  }
  
  public Double getWeight() {
    return weight;
  }

  public String getStatus() {
    if (weight < MIN_WEIGHT) {

      return "Dead";

    } else if (weight > MAX_WEIGHT) {

      return "Exploded";
    } else if (weight > originWeight) {
      return "Sleeping";
    } else {
      return "Playing";
    }
  }
}