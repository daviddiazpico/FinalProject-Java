package david.finalproyect.interfaces;

/**
 * Interface for managing reservations, allowing viewing, adding, and removing reservations.
 */
public interface IViewAddRemoveReservations {

    /**
     * Displays the list of reservations.
     * Implementations should provide logic to display reservations.
     */
    void viewReservations();

    /**
     * Adds a new reservation.
     * Implementations should provide logic to add a reservation.
     */
    void addReservation();

    /**
     * Removes existing reservations.
     * Implementations should provide logic to remove reservations.
     */
    void removeReservations();
}
