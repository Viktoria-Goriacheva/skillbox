import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import junit.framework.TestCase;

public class MovementsTest extends TestCase {

  ArrayList<Transaction> transactions = null;

  @Override
  protected void setUp() throws Exception {
    transactions = new ArrayList<>();
    DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
    transactions.add(new Transaction("текущий счет", "123234",
        "RUR", df.parse("12.09.2017"), "CRD_24Y234",
        "Альфа Банк", 150.30, 125.40));
    transactions.add(new Transaction("текущий счет", "12354634",
        "RUR", df.parse("15.05.2017"), "CRD_24Y894",
        "Продажа почек.ко", 0, 1265.40));
    transactions.add(new Transaction("текущий счет", "1233334",
        "RUR", df.parse("14.04.2017"), "CRD_2443Y4",
        "Альфа Банк", 190.10, 2125.40));
    transactions.add(new Transaction("текущий счет", "156734",
        "RUR", df.parse("13.03.2018"), "CRD_24Y67Y4",
        "Кредит на макароны", 4000.56, 0));
  }

  public void testGetExpenseSum() {
    Double debitTotalAmount = transactions.stream().mapToDouble(Transaction::getDebitAmount).sum();
    Double example = 125.40 + 1265.40 + 2125.40;
    assertEquals(debitTotalAmount, example);
  }

  public void testGetIncomeSum() {
    Double creditTotalAmount = transactions.stream().mapToDouble(Transaction::getCreditAmount)
        .sum();
    Double example = 150.30 + 190.10 + 4000.56;
    assertEquals(creditTotalAmount, example);
  }
}

