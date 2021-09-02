import au.com.bytecode.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class Main {

  private static final String FILE_WAY = "D:\\YanDisk\\movementList.csv";

  public static void main(String[] args) {

    Movements mov = new Movements();
    mov.getExpenseSum(CSVparser());
    mov.getIncomeSum(CSVparser());
    mov.CostAllocationByCounterparties(CSVparser());
  }

  private static ArrayList<Transaction> CSVparser() {
    ArrayList<Transaction> transactions = new ArrayList<>();
    DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
    try {
      CSVReader reader = new CSVReader(new FileReader(FILE_WAY), ',', '"', 1);
      String[] line;
      while ((line = reader.readNext()) != null) {
        String description = line[5].split("\\s{3,}")[1].trim();
        description = description.contains("/") ?
            description.substring(description.indexOf("/") + 1).trim() :
            description.replaceFirst("^\\d+", "").trim();
        transactions
            .add(new Transaction(line[0],
                line[1],
                line[2],
                df.parse(line[3]),
                line[4],
                description,
                Double.parseDouble(line[6].replaceAll(",", ".")),
                Double.parseDouble(line[7].replaceAll(",", "."))));
      }
    } catch (IOException | ParseException e) {
      e.printStackTrace();
    }
    return transactions;
  }
}
