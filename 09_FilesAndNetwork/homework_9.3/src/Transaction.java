import java.util.Date;

public class Transaction {

  private String accountType;
  private String account;
  private String currencyCode;
  private Date operationDate;
  private String referenceNumber;
  private String description;
  private double creditAmount;
  private double debitAmount;

  public Transaction(String accountType,
      String account,
      String currencyCode,
      Date operationDate,
      String referenceNumber,
      String description,
      double creditAmount,
      double debitAmount) {
    this.accountType = accountType;
    this.account = account;
    this.currencyCode = currencyCode;
    this.operationDate = operationDate;
    this.referenceNumber = referenceNumber;
    this.description = description;
    this.creditAmount = creditAmount;
    this.debitAmount = debitAmount;
  }

  public String getAccountType() {
    return accountType;
  }

  public void setAccountType(String accountType) {
    this.accountType = accountType;
  }

  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public String getCurrencyCode() {
    return currencyCode;
  }

  public void setCurrencyCode(String currencyCode) {
    this.currencyCode = currencyCode;
  }

  public Date getOperationDate() {
    return operationDate;
  }

  public void setOperationDate(Date operationDate) {
    this.operationDate = operationDate;
  }

  public String getReferenceNumber() {
    return referenceNumber;
  }

  public void setReferenceNumber(String referenceNumber) {
    this.referenceNumber = referenceNumber;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public double getCreditAmount() {
    return creditAmount;
  }

  public void setCreditAmount(double creditAmount) {
    this.creditAmount = creditAmount;
  }

  public double getDebitAmount() {
    return debitAmount;
  }

  public void setDebitAmount(double debitAmount) {
    this.debitAmount = debitAmount;
  }

  @Override
  public String toString() {
    return "Transaction{" +
        "accountType='" + accountType + '\'' +
        ", account='" + account + '\'' +
        ", currencyCode='" + currencyCode + '\'' +
        ", operationDate=" + operationDate +
        ", referenceNumber='" + referenceNumber + '\'' +
        ", description='" + description + '\'' +
        ", creditAmount=" + creditAmount +
        ", debitAmount=" + debitAmount +
        '}';
  }
}