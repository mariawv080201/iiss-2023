import java.time.*;

public final class BankAccount implements Comparable<BankAccount> {
  private final String id;
  private LocalDate creationDate;

  @Comparator(BankAccountComparatorByCreationDate.class)
  private ComparatorInterface comparator;

  public BankAccount(String number) {
    this.id = number;
  }

  public LocalDate getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(LocalDate date) {
    this.creationDate = date;
  }

  public String getId() {
    return id;
  }

  public void setComparator(ComparatorInterface cmp) {
    comparator = cmp;
  }

  @Override
  public int compareTo(BankAccount other) {
    if (this == other)
      return 0;
    assert this.equals(other) : "compareTo inconsistent with equals.";
    return comparator.compare(this, other);
  }

  @Override
  public boolean equals(Object other) {
    if (this == other)
      return true;
    if (!(other instanceof BankAccount))
      return false;
    BankAccount that = (BankAccount) other;
    return this.id.equals(that.getId());
  }

  @Override
  public String toString() {
    return id.toString();
  }
}