package david.finalproyect.classes;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Represents a reservation made by a person.
 */
public class Reservation implements Comparable<Reservation>
{
    /** The person making the reservation. */
    Person person;

    /** The number of the tennis court reserved. */
    int numCourt;

    /** The date and time of the reservation. */
    LocalDate dateReservation;

    /**
     * Constructs a new Reservation object.
     *
     * @param person   The person making the reservation.
     * @param numCourt The number of the tennis court reserved.
     */
    public Reservation(Person person, int numCourt)
    {
        this.person = person;
        this.numCourt = numCourt;
        this.dateReservation = LocalDate.now();
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getNumCourt() {
        return numCourt;
    }

    public void setNumCourt(int numCourt) {
        this.numCourt = numCourt;
    }

    public LocalDate getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(LocalDate dateReservation) {
        this.dateReservation = dateReservation;
    }

    /**
     * Returns a string representation of the reservation.
     *
     * @return A string representing the reservation in the format:
     *         "Person - Court Number - Date and Time"
     */
    @Override
    public String toString()
    {
        return person.getName() + " - " + numCourt + " - " + dateReservation;
    }

    /**
     * Compares this reservation to another object.
     *
     * @param o The object to compare to.
     * @return {@code true} if the objects are equal; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return numCourt == that.numCourt && Objects.equals(person.getDni(), that.person.getDni());
    }

    /**
     * Generates a hash code for the reservation.
     *
     * @return The hash code.
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(person, numCourt);
    }

    @Override
    public int compareTo(Reservation o)
    {
        return this.dateReservation.compareTo(o.dateReservation);
    }
}
