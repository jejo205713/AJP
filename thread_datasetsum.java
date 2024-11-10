/1
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
