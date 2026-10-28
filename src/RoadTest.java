import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoadTest {

    @Test
    void emptyRoadHasNoHumans() {
        Road road = new Road();
        assertEquals(0, road.getCountOfHumans());
    }

    @Test
    void countsHumansInDifferentVehicles() {
        Bus bus = new Bus(30);
        bus.boardPassenger(new Human("Іван"));
        bus.boardPassenger(new Firefighter("Петро"));

        PoliceCar policeCar = new PoliceCar(4);
        policeCar.boardPassenger(new Policeman("Олег"));

        FireTruck fireTruck = new FireTruck(6);
        fireTruck.boardPassenger(new Firefighter("Сергій"));
        fireTruck.boardPassenger(new Firefighter("Тарас"));

        Road road = new Road();
        road.addCarToRoad(bus);
        road.addCarToRoad(policeCar);
        road.addCarToRoad(fireTruck);

        assertEquals(5, road.getCountOfHumans());
    }
}
