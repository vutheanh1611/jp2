import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.*;

public class Main {
    private static PriorityQueue<Passenger> passengers = new PriorityQueue<>(Comparator.comparing(Passenger::getId));
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Airline Reservation System Menu:");
            System.out.println("1. Add reservation.");
            System.out.println("2. Modify passenger records.");
            System.out.println("3. Display passenger records.");
            System.out.println("4. Exit.");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addReservation(scanner);
                    break;
                case 2:
                    modifyPassengerRecord(scanner);
                    break;
                case 3:
                    displayPassengerRecords();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
    }

    private static void addReservation(Scanner scanner) {
        System.out.print("Enter Reservation ID: ");
        String id = scanner.next();

        System.out.print("Enter Passenger Name: ");
        String name = scanner.next();

        System.out.print("Enter Address: ");
        String address = scanner.next();

        System.out.print("Enter Phone: ");
        String phone = scanner.next();

        System.out.print("Enter Date of Departure: ");
        String departureDate = scanner.next();

        System.out.print("Enter Date of Return: ");
        String returnDate = scanner.next();

        Passenger passenger = new Passenger(id, name, address, phone, departureDate, returnDate);
        passengers.add(passenger);

    }
    private static void modifyPassengerRecord(Scanner scanner) {
        System.out.print("Enter Passenger ID: ");
        String id = scanner.next();

        // Tìm kiếm hành khách trong hàng đợi
        Passenger passenger = null;
        for (Passenger p : passengers) {
            if (p.getId().equals(id)) {
                passenger = p;
                break;
            }
        }

        if (passenger != null) {
            System.out.println("Passenger Found:");
            System.out.println(passenger);

            System.out.print("Enter new Passenger Name: ");
            String name = scanner.next();

            System.out.print("Enter new Address: ");
            String address = scanner.next();

            System.out.print("Enter new Phone: ");
            String phone = scanner.next();

            System.out.print("Enter new Date of Departure: ");
            String departureDate = scanner.next();

            System.out.print("Enter new Date of Return: ");
            String returnDate = scanner.next();

            // Cập nhật thông tin hành khách
            passenger.setName(name);
            passenger.setAddress(address);
            passenger.setPhone(phone);
            passenger.setDepartureDate(departureDate);
            passenger.setReturnDate(returnDate);

            System.out.println("Passenger record updated successfully.");
        } else {
            System.out.println("Passenger not found.");
        }
    }

    private static void displayPassengerRecords() {
        System.out.println("Passenger Records:");
        while (!passengers.isEmpty()){
            Passenger p = passengers.poll();
            System.out.println(p);

        }
    }
}