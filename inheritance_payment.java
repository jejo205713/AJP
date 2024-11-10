//1
import java.util.Scanner;

// Base class for payment
class Payment {
    double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    // Method to calculate final amount (to be overridden by subclasses)
    public double calculateFinalAmount() {
        return amount;
    }
}

// Subclass for Credit Card payment with a 2% fee
class CreditCardPayment extends Payment {
    public CreditCardPayment(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount + (amount * 0.02);  // 2% fee
    }
}

// Subclass for Debit Card payment with a $1.00 flat fee
class DebitCardPayment extends Payment {
    public DebitCardPayment(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount + 1.00;  // $1.00 flat fee
    }
}

// Subclass for PayPal payment with no additional fee
class PayPalPayment extends Payment {
    public PayPalPayment(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount;  // No additional fee
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reading amount and payment method
        double amount = scanner.nextDouble();
        scanner.nextLine();  // Consume newline

        String method = scanner.nextLine().toLowerCase();

        // Check for valid input
        if (amount < -200.0 || amount > 200.0 || amount < 0) {
            System.out.println("Invalid input");
            return;
        }

        // Choose the appropriate payment method
        Payment payment;
        switch (method) {
            case "credit":
                payment = new CreditCardPayment(amount);
                break;
            case "debit":
                payment = new DebitCardPayment(amount);
                break;
            case "paypal":
                payment = new PayPalPayment(amount);
                break;
            default:
                System.out.println("Invalid input");
                return;
        }

        // Calculate and display the final amount charged
        System.out.printf("Final amount charged: $%.2f%n", payment.calculateFinalAmount());
    }
}
