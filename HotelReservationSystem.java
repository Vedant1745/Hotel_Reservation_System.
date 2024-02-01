import java.util.ArrayList;
import java.util.Scanner;

class Room {
    private String roomNumber;
    private String category;
    private boolean isReserved;

    public Room(String roomNumber, String category) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.isReserved = false;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getCategory() {
        return category;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void reserveRoom() {
        isReserved = true;
    }

    @Override
    public String toString() {
        return "Room Number: " + roomNumber + ", Category: " + category + ", Reserved: " + isReserved;
    }
}

class Reservation {
    private String guestName;
    private Room room;
    private int duration;

    public Reservation(String guestName, Room room, int duration) {
        this.guestName = guestName;
        this.room = room;
        this.duration = duration;
    }

    public String getGuestName() {
        return guestName;
    }

    public Room getRoom() {
        return room;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Guest: " + guestName + ", " + room + ", Duration: " + duration + " days";
    }
}

class Hotel {
    private ArrayList<Room> rooms;
    private ArrayList<Reservation> reservations;

    public Hotel() {
        rooms = new ArrayList<>();
        reservations = new ArrayList<>();
        initializeRooms();
    }

    private void initializeRooms() {
        // Added rooms with different categories
        rooms.add(new Room("101", "Standard"));
        rooms.add(new Room("102", "Standard"));
        rooms.add(new Room("103", "Standard"));
        rooms.add(new Room("104", "Standard"));
        rooms.add(new Room("105", "Standard"));
        rooms.add(new Room("106", "Standard"));
        rooms.add(new Room("107", "Standard"));
        rooms.add(new Room("108", "Standard"));
        rooms.add(new Room("109", "Standard"));
        rooms.add(new Room("110", "Standard"));

        rooms.add(new Room("201", "Deluxe"));
        rooms.add(new Room("202", "Deluxe"));
        rooms.add(new Room("203", "Deluxe"));
        rooms.add(new Room("204", "Deluxe"));
        rooms.add(new Room("205", "Deluxe"));
        rooms.add(new Room("206", "Deluxe"));
        rooms.add(new Room("207", "Deluxe"));
        rooms.add(new Room("208", "Deluxe"));
        rooms.add(new Room("209", "Deluxe"));
        rooms.add(new Room("210", "Deluxe"));

        rooms.add(new Room("301", "Suite"));
        rooms.add(new Room("302", "Suite"));
        rooms.add(new Room("303", "Suite"));
        rooms.add(new Room("304", "Suite"));
        rooms.add(new Room("305", "Suite"));
        rooms.add(new Room("306", "Suite"));
        rooms.add(new Room("307", "Suite"));
        rooms.add(new Room("308", "Suite"));
        rooms.add(new Room("309", "Suite"));
        rooms.add(new Room("310", "Suite"));

    }

    public void displayAvailableRooms() {
        System.out.println("Available Rooms:");
        for (Room room : rooms) {
            if (!room.isReserved()) {
                System.out.println(room);
            }
        }
    }

    public void makeReservation(String guestName, String roomNumber, int duration) {
        Room selectedRoom = null;

        for (Room room : rooms) {
            if (room.getRoomNumber().equals(roomNumber) && !room.isReserved()) {
                selectedRoom = room;
                break;
            }
        }

        if (selectedRoom != null) {
            selectedRoom.reserveRoom();
            Reservation reservation = new Reservation(guestName, selectedRoom, duration);
            reservations.add(reservation);
            System.out.println("Reservation successful:\n" + reservation);
        } else {
            System.out.println("Room " + roomNumber + " is not available for reservation.");
        }
    }

    public void displayBookingDetails() {
        System.out.println("Booking Details:");
        for (Reservation reservation : reservations) {
            System.out.println(reservation);
        }
    }
}

public class HotelReservationSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();

        while (true) {
            System.out.println("1. Display Available Rooms");
            System.out.println("2. Make Reservation");
            System.out.println("3. Display Booking Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    hotel.displayAvailableRooms();
                    break;
                case 2:
                    System.out.print("Enter your name: ");
                    String guestName = scanner.nextLine();
                    System.out.print("Enter the room number you want to reserve: ");
                    String roomNumber = scanner.nextLine();
                    System.out.print("Enter the duration of your stay (in days): ");
                    int duration = scanner.nextInt();
                    hotel.makeReservation(guestName, roomNumber, duration);
                    break;
                case 3:
                    hotel.displayBookingDetails();
                    break;
                case 4:
                    System.out.println("Exiting the program. Thank you!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
