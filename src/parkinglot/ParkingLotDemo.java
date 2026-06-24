package parkinglot;

public class ParkingLotDemo {
    public static void main(String[] args) {
        // Create a parking lot with 2 floors and 4 spots per floor
        ParkingLot parkingLot = new ParkingLot(2, 4);

        System.out.println("===== PARKING LOT MANAGEMENT SYSTEM =====\n");

        // Display initial status
        parkingLot.displayParkingLotStatus();

        // Create some vehicles
        Vehicle car1 = new Vehicle("KA-01-1234", VehicleType.FOUR_WHEELER);
        Vehicle car2 = new Vehicle("KA-01-5678", VehicleType.FOUR_WHEELER);
        Vehicle bike1 = new Vehicle("KA-02-9999", VehicleType.TWO_WHEELER);
        Vehicle bike2 = new Vehicle("KA-02-8888", VehicleType.TWO_WHEELER);
        Vehicle car3 = new Vehicle("KA-03-1111", VehicleType.FOUR_WHEELER);

        // Park vehicles
        System.out.println("\n===== PARKING VEHICLES =====\n");
        Ticket ticket1 = parkingLot.parkVehicle(car1);
        Ticket ticket2 = parkingLot.parkVehicle(car2);
        Ticket ticket3 = parkingLot.parkVehicle(bike1);
        Ticket ticket4 = parkingLot.parkVehicle(bike2);
        Ticket ticket5 = parkingLot.parkVehicle(car3);

        // Display status after parking
        parkingLot.displayParkingLotStatus();

        // Try to park when lot is full
        Vehicle car4 = new Vehicle("KA-04-2222", VehicleType.FOUR_WHEELER);
        parkingLot.parkVehicle(car4);

        parkingLot.displayParkingLotStatus();

        // Unpark some vehicles
        System.out.println("\n===== UNPARKING VEHICLES =====\n");
        if(ticket1 != null) {
            parkingLot.unparkVehicle(ticket1);
        }
        if(ticket3 != null) {
            parkingLot.unparkVehicle(ticket3);
        }

        // Display final status
        parkingLot.displayParkingLotStatus();

        // Now try to park the vehicle that failed before
        System.out.println("\n===== PARKING AGAIN =====\n");
        Ticket ticket6 = parkingLot.parkVehicle(car4);

        parkingLot.displayParkingLotStatus();
    }
}