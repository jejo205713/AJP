CONSTRUCTORS
//1
import java.util.*;

class BankAcc {
    int accountNumber;
    float accountBalance;

    public BankAcc(int accountNumber, float accountBalance) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }

    void display() {
        if (accountNumber >= -500 && accountNumber <= 500 && accountBalance >= -1000.00 && accountBalance <= 1000.00) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (!sc.hasNextInt()) {
            System.out.println("Invalid input");
            return;
        }
        int accountNumber = sc.nextInt();

        if (!sc.hasNextFloat()) {
            System.out.println("Invalid input");
            return;
        }
        float accountBalance = sc.nextFloat();

        BankAcc obj = new BankAcc(accountNumber, accountBalance);
        obj.display();
    }
}


//2
import java.util.Scanner;

class Book {
    String title;
    String author;

    // Default constructor with default book details
    public Book() {
        this.title = "Unknown Title";
        this.author = "Unknown Author";
    }

    // Parameterized constructor with custom details
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Method to check if this book matches a given title and author
    public boolean matches(String title, String author) {
        return this.title.equalsIgnoreCase(title) && this.author.equalsIgnoreCase(author);
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creating books
        Book book1 = new Book();  // Book with default details
        String inputTitle = scanner.nextLine();
        String inputAuthor = scanner.nextLine();

        // Validating input for special characters
        if (!isValidInput(inputTitle) || !isValidInput(inputAuthor)) {
            System.out.println("Invalid input");
            return;
        }

        // Creating a custom book with the user-provided details
        Book book2 = new Book(inputTitle, inputAuthor);

        // Taking user input for verification
        String verifyTitle = scanner.nextLine();
        String verifyAuthor = scanner.nextLine();

        // Validating input for special characters
        if (!isValidInput(verifyTitle) || !isValidInput(verifyAuthor)) {
            System.out.println("Invalid input");
            return;
        }

        // Checking if the book exists among the two books created
        boolean exists = book1.matches(verifyTitle, verifyAuthor) || book2.matches(verifyTitle, verifyAuthor);

        System.out.println(exists);
    }

    // Method to validate input for special characters
    private static boolean isValidInput(String input) {
        return input.matches("[a-zA-Z0-9 ]*") && input.length() <= 50;
    }
}

//3
import java.util.Scanner;

class Student {
    String name;
    int grade;

    // Constructor to initialize name and grade
    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read name and grade to add the student
        String name1 = sc.next();
        
        if (!sc.hasNextInt()) {
            System.out.println("Invalid input");
            return;
        }
        int grade1 = sc.nextInt();

        // Read name and grade to check
        String name2 = sc.next();
        
        if (!sc.hasNextInt()) {
            System.out.println("Invalid input");
            return;
        }
        int grade2 = sc.nextInt();

        // Check if grades are within the valid range
        if (grade1 < 0 || grade1 > 100 || grade2 < 0 || grade2 > 100) {
            System.out.println("Invalid input");
            return;
        }

        // Create a student record
        Student student = new Student(name1, grade1);

        // Use if-else to check if the student record exists
        if (student.name.equals(name2) && student.grade == grade2) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}

_____________________________________________________________________________

METHOD OVERLOADING AND OVERRIDING
//1,2,3
import java.util.Scanner; class 
Library   
{  
    public void addBook(String title, String author, int year)   
    {  
        if (isValidInput(title, author, year))   
        {  
            System.out.println("Book Added:");  
            System.out.println("Title: " + title);  
            System.out.println("Author: " + author);  
            System.out.println("Year: " + year);  
            System.out.println();  
        }          
else  
        {  
            System.out.println("Invalid book information.");  
        }  
    }  
  
    protected boolean isValidInput(String title, String author, int year)  
    {  
        return !title.isEmpty() && !author.isEmpty() && (year >= 1000 && 
year <= 9999);  
    }  
}  
  
class DigitalLibrary extends Library  
{  
    public void addBook(String title, String author, int year, String format, 
String downloadLink)  
    {  
        if (isValidInput(title, author, year) && isValidDigitalInput(format, 
downloadLink))   
        {  
            System.out.println("Digital Book Added:");  
            System.out.println("Title: " + title);  
            System.out.println("Author: " + author);  
            System.out.println("Year: " + year);  
            System.out.println("Format: " + format);  
            System.out.println("Download link: " + downloadLink);  
        }          
else  
        {  
            System.out.println("Invalid digital book information.");  
        }  
    }  
  
    private boolean isValidDigitalInput(String format, String downloadLink)  
    {  
        String[] validFormats = {"PDF", "TXT","ODT", "XSL"};         
for (String validFormat : validFormats)  
        {  
            if (format.equals(validFormat) && !downloadLink.isEmpty())  
            {  
                return true;  
            }  
        }  
        return false;  
    }  
}  
  
class Main  
{  
    public static void main(String[] args)  
    {  
        Scanner sc = new Scanner(System.in);  
  
        String physicalTitle = sc.nextLine();         
String physicalAuthor = sc.nextLine();         int 
physicalYear = sc.nextInt();         
sc.nextLine();  
          
        Library library = new Library();  
        library.addBook(physicalTitle, physicalAuthor, physicalYear);  
  
       String digitalTitle = sc.nextLine();  
       String digitalAuthor = sc.nextLine();         
        int digitalYear = sc.nextInt(); 
        sc.nextLine();  
        String digitalFormat = sc.nextLine();  
        String downloadLink = sc.nextLine();  
  
        DigitalLibrary digitalLibrary = new DigitalLibrary(); 
        digitalLibrary.addBook(digitalTitle, digitalAuthor, digitalYear, 
digitalFormat, downloadLink);  
    }  
}

_____________________________________________________________________________

INHERITANCE

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


//2,3
import java.util.Scanner;

// Base class Student
class Student {
    String name;
    String id;
    int[] grades;

    public Student(String name, String id, int[] grades) {
        this.name = name;
        this.id = id;
        this.grades = grades;
    }

    // Method to calculate the average grade
    public double calculateAverage() {
        int sum = 0;
        for (int grade : grades) {
            if (grade < 0 || grade > 100) {
                return -1; // Invalid grade
            }
            sum += grade;
        }
        return sum / (double) grades.length;
    }
}

// Subclass for Undergraduate students
class UndergraduateStudent extends Student
{
    public UndergraduateStudent(String name, String id, int[] grades) {
        super(name, id, grades);
    }
}

// Subclass for Postgraduate students
class PostgraduateStudent extends Student {
    public PostgraduateStudent(String name, String id, int[] grades) {
        super(name, id, grades);
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String studentType = scanner.nextLine();

        // Check if the student type is valid
        if (!studentType.equalsIgnoreCase("Undergraduate") && !studentType.equalsIgnoreCase("Postgraduate")) {
            System.out.println("Invalid input");
            return;
        }

        // Input name, ID, and number of grades
        String name = scanner.nextLine();

        String id = scanner.nextLine();

        int numGrades;
        try {
            numGrades = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input");
            return;
        }

        // Input grades
        int[] grades = new int[numGrades];
        for (int i = 0; i < numGrades; i++) {
            try {
                grades[i] = Integer.parseInt(scanner.nextLine());
                if (grades[i] < 0 || grades[i] > 100) {
                    System.out.println("Invalid input");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
                return;
            }
        }

        // Create the appropriate student object
        Student student;
        if (studentType.equalsIgnoreCase("Undergraduate")) {
            student = new UndergraduateStudent(name, id, grades);
        } else {
            student = new PostgraduateStudent(name, id, grades);
        }

        // Calculate and display the average grade
        double average = student.calculateAverage();
        if (average == -1) {
            System.out.println("Invalid input");
        } else {
            System.out.printf("Average grade: %.2f%n", average);
        }
    }
}

_____________________________________________________________________________

ABSTRACT AND INTERFACE

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

_____________________________________________________________________________

COLLECTION INTERFACE

//1,2,3
import java.util.*; class 
Classroom   
{  
private List<Map<String, String>> attendanceList;     
public Classroom()  
{  
    attendanceList = new ArrayList<>();  
}  

public void addStudent(String studentName)   
{  
Map<String, String> studentRecord = new HashMap<>();         
studentRecord.put("Name", studentName);         
studentRecord.put("Status", "Absent");          
attendanceList.add(studentRecord);  
System.out.println("Student " + studentName + " has been added.");  
}  
  
    public void markAttendance(String studentName, String status)   
    {  
        boolean studentFound = false;  
        for (Map<String, String> studentRecord : attendanceList)   
        {  
            if (studentRecord.get("Name").equals(studentName))   
            {  
                studentRecord.put("Status", status);                 
studentFound = true;  
                System.out.println("Attendance for " + studentName + " has been marked as " + status + ".");  
                break;  
            }  
        }  
        if (!studentFound){  
            System.out.println("Student " + studentName + " not found.");  
        }  
    }  
  
    public void displayAttendance()   
    {  
        System.out.println("\nAttendance Records:");         for 
(Map<String, String> studentRecord : attendanceList) {  
            System.out.println("Student: " + studentRecord.get("Name") + " | Status: " + studentRecord.get("Status"));  
        }  
    }  
  
    public static void main(String[] args)   
   {  
        Scanner scanner = new Scanner(System.in);  
        Classroom classroom = new Classroom();  
  
        String studentName = scanner.nextLine();         
       classroom.addStudent(studentName);  
  
        studentName = scanner.nextLine();         
        String status = scanner.nextLine();  
        classroom.markAttendance(studentName, status);  
  
        classroom.displayAttendance();  
    }  
}  

_____________________________________________________________________________

MULTITHREADING

//1
import java.util.Scanner;

// Runnable class to calculate sum and average for a dataset
class DatasetCalculator implements Runnable {
    private int datasetId;
    private int[] numbers;

    public DatasetCalculator(int datasetId, int[] numbers) {
        this.datasetId = datasetId;
        this.numbers = numbers;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        double average = (double) sum / numbers.length;
        System.out.printf("Result for dataset %d: Sum = %d, Average = %.2f%n", datasetId, sum, average);
    }
}

// Main class
public class DataAnalysisMultithreading {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int s = scanner.nextInt();

        // Loop through each dataset and start a new thread
        for (int i = 0; i < s; i++) 
        {
            int datasetId = scanner.nextInt();

            int numValues = scanner.nextInt();

            int[] numbers = new int[numValues];
            for (int j = 0; j < numValues; j++) 
            {
                numbers[j] = scanner.nextInt();
            }

            // Create and start a thread for each dataset
            Thread thread = new Thread(new DatasetCalculator(datasetId, numbers));
            thread.start();
            
            // Optional: Wait for each thread to finish if needed
            try 
            {
                thread.join();
            } 
            catch (InterruptedException e) 
            {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        }

    }
}

//Input:
2
1
3
10 20 30
2
4
5 15 25 35

//Output:
Result for dataset 1: Sum = 60, Average = 20.00
Result for dataset 2: Sum = 80, Average = 20.00



//2

import java.util.Scanner;

// Class to handle ticket booking
class TicketBookingSystem {
    private int totalTickets;

    public TicketBookingSystem(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    // Synchronized method to handle booking requests
    public synchronized void bookTicket(int userId, int ticketsRequested) {
        if (ticketsRequested <= totalTickets) {
            totalTickets -= ticketsRequested;
            System.out.println("User " + userId + ": Booking Success for " + ticketsRequested + " tickets.");
        } else {
            System.out.println("User " + userId + ": Booking Failed. Not enough tickets available.");
        }
    }

    public int getRemainingTickets() {
        return totalTickets;
    }
}

// Runnable class to represent each user's booking attempt
class UserBooking implements Runnable {
    private TicketBookingSystem bookingSystem;
    private int userId;
    private int ticketsRequested;

    public UserBooking(TicketBookingSystem bookingSystem, int userId, int ticketsRequested) {
        this.bookingSystem = bookingSystem;
        this.userId = userId;
        this.ticketsRequested = ticketsRequested;
    }

    @Override
    public void run() {
        bookingSystem.bookTicket(userId, ticketsRequested);
    }
}

// Main class
class Main
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalTickets = scanner.nextInt();
        
        int numUsers = scanner.nextInt();

        TicketBookingSystem bookingSystem = new TicketBookingSystem(totalTickets);
        Thread[] threads = new Thread[numUsers];

        // Create threads for each user's booking request
        for (int i = 0; i < numUsers; i++) {
            int userId = scanner.nextInt();
            int ticketsRequested = scanner.nextInt();

            threads[i] = new Thread(new UserBooking(bookingSystem, userId, ticketsRequested));
            threads[i].start();
        }

        // Wait for all threads to finish
        for (int i = 0; i < numUsers; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        }

        // Display remaining tickets after all bookings
        System.out.println("Remaining tickets: " + bookingSystem.getRemainingTickets());

        scanner.close();
    }
}

//Input:
10
3
1 5
2 4 
3 3

//Output:
User 1: Booking Success for 5 tickets.
User 3: Booking Success for 3 tickets.
User 2: Booking Failed. Not enough tickets available.
Remaining tickets: 2


//3
import java.util.Scanner;

class FileProcessor {
    private String filename;
    private String content;

    public FileProcessor(String filename, String content) {
        this.filename = filename;
        this.content = content;
    }

    public void processFile() {
        Thread readThread = new Thread(() -> read());
        Thread transformThread = new Thread(() -> transform());
        Thread saveThread = new Thread(() -> save());

        try {
            readThread.start();
            readThread.join();  // Ensure reading completes before transforming
            transformThread.start();
            transformThread.join();  // Ensure transforming completes before saving
            saveThread.start();
            saveThread.join();  // Ensure saving completes for final output
        } catch (InterruptedException e) {
            System.out.println("Processing interrupted for file: " + filename);
        }
    }

    private void read() {
        System.out.println("Reading file: " + filename);
    }

    private void transform() {
        content = content.toUpperCase();  // Example transformation
        System.out.println("Transforming content for file: " + filename);
    }

    private void save() {
        System.out.println("Saving file: " + filename + " with content: " + content);
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        for (int i = 0; i < m; i++)
        {
            String filename = scanner.nextLine();
            String content = scanner.nextLine();

            FileProcessor processor = new FileProcessor(filename, content);
            processor.processFile();
        }

    }
}

//Input:
2
java1.txt
hello world
java2.txt
multithreading
//Output:
Reading file: java1.txt
Transforming content for file: java1.txt
Saving file: java1.txt with content: HELLO WORLD
Reading file: java2.txt
Transforming content for file: java2.txt
Saving file: java2.txt with content: MULTITHREADING

_____________________________________________________________________________

EXCEPTION HANDLING

//1,2,3
import java.util.Scanner;

public class ArrayOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
           
            int n = scanner.nextInt();

            int[] array = new int[n];
          
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }

          
            int divisor = scanner.nextInt();

           
            int index = scanner.nextInt();

           
            if (divisor == 0) {
                System.out.println("Invalid input");
                return;
            }

            
            System.out.print("Elements after division: ");
            for (int i = 0; i < n; i++) {
                System.out.print(array[i] / divisor + " ");
            }
            System.out.println();

           
            if (index < 0 || index >= n) {
                System.out.println("Invalid input");
                return;
            }

          
            System.out.println("Element at index " + index + ": " + array[index]);

            
            double sum = 0;
            for (int i = 0; i < n; i++) {
                sum += array[i];
            }
            System.out.printf("Average of elements: %.2f\n", sum / n);

        } catch (Exception e) {
            System.out.println("Invalid input"); 
        } finally {
            scanner.close();
        }
    }
}
//Input:
5
10 20 30 40 50
5
2

_____________________________________________________________________________

SWINGS

//1
package Swings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab1 extends JFrame implements ActionListener {
    private JTextField textField1, textField2;
    private JButton addButton, subtractButton, multiplyButton, divideButton;
    private JLabel resultLabel;

    public Lab1() {
        // Setting up the JFrame
        setTitle("Basic Calculator");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 5, 5));

        // Initializing components
        JLabel label1 = new JLabel("Enter Number 1:");
        textField1 = new JTextField();
        JLabel label2 = new JLabel("Enter Number 2:");
        textField2 = new JTextField();

        addButton = new JButton("Add");
        subtractButton = new JButton("Subtract");
        multiplyButton = new JButton("Multiply");
        divideButton = new JButton("Divide");
        
        resultLabel = new JLabel("Result: ");
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Adding components to JFrame
        add(label1);
        add(textField1);
        add(label2);
        add(textField2);
        add(addButton);
        add(subtractButton);
        add(multiplyButton);
        add(divideButton);
        add(resultLabel);

        // Adding action listeners
        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // Parse the numbers from the text fields
            int num1 = Integer.parseInt(textField1.getText());
            int num2 = Integer.parseInt(textField2.getText());
            int result = 0;

            // Determine which button was clicked and perform the calculation
            if (e.getSource() == addButton) {
                result = num1 + num2;
                resultLabel.setText("Result: " + result);
            } else if (e.getSource() == subtractButton) {
                result = num1 - num2;
                resultLabel.setText("Result: " + result);
            } else if (e.getSource() == multiplyButton) {
                result = num1 * num2;
                resultLabel.setText("Result: " + result);
            } else if (e.getSource() == divideButton) {
                if (num2 == 0) {
                    resultLabel.setText("Error: Cannot divide by zero");
                } else {
                    result = num1 / num2;
                    resultLabel.setText("Result: " + result);
                }
            }
        } catch (NumberFormatException ex) {
            resultLabel.setText("Error: Invalid input");
        }
    }

    public static void main(String[] args) {
        new Lab1();
    }
}


//2
package Swings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab2 extends JFrame implements ActionListener {
    private JTextField nameField, emailField, phoneField;
    private JPasswordField passwordField;
    private JButton submitButton;
    private JLabel messageLabel;

    public Lab2() {
        // Set up the JFrame
        setTitle("User Registration Form");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 5, 5));

        // Initialize components
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        
        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField();
        
        JLabel phoneLabel = new JLabel("Phone:");
        phoneField = new JTextField();
        
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        messageLabel = new JLabel("", SwingConstants.CENTER);

        // Add components to the JFrame
        add(nameLabel);
        add(nameField);
        add(emailLabel);
        add(emailField);
        add(phoneLabel);
        add(phoneField);
        add(passwordLabel);
        add(passwordField);
        add(submitButton);
        add(messageLabel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Get input values
        String name = nameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();
        String password = new String(passwordField.getPassword());

        // Validate inputs
        if (!isValidName(name)) {
            messageLabel.setText("Error: Invalid name");
        } else if (!isValidEmail(email)) {
            messageLabel.setText("Error: Invalid email");
        } else if (!isValidPhone(phone)) {
            messageLabel.setText("Error: Invalid phone number");
        } else if (!isValidPassword(password)) {
            messageLabel.setText("Error: Password must be at least 8 characters");
        } else {
            messageLabel.setText("Success: Registration complete!");
        }
    }

    // Validate name: only alphabetic characters allowed
    private boolean isValidName(String name) {
        return name.matches("[a-zA-Z]+");
    }

    // Validate email: must contain "@" and a domain
    private boolean isValidEmail(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    // Validate phone: numeric only, exactly 10 digits
    private boolean isValidPhone(String phone) {
        return phone.matches("\\d{10}");
    }

    // Validate password: at least 8 characters long
    private boolean isValidPassword(String password) {
        return password.length() >= 8;
    }

    public static void main(String[] args) {
        new Lab2();
    }
}


//3
package Swings;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Lab3 extends JFrame {
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;
    private JTextField taskField;
    private JButton addButton, completeButton, deleteButton;
    private ArrayList<String> completedTasks;

    public Lab3() {
        // Initialize components
        setTitle("To-Do List Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        taskField = new JTextField(20);
        addButton = new JButton("Add Task");
        completeButton = new JButton("Mark Complete");
        deleteButton = new JButton("Delete Task");
        completedTasks = new ArrayList<>();

        // Panel for task entry and buttons
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("New Task:"));
        inputPanel.add(taskField);
        inputPanel.add(addButton);

        // Panel for task list and action buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(completeButton);
        buttonPanel.add(deleteButton);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(taskList), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Add Task Action
        addButton.addActionListener(e -> addTask());
        // Mark Complete Action
        completeButton.addActionListener(e -> markTaskComplete());
        // Delete Task Action
        deleteButton.addActionListener(e -> deleteTask());

        setVisible(true);
    }

    private void addTask() {
        String task = taskField.getText().trim();

        if (task.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Task cannot be empty", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (taskListModel.contains(task)) {
            JOptionPane.showMessageDialog(this, "Task already exists", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        taskListModel.addElement(task);
        taskField.setText("");
    }

    private void markTaskComplete() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this, "Please select a task to mark as complete", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String task = taskListModel.getElementAt(selectedIndex);
        if (completedTasks.contains(task)) {
            JOptionPane.showMessageDialog(this, "Task is already marked as complete", "Info", JOptionPane.INFORMATION_MESSAGE);
        } else {
            completedTasks.add(task);
            taskListModel.set(selectedIndex, "✓ " + task);
        }
    }

    private void deleteTask() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this, "Please select a task to delete", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String task = taskListModel.getElementAt(selectedIndex);
        taskListModel.remove(selectedIndex);
        completedTasks.remove(task.replace("✓ ", ""));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Lab3::new);
    }
}


_________________________________________________________________________________________________x__________________________________________________________________________________________





