public class ReceiptDemo {
    interface Receiptable {
        String receipt();
    }

    static abstract class Payment implements Receiptable {
        private final int amount;
        Payment(int amount) {
            if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");
            this.amount = amount;
        }
        public int getAmount() { return amount; }
        protected abstract String channel();
        public String receipt() { return channel() + ": KES " + amount; }
    }

    static final class CashPayment extends Payment {
        CashPayment(int amount) { super(amount); }
        protected String channel() { return "Cash"; }
    }

    static final class CardPayment extends Payment {
        CardPayment(int amount) { super(amount); }
        protected String channel() { return "Card"; }
    }

    public static void main(String[] args) {
        Receiptable[] payments = {new CashPayment(500), new CardPayment(800)};
        for (Receiptable payment : payments) System.out.println(payment.receipt());
    }
}
