package parkinglot;

public class ParkingSpot {

    private final int spotId;
    private final VehicleType vehicleType;
    private Vehicle vehicle;

    public ParkingSpot(int spotId, VehicleType vehicleType){
        this.spotId= spotId;
        this.vehicleType=vehicleType;
    }


    public boolean isAvailable(){
           return vehicle==null;
    }

    public void parkVehicle(Vehicle vehicle){
        if(isAvailable()){
            this.vehicle=vehicle;
        }else{
            System.out.println("Occupied");
        }
    }

    public Vehicle unparkVehicle(){
        Vehicle removedVehicle = this.vehicle;
        this.vehicle=null;
        return removedVehicle;
    }

    public int getSpotId() {
        return spotId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "spotId=" + spotId +
                ", vehicleType=" + vehicleType +
                ", vehicle=" + vehicle +
                '}';
    }
}
