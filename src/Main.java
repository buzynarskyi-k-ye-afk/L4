public class Main {
    public static void main(String[] args) {
        Bus bus = new Bus(30);
        Taxi taxi = new Taxi(4);
        PoliceCar policeCar = new PoliceCar(4);
        FireTruck fireTruck = new FireTruck(6);

        Human passenger = new Human("Іван");
        Firefighter firefighter = new Firefighter("Петро");
        Policeman policeman = new Policeman("Олег");

        bus.boardPassenger(passenger);
        bus.boardPassenger(firefighter);
        bus.boardPassenger(policeman);
        taxi.boardPassenger(new Human("Марія"));

        policeCar.boardPassenger(new Policeman("Андрій"));
        fireTruck.boardPassenger(new Firefighter("Сергій"));
        fireTruck.boardPassenger(new Firefighter("Тарас"));

        System.out.println(bus);
        System.out.println(taxi);
        System.out.println(policeCar);
        System.out.println(fireTruck);

        Road road = new Road();
        road.addCarToRoad(bus);
        road.addCarToRoad(taxi);
        road.addCarToRoad(policeCar);
        road.addCarToRoad(fireTruck);
        System.out.println("Людей на дорозі: " + road.getCountOfHumans());


        Taxi smallTaxi = new Taxi(1);
        smallTaxi.boardPassenger(new Human("Олена"));
        try {
            smallTaxi.boardPassenger(new Human("Дмитро"));
        } catch (IllegalStateException e) {
            System.out.println("Помилка посадки: " + e.getMessage());
        }

        try {
            bus.dropPassenger(new Human("Невідомий"));
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка висадки: " + e.getMessage());
        }
    }
}
