
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
