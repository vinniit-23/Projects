package ticket.booking.entities;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a user in the ticket booking system.
 * Stores user credentials, booking history, and user identification.
 */
public class User {

    /**
     * User's name
     */
    private String name;

    /**
     * User's plain password (should be hashed in production)
     */
    private String password;

    /**
     * User's hashed password
     */
    private String hashPassword;

    /**
     * List of tickets booked by the user
     */
    private List<Ticket> ticketsBooked;

    /**
     * Unique identifier for the user
     */
    private String userId;

    /**
     * Constructs a User with all details.
     *
     * @param name          User's name
     * @param password      User's password
     * @param hashPassword  User's hashed password
     * @param ticketsBooked List of booked tickets
     * @param userId        Unique user ID
     */
    public User(String name, String password, String hashPassword, List<Ticket> ticketsBooked, String userId) {
        this.name = name;
        this.password = password;
        this.hashPassword = hashPassword;
        this.ticketsBooked = ticketsBooked;
        this.userId = userId;
    }

    /**
     * Default constructor for deserialization.
     */
    public User() {
    }

    /**
     * Gets the user's name.
     *
     * @return User's name
     */
    @JsonGetter
    public String getName() {
        return name;
    }

    /**
     * Gets the user's password.
     *
     * @return User's password
     */
    @JsonGetter
    public String getPassword() {
        return password;
    }

    /**
     * Gets the user's hashed password.
     *
     * @return Hashed password
     */
    @JsonGetter
    public String getHashPassword() {
        return hashPassword;
    }

    /**
     * Gets the list of tickets booked by the user.
     *
     * @return List of tickets
     */
    @JsonGetter
    public List<Ticket> getTicketsBooked() {
        return ticketsBooked;
    }

    /**
     * Gets the user's unique ID.
     *
     * @return User ID
     */
    @JsonGetter
    public String getUserId() {
        return userId;
    }

    /**
     * Prints all tickets booked by the user to the console.
     */
    public void printTickets() {
        for (int i = 0; i < ticketsBooked.size(); i++) {
            System.out.println(ticketsBooked.get(i).getTicketInfo());
        }
    }

    /**
     * Sets the user's name.
     *
     * @param name User's name
     */
    @JsonSetter
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the user's hashed password.
     *
     * @param hashPassword Hashed password
     */
    @JsonSetter
    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }

    /**
     * Sets the user's password.
     *
     * @param password User's password
     */
    @JsonSetter
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Sets the list of tickets booked by the user.
     *
     * @param ticketsBooked List of tickets
     */
    @JsonSetter
    public void setTicketsBooked(List<Ticket> ticketsBooked) {
        this.ticketsBooked = ticketsBooked;
    }

    /**
     * Sets the user's unique ID.
     *
     * @param userId User ID
     */
    @JsonSetter
    public void setUserId(String userId) {
        this.userId = userId;
    }
}