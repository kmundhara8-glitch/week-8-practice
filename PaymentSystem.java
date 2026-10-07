import java.util.Scanner;

abstract class Payment {
    protected double amount;

    Payment(double amount) {
        this.amount = amount;
    }

    abstract double calculateFinalAmount();
}

class CardPayment extends Payment {

    CardPayment(double amount) {
        super(amount);
    }

    @Override
    double calculateFinalAmount() {
        return amount + (amount * 0.02);
    }
}

class WalletPayment extends Payment {

    WalletPayment(double amount) {
        super(amount);
    }

    @Override
    double calculateFinalAmount() {
        return amount + (amount * 0.01);
    }
}

class BankTransferPayment extends Payment {

    BankTransferPayment(double amount) {
        super(amount);
    }

    @Override
    double calculateFinalAmount() {
        return amount;
    }
}

public class PaymentSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double amount = sc.nextDouble();

            Payment payment;

            if (type.equals("CARD")) {
                payment = new CardPayment(amount);
            } else if (type.equals("WALLET")) {
                payment = new WalletPayment(amount);
            } else {
                payment = new BankTransferPayment(amount);
            }

            double adjusted = payment.calculateFinalAmount();

            System.out.printf(
                "%s: %.2f%n",
                type,
                adjusted
            );

            total += adjusted;
        }

        System.out.printf(
            "Total: %.2f%n",
            total
        );

        sc.close();
    }
}