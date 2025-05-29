package ticket.booking.entities;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.Date;

/**
 * Represents a ticket booked by a user for a train journey.
 * Contains details such as ticket ID, user ID, source, destination,
 * date of travel, and the associated train.
 */
public class Ticket {

    /** Unique identifier for the ticket */
    private String ticketId;

    /** ID of the user who booked the ticket */
    private String userId;

    /** Source station of the journey */
    private String source;

    /** Destination station of the journey */
    private String destination;

    /** Date of travel */
    private Date dateOfTravel;

    /** Train associated with the ticket */
    private Train train;

    /**
     * Default constructor for deserialization.
     */
    public Ticket() {
    }

    /**
     * Constructs a Ticket with all details.
     *
     * @param ticketId     Unique ticket ID
     * @param userId       User ID of the ticket holder
     * @param source       Source station
     * @param destination  Destination station
     * @param dateOfTravel Date of travel
     * @param train        Associated train
     */
    public Ticket(String ticketId, String userId, String source, String destination, Date dateOfTravel, Train train) {
        this.dateOfTravel = dateOfTravel;
        this.ticketId = ticketId;
        this.destination = destination;
        this.source = source;
        this.userId = userId;
        this.train = train;
    }

    /**
     * Sets the user ID for this ticket.
     * @param userId User ID
     */
    @JsonSetter
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Gets the ticket ID.
     * @return Ticket ID
     */
    @JsonGetter
    public String getTicketId() {
        return ticketId;
    }

    /**
     * Gets the destination station.
     * @return Destination station
     */
    @JsonGetter
    public String getDestination() {
        return destination;
    }

    /**
     * Gets the date of travel.
     * @return Date of travel
     */
    @JsonGetter
    public Date getDateOfTravel() {
        return dateOfTravel;
    }

    /**
     * Gets the source station.
     * @return Source station
     */
    @JsonGetter
    public String getSource() {
        return source;
    }

    /**
     * Gets the user ID.
     * @return User ID
     */
    @JsonGetter
    public String getUserId() {
        return userId;
    }

    /**
     * Gets the associated train.
     * @return Train object
     */
    @JsonGetter
    public Train getTrain() {
        return train;
    }

    /**
     * Sets the date of travel.
     * @param dateOfTravel Date of travel
     */
    @JsonSetter
    public void setDateOfTravel(Date dateOfTravel) {
        this.dateOfTravel = dateOfTravel;
    }

    /**
     * Sets the ticket ID.
     * @param ticketId Ticket ID
     */
    @JsonSetter
    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    /**
     * Sets the destination station.
     * @param destination Destination station
     */
    @JsonSetter
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * Sets the source station.
     * @param source Source station
     */
    @JsonSetter
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * Sets the associated train.
     * @param train Train object
     */
    @JsonSetter
    public void setTrain(Train train) {
        this.train = train;
    }

    /**
     * Returns a formatted string with ticket information.
     * @return Ticket information string
     */
    public String getTicketInfo() {
        return String.format("Ticket Id: %s belongs to User %s to %s to %s on %s", ticketId, userId, source, destination, dateOfTravel);
    }
}