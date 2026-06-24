package parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<Floor> floors;
    private int ticketCounter;

    public ParkingLot(int numFloors, int spotsPerFloor) {
        this.floors = new ArrayList<>();
        this.ticketCounter = 0;

        // Create all floors
        for(int i = 1; i <= numFloors; i++) {
            Floor floor = new Floor(i, spotsPerFloor);
            floors.add(floor);
        }
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        // Try to park in each floor
        for(Floor floor : floors) {
            if(floor.parkVehicle(vehicle)) {
                // Find the spot where vehicle was just parked
                ParkingSpot spot = floor.findParkingSpot(vehicle);  // ✓ CORRECT!

                // Generate ticket
                String ticketId = generateTicketId();
                Ticket ticket = new Ticket(ticketId, vehicle, spot, floor);

                System.out.println("Vehicle parked successfully. " + ticket);
                return ticket;
            }
        }

        System.out.println("No available spot for vehicle: " + vehicle.getLicencePlate());
        return null;
    }

    public boolean unparkVehicle(Ticket ticket) {
        if(ticket == null) {
            System.out.println("Invalid ticket");
            return false;
        }

        Floor floor = ticket.getFloor();
        Vehicle vehicle = ticket.getVehicle();

        // Unpark from the floor
        if(floor.unparkVehicle(vehicle)) {
            ticket.markExit();
            System.out.println("Vehicle unparked successfully. " + ticket);
            return true;
        }

        System.out.println("Failed to unpark vehicle");
        return false;
    }

    public int getAvailableSpotCount() {
        int totalAvailable = 0;
        for(Floor floor : floors) {
            totalAvailable += floor.getAvailableSpotCount();
        }
        return totalAvailable;
    }

    public void displayParkingLotStatus() {
        System.out.println("\n========== PARKING LOT STATUS ==========");
        System.out.println("Total Floors: " + floors.size());
        System.out.println("Total Available Spots: " + getAvailableSpotCount());
        System.out.println();

        for(Floor floor : floors) {
            System.out.println(floor);
        }
        System.out.println("=========================================\n");
    }

    private String generateTicketId() {
        ticketCounter++;
        return "T" + String.format("%03d", ticketCounter);  // T001, T002, T003, etc.
    }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "totalFloors=" + floors.size() +
                ", availableSpots=" + getAvailableSpotCount() +
                '}';
    }
}