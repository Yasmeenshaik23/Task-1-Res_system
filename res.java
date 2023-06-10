import java.util.Scanner;

public class ReservationSystem {
    private static boolean[] seats;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of seats: ");
        int numSeats = scanner.nextInt();
        seats = new boolean[numSeats];
        
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Reserve a seat");
            System.out.println("2. Cancel a reservation");
            System.out.println("3. Display available seats");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    reserveSeat();
                    break;
                case 2:
                    cancelReservation();
                    break;
                case 3:
                    displayAvailableSeats();
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
    
    private static void reserveSeat() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the seat number to reserve (1-" + seats.length + "): ");
        int seatNumber = scanner.nextInt();
        
        if (seatNumber < 1 || seatNumber > seats.length) {
            System.out.println("Invalid seat number.");
        } else if (seats[seatNumber - 1]) {
            System.out.println("Seat " + seatNumber + " is already reserved.");
        } else {
            seats[seatNumber - 1] = true;
            System.out.println("Seat " + seatNumber + " reserved successfully.");
        }
    }
    
    private static void cancelReservation() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the seat number to cancel reservation (1-" + seats.length + "): ");
        int seatNumber = scanner.nextInt();
        
        if (seatNumber < 1 || seatNumber > seats.length) {
            System.out.println("Invalid seat number.");
        } else if (!seats[seatNumber - 1]) {
            System.out.println("Seat " + seatNumber + " is not reserved.");
        } else {
            seats[seatNumber - 1] = false;
            System.out.println("Reservation for seat " + seatNumber + " cancelled successfully.");
        }
    }
    
    private static void displayAvailableSeats() {
        System.out.println("\nAvailable Seats:");
        for (int i = 0; i < seats.length; i++) {
            if (!seats[i]) {
                System.out.println("Seat " + (i + 1));
            }
        }
    }
}
