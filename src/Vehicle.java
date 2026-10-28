import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle<T extends Human> {
    private int maxSeats;
    private List<T> passengers = new ArrayList<>();

    public Vehicle(int maxSeats) {
        this.maxSeats = maxSeats;
    }

    public int getMaxSeats() {
        return maxSeats;
    }

    public int getOccupiedSeats() {
        return passengers.size();
    }

    public void boardPassenger(T passenger) {
        if (passengers.size() >= maxSeats) {
            throw new IllegalStateException("Усі місця зайняті (" + maxSeats + ")");
        }
        passengers.add(passenger);
    }

   public void dropPassenger(T passenger) {
        if (!passengers.remove(passenger)) {
            throw new IllegalArgumentException(passenger + " не їде в цьому транспорті");
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " (зайнято " + getOccupiedSeats() + " з " + maxSeats + ")";
    }
}
