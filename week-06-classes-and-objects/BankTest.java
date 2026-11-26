// Task 4: test driver for BankAccount, covering valid and invalid operations.
public class BankTest {
    public static void main(String[] args) {
        System.out.println("=== OPENING ACCOUNT ===");
        BankAccount myAccount = new BankAccount("ACC-001", "Alice Wanjiku", 5000.00);
        System.out.println("Account Holder: " + myAccount.getAccountHolderName());
        System.out.println("Initial Balance: KSh " + myAccount.getBalance());

        System.out.println("\n=== DEPOSITING ===");
        myAccount.deposit(2500.50);
        myAccount.deposit(-100);          // fails: negative amount

        System.out.println("\n=== WITHDRAWING ===");
        myAccount.withdraw(2000);
        myAccount.withdraw(10000);        // fails: insufficient funds
        myAccount.withdraw(-50);          // fails: negative amount

        System.out.println("\n=== FINAL STATE ===");
        System.out.println("Final Balance: KSh " + myAccount.getBalance());
    }
}
