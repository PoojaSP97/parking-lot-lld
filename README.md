# parking-lot-lld
Low-Level Design implementation of Parking Lot System in Java

# Parking Lot LLD (Low-Level Design)

## Problem Statement
Design a parking lot management system that allows vehicles to park and unpark efficiently across multiple floors.

## Features
- ✅ Multiple floors with multiple parking spots
- ✅ Support for different vehicle types (Two-wheeler, Four-wheeler)
- ✅ Automatic ticket generation with entry/exit time tracking
- ✅ Real-time availability status per floor
- ✅ Efficient spot allocation algorithm

## System Architecture

### Class Structure
- **Vehicle** — Represents a vehicle with license plate and type
- **VehicleType** — Enum for vehicle types (TWO_WHEELER, FOUR_WHEELER)
- **ParkingSpot** — Individual parking spot with availability tracking
- **Floor** — A floor containing multiple parking spots
- **Ticket** — Generated when vehicle parks (tracks entry/exit time)
- **ParkingLot** — Main orchestrator managing all floors

### Class Diagram
ParkingLot

├── List<Floor>

├── Floor (1, 2, 3...)

├── List<ParkingSpot>

├── ParkingSpot (1, 2, 3...)

└── Vehicle (if occupied)

## Design Patterns Used
- **Composition** — ParkingLot contains Floors, Floors contain Spots
- **Enumeration** — VehicleType for type safety
- **Object Creation** — Ticket generation on parking

## Complexity Analysis
| Operation | Time | Space |
|-----------|------|-------|
| Park Vehicle | O(f) | O(1) |
| Unpark Vehicle | O(f*s) | O(1) |
| Get Status | O(f*s) | O(1) |
| Overall | O(f*s) | O(f*s) |

Where f = number of floors, s = spots per floor

## How to Run
```bash
cd /Users/poojasp/IdeaProjects/LLD\ Projects/ParkingLot
javac src/parkinglot/*.java
java -cp src parkinglot.ParkingLotDemo
```

## Sample Output

===== PARKING LOT MANAGEMENT SYSTEM =====

========== PARKING LOT STATUS ==========

Total Floors: 2

Total Available Spots: 8

Floor{floorNumber=1, totalSpots=4, availableSpots=4}

Floor{floorNumber=2, totalSpots=4, availableSpots=4}
===== PARKING VEHICLES =====
Vehicle parked successfully. Ticket{ticketId='T001', ...}

Vehicle parked successfully. Ticket{ticketId='T002', ...}

...


## Key Implementation Details
1. **Vehicle Distribution** — Automatically distributes vehicles across floors
2. **Type-based Allocation** — Alternates spot types (Two-wheeler, Four-wheeler)
3. **Ticket Tracking** — Captures entry and exit times automatically
4. **Availability Status** — Real-time count of available spots

## Future Enhancements
- [ ] Add pricing and payment logic
- [ ] Add compact vs regular spots
- [ ] Add reservation system
- [ ] Add admin dashboard
- [ ] Add database persistence
- [ ] Add multiple parking lots management

## Learning Outcomes
✅ Object-Oriented Design Principles  
✅ Class hierarchies and relationships  
✅ Design patterns (Composition, Enumeration)  
✅ Data structure usage (Lists, Enums)  
✅ Problem decomposition

## Author
Pooja S P - Backend Engineer  
GitHub: [@PoojaSP97](https://github.com/PoojaSP97)