import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class Movements {


  public void getExpenseSum(ArrayList<Transaction> transactions) {
    Double debitTotalAmount = transactions.stream().mapToDouble(Transaction::getDebitAmount).sum();
    System.out.printf("Total debit amount: %,.2f RUR.%n", debitTotalAmount);
  }

  public void getIncomeSum(ArrayList<Transaction> transactions) {
    Double creditTotalAmount = transactions.stream().mapToDouble(Transaction::getCreditAmount)
        .sum();
    System.out.printf("\nTotal credit amount: %,.2f RUR.%n", creditTotalAmount);
  }

  public void CostAllocationByCounterparties(ArrayList<Transaction> transactions) {
    Map<String, Double> map = transactions.stream()
        .collect(Collectors.groupingBy(Transaction::getDescription,
            Collectors.summingDouble(Transaction::getDebitAmount)));
    System.out.println("\nCost allocation by counterparties:\n");
    map.forEach((key, value) -> System.out.printf("%-40s%,10.2f RUR.%n", key, value));
  }
}
