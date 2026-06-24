package parkinglot;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    private final int floorNumber;
    private List<ParkingSpot> parkingSpots;

    public Floor(int floorNumber, int numSpots) {
        this.floorNumber = floorNumber;
        this.parkingSpots = new ArrayList<>();

        // Create parking spots - alternate between TWO_WHEELER and FOUR_WHEELER
        for(int i = 0; i < numSpots; i++) {
            VehicleType type = (i % 2 == 0) ? VehicleType.TWO_WHEELER : VehicleType.FOUR_WHEELER;
            ParkingSpot spot = new ParkingSpot(i + 1, type);
            parkingSpots.add(spot);
        }
    }

    public ParkingSpot findAvailableSpot(VehicleType vehicleType) {
        for(ParkingSpot spot : parkingSpots) {
            if(spot.isAvailable() && spot.getVehicleType() == vehicleType) {
                return spot;
            }
        }
        return null;  // No available spot found
    }

    public boolean parkVehicle(Vehicle vehicle) {
        ParkingSpot availableSpot = findAvailableSpot(vehicle.getVehicleType());
        if(availableSpot != null) {
            availableSpot.parkVehicle(vehicle);
            return true;
        }
        return false;  // No spot available for this vehicle type
    }

    public boolean unparkVehicle(Vehicle vehicle) {
        for(ParkingSpot spot : parkingSpots) {
            if(spot.getVehicle() == vehicle) {
                spot.unparkVehicle();
                return true;
            }
        }
        return false;  // Vehicle not found
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public int getAvailableSpotCount() {
        int count = 0;
        for(ParkingSpot spot : parkingSpots) {
            if(spot.isAvailable()) {
                count++;
            }
        }
        return count;
    }

    public ParkingSpot findParkingSpot(Vehicle vehicle) {
        for(ParkingSpot spot : parkingSpots) {
            if(spot.getVehicle() == vehicle) {
                return spot;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "floorNumber=" + floorNumber +
                ", totalSpots=" + parkingSpots.size() +
                ", availableSpots=" + getAvailableSpotCount() +
                '}';
    }
}