/2

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
