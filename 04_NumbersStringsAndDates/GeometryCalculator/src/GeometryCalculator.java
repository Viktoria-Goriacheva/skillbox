public class GeometryCalculator {

  public static double getCircleSquare(double radius) {
    radius = Math.abs(radius);
    double area = Math.pow(radius, 2) * Math.PI;
    return area;
  }

  public static double getSphereVolume(double radius) {
    radius = Math.abs(radius);
    double volume = (4.0 * Math.PI * Math.pow(radius, 3)) / 3.0;
    return volume;
  }

  public static double isTriangleRightAngled(double a, double b, double c) {
    if ((a + b) > c && (c + b) > a && (c + a) > b && a != 0d && b != 0d && c != 0d) {
      System.out.println("Можно построить треугольник");
      return 1.0;
    } else {
      System.out.println("Эти стороны не образуют треугольника");
      return -1.0;
    }
  }

  public static double getTriangleSquare(double a, double b, double c) {

      double p1 = (a + b + c) / 2.0;
      double s = Math.sqrt(p1 * (p1 - a) * (p1 - b) * (p1 - c));
      return s;

    }
  }

