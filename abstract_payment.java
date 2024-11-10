//1,2,3
import java.util.Scanner; import 
java.util.regex.Pattern;  
interface PaymentMethod   
{  
}  
boolean authorizePayment();  
String transactionStatus();  
abstract class Payment implements PaymentMethod   
{  
String paymentType;  
public Payment(String paymentType)   
{  
this.paymentType = paymentType;  
}  
public abstract void displayPaymentDetails();  
}  
class CreditCardPayment extends Payment  
{  
private String cardNumber;  
private String cardHolder;     
private String expirationDate;  
public CreditCardPayment(String cardNumber, String cardHolder, String 
expirationDate)  
{  
super("Credit Card");         
this.cardNumber = cardNumber;         
this.cardHolder = cardHolder;         
this.expirationDate = expirationDate;  
}  
public boolean isValidCardNumber()  
{  
}  
return Pattern.matches("\\d{4}-\\d{4}-\\d{4}-\\d{4}", cardNumber);  
    public boolean isValidExpirationDate()  
    {  
        return Pattern.matches("(0[1-9]|1[0-2])/\\d{2}", expirationDate);  
    }  
  
    public boolean authorizePayment()  
    {  
        return isValidCardNumber() && isValidExpirationDate();  
    }  
  
    public void displayPaymentDetails()  
    {  
        System.out.println("Payment Type: Credit Card");  
        System.out.println("Card Holder: " + cardHolder);  
        System.out.println("Card Number: " + cardNumber);  
        System.out.println("Expiration Date: " + expirationDate);  
    }  
  
    public String transactionStatus()   
    {  
        return authorizePayment() ? "Success" : "Failed";  
    }  
}  
  
class PayPalPayment extends Payment   
{  
private String email;     
private String transactionID;  
public PayPalPayment(String email, String transactionID)   
{  
super("PayPal");         
this.email = email;         
this.transactionID = 
transactionID;  
}  
public boolean isValidEmail()  
{  
return Pattern.matches("^[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$", 
email);  
}  
public boolean authorizePayment()  
{  
}  
return isValidEmail() && !transactionID.isEmpty();  
public void displayPaymentDetails()   
{  
        System.out.println("Payment Type: PayPal");  
        System.out.println("Email: " + email);  
        System.out.println("Transaction ID: " + transactionID);  
    }  
  
    public String transactionStatus()   
    {  
        return authorizePayment() ? "Success" : "Failed";  
    }  
}  
  
class Main   
{  
    public static void main(String[] args)   
    {  
        Scanner scanner = new Scanner(System.in);  
  
        String cardNumber = scanner.next();  
        String cardHolder = scanner.next();  
        String expirationDate = scanner.next();  
  
        CreditCardPayment creditCardPayment = new CreditCardPayment(cardNumber, cardHolder, expirationDate);         
creditCardPayment.displayPaymentDetails();  
System.out.println("Transaction Status: " + 
creditCardPayment.transactionStatus());  
String email = scanner.next();  
String transactionID = scanner.next();  
PayPalPayment payPalPayment = new PayPalPayment(email, 
transactionID);  
payPalPayment.displayPaymentDetails();         
System.out.println("Transaction Status: " + 
payPalPayment.transactionStatus());  
  }  
} 
