class BankAccount {
  // data hiding
  private double balance;

  // getter methd(read)
  public double getBalance() {
    return balance;
  }

  // setter method (write)
  public void deposit(double amount) {
    if (amount > 0) {
      balance = balance + amount;
    }
  }
}

public class Capsulation {
  public static void main(String args[]) {
    BankAccount acc = new BankAccount();
    acc.deposit(1000);
    System.out.println(acc.getBalance());
  }
}
