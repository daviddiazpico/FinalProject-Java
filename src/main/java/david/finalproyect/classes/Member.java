package david.finalproyect.classes;

/**
 * Represents a member, a type of person associated with the sports project.
 * Inherits characteristics from the Person class.
 */
public class Member extends Person
{
    /**
     * Constructs a new Member object with specified attributes.
     *
     * @param name     The name of the member.
     * @param dni      The DNI of the member.
     * @param age      The age of the member.
     * @param password The password for the member's account.
     */
    public Member(String name, String dni, int age, String password)
    {
        super("Member", name, dni, age, password);
    }

    /**
     * Constructs a new Member object with only a DNI.
     * This constructor can be used for comparison purposes.
     *
     * @param dni The DNI of the member.
     */
    public Member(String dni) {
        super(dni);
    }

    /**
     * Constructs a new empty Member object.
     * (Default constructor)
     */
    public Member() { }
}
