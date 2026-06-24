package parkinglot;

public enum VehicleType {

    TWO_WHEELER(1),
    FOUR_WHEELER(1);

    private int spotsRequired;

    VehicleType(int spotsRequired){
        this.spotsRequired=spotsRequired;
    }

    public int getSpotsRequired(){
        return spotsRequired;
    }

}
