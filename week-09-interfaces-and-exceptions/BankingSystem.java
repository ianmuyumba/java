// Task 4: a custom CHECKED exception for a banking rule.

class InsufficientFundsException extends Exception {     // extends Exception, so it is checked
    private final double shortfall;

    public InsufficientFundsException(String message, double shortfall) {
        super(message);                                    // stored, returned by getMessage()
        this.shortfall = shortfall;
    }

    public double getShortfall() {
        return shortfall;
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    // 'throws' warns callers; 'throw' actually raises the exception.
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");   // unchecked: a caller bug
        }
        if (amount > balance) {
            throw new InsufficientFundsException(
                    "Withdrawal failed. Insufficient funds.", amount - balance);
        }
        balance -= amount;                                 // only reached if no exception
        System.out.println("Successfully withdrew: KSh " + amount);
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(5000.0);
        System.out.println("Current Balance: KSh " + account.getBalance());

        double[] attempts = {10000.0, 2000.0, -50.0};
        for (double amount : attempts) {
            System.out.println("\nAttempting to withdraw KSh " + amount + "...");
            try {
                account.withdraw(amount);
            } catch (InsufficientFundsException e) {
                System.out.println("TRANSACTION DECLINED!");
                System.out.println("Error Message: " + e.getMessage());
                System.out.println("You are short by: KSh " + e.getShortfall());
            } catch (IllegalArgumentException e) {
                System.out.println("INVALID REQUEST: " + e.getMessage());
            }
        }

        System.out.println("\nChecking final balance: KSh " + account.getBalance());
    }
}
