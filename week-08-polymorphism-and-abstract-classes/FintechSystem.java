// Task 4: integrated fintech system. An abstract PaymentMethod and concrete payment types,
// processed in one loop with no if-else on the type.

abstract class PaymentMethod {
    protected String accountName;

    public PaymentMethod(String accountName) {
        this.accountName = accountName;
    }

    public abstract void processPayment(double amount);
}

class MpesaPayment extends PaymentMethod {
    private String phoneNumber;

    public MpesaPayment(String accountName, String phoneNumber) {
        super(accountName);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing M-Pesa payment of KSh " + amount + " for " + accountName);
        System.out.println("  Sending STK push to: " + phoneNumber);
    }
}

class CardPayment extends PaymentMethod {
    private String cardNumber;

    public CardPayment(String accountName, String cardNumber) {
        super(accountName);
        this.cardNumber = cardNumber;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Credit Card payment of KSh " + amount + " for " + accountName);
        System.out.println("  Charging card ending in: " + cardNumber.substring(cardNumber.length() - 4));
    }
}

// Adding a new payment type needs NO change to the processing loop below.
class BankTransferPayment extends PaymentMethod {
    private String bankName;

    public BankTransferPayment(String accountName, String bankName) {
        super(accountName);
        this.bankName = bankName;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing bank transfer of KSh " + amount + " for " + accountName);
        System.out.println("  Via: " + bankName);
    }
}

public class FintechSystem {
    public static void main(String[] args) {
        PaymentMethod[] cart = {
            new MpesaPayment("Alice", "0712345678"),
            new CardPayment("Bob", "1234567812345678"),
            new MpesaPayment("Charlie", "0798765432"),
            new BankTransferPayment("Diana", "Equity Bank")
        };

        double totalRevenue = 0.0;
        System.out.println("=== PROCESSING TRANSACTIONS ===");
        for (PaymentMethod payment : cart) {
            double amount = 1500.0;
            payment.processPayment(amount);    // the right version runs for each object
            totalRevenue += amount;
            System.out.println("-------------------------");
        }
        System.out.println("Total Revenue Collected: KSh " + totalRevenue);
    }
}
