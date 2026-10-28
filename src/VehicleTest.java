import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VehicleTest {

    @Test
    void busTakesAnyPassengers() {
        Bus bus = new Bus(10);
        bus.boardPassenger(new Human("Іван"));
        bus.boardPassenger(new Firefighter("Петро"));
        bus.boardPassenger(new Policeman("Олег"));
        assertEquals(3, bus.getOccupiedSeats());
    }

    @Test
    void taxiTakesAnyPassengers() {
        Taxi taxi = new Taxi(4);
        taxi.boardPassenger(new Human("Марія"));
        taxi.boardPassenger(new Policeman("Андрій"));
        assertEquals(2, taxi.getOccupiedSeats());
    }

    @Test
    void policeCarTakesPolicemen() {
        PoliceCar policeCar = new PoliceCar(4);
        policeCar.boardPassenger(new Policeman("Олег"));
        policeCar.boardPassenger(new Policeman("Андрій"));
        assertEquals(2, policeCar.getOccupiedSeats());
    }

    @Test
    void fireTruckTakesFirefighters() {
        FireTruck fireTruck = new FireTruck(6);
        fireTruck.boardPassenger(new Firefighter("Петро"));
        assertEquals(1, fireTruck.getOccupiedSeats());
    }

    @Test
    void maxSeatsIsReturned() {
        Bus bus = new Bus(30);
        assertEquals(30, bus.getMaxSeats());
        assertEquals(0, bus.getOccupiedSeats());
    }

    @Test
    void boardingFullVehicleThrows() {
        Taxi taxi = new Taxi(1);
        taxi.boardPassenger(new Human("Олена"));
        assertThrows(IllegalStateException.class, () -> taxi.boardPassenger(new Human("Дмитро")));
    }

    @Test
    void droppingPassengerFreesSeat() {
        Bus bus = new Bus(10);
        Human passenger = new Human("Іван");
        bus.boardPassenger(passenger);
        bus.dropPassenger(passenger);
        assertEquals(0, bus.getOccupiedSeats());
    }

    @Test
    void droppingAbsentPassengerThrows() {
        Bus bus = new Bus(10);
        bus.boardPassenger(new Human("Іван"));
        assertThrows(IllegalArgumentException.class, () -> bus.dropPassenger(new Human("Іван")));
    }
}
