
    package parkinglot;

import java.time.LocalDateTime;

    public class Ticket {
        private final String ticketId;
        private final Vehicle vehicle;
        private final ParkingSpot parkingSpot;
        private final Floor floor;
        private final LocalDateTime entryTime;
        private LocalDateTime exitTime;

        public Ticket(String ticketId, Vehicle vehicle, ParkingSpot parkingSpot, Floor floor) {
            this.ticketId = ticketId;
            this.vehicle = vehicle;
            this.parkingSpot = parkingSpot;
            this.floor = floor;
            this.entryTime = LocalDateTime.now();  // Automatically capture entry time
            this.exitTime = null;  // Will be set when vehicle leaves
        }

        public String getTicketId() {
            return ticketId;
        }

        public Vehicle getVehicle() {
            return vehicle;
        }

        public ParkingSpot getParkingSpot() {
            return parkingSpot;
        }

        public Floor getFloor() {
            return floor;
        }

        public LocalDateTime getEntryTime() {
            return entryTime;
        }

        public LocalDateTime getExitTime() {
            return exitTime;
        }

        public void setExitTime(LocalDateTime exitTime) {
            this.exitTime = exitTime;
        }

        public void markExit() {
            this.exitTime = LocalDateTime.now();  // Automatically capture exit time
        }

        @Override
        public String toString() {
            return "Ticket{" +
                    "ticketId='" + ticketId + '\'' +
                    ", vehicle=" + vehicle +
                    ", floor=" + floor.getFloorNumber() +
                    ", spotId=" + parkingSpot.getSpotId() +
                    ", entryTime=" + entryTime +
                    ", exitTime=" + exitTime +
                    '}';
        }
    }

