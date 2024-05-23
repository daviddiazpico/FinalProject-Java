package david.finalproyect.classes;

/**
 * Represents a coach, a type of person associated with the sports project.
 * Inherits characteristics from the Person class.
 */
public class Coach extends Person
{

    /**
     * Constructs a new Coach object with specified attributes.
     *
     * @param name     The name of the coach.
     * @param dni      The DNI of the coach.
     * @param age      The age of the coach.
     * @param password The password for the coach's account.
     */
    public Coach(String name, String dni, int age, String password)
    {
        super("Coach", name, dni, age, password);
    }

    public Coach(String dni) {
        super(dni);
    }

    /**
     * Constructs a new empty Coach object.
     * (Default constructor)
     */
    public Coach() { }
}
