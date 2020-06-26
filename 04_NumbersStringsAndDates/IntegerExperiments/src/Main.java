import org.w3c.dom.ls.LSOutput;

public class Main {

    public static void main(String[] args) {
        Container container = new Container();
        container.count += 7843;

        System.out.println(sumDigit(12345));
        System.out.println(sumDigits(12345));

        System.out.println(sumDigit(5059191));
        System.out.println(sumDigits(5059191));

        System.out.println(sumDigit(10));
        System.out.println(sumDigits(10));
    }
    public static int sumDigit(int i) {
        return String.valueOf(i).chars().map(Character::getNumericValue).sum();
    }
    public static Integer sumDigits(int number) {
        String s = Integer.toString(number);
        int dlina = s.length()-1;

        Integer vsaSumma = 0;
        for (int poziciya = 0; poziciya <= dlina; poziciya++) {

            int chislo = Integer.parseInt(String.valueOf(s.charAt(poziciya)));
            vsaSumma = vsaSumma + chislo;
        }
        return vsaSumma;
    }
}
