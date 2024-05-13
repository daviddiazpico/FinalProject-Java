package data;

import java.time.LocalDateTime;
import java.util.Objects;

public class Reservation
{
    Person person;
    int numCourt;
    LocalDateTime dateReservation;

    public Reservation(Person person, int numCourt)
    {
        this.person = person;
        this.numCourt = numCourt;
        dateReservation = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return numCourt == that.numCourt && Objects.equals(person.getDni(), that.person.getDni());
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, numCourt);
    }
}
