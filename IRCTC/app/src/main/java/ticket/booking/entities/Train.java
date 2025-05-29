package ticket.booking.entities;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.sql.Time;
import java.util.List;
import java.util.Map;

/**
 * Represents a train in the ticket booking system.
 * Contains details such as train ID, train number, seat layout,
 * station times, and the list of stations the train stops at.
 */
public class Train {
    /** Unique identifier for the train */
    private String trainId;

    /** Train number */
    private String trainNo;

    /** 2D list representing seat layout and availability */
    private List<List<Integer>> seats;

    /** Map of station names to their scheduled times */
    private Map<String, String> stationTimes;

    /** List of stations the train stops at */
    private List<String> stations;

    /**
     * Default constructor for deserialization.
     */
    public Train() {
    }

    /**
     * Constructs a Train with all details.
     *
     * @param trainId      Unique train ID
     * @param trainNo      Train number
     * @param seats        2D seat layout
     * @param stationTimes Map of station names to times
     * @param stations     List of stations
     */
    public Train(String trainId, String trainNo,
                 List<List<Integer>> seats, Map<String, String> stationTimes, List<String> stations) {
        this.trainId = trainId;
        this.trainNo = trainNo;
        this.seats = seats;
        this.stationTimes = stationTimes;
        this.stations = stations;
    }

    /**
     * Gets the seat layout.
     * @return 2D list of seats
     */
    @JsonGetter
    public List<List<Integer>> getSeats() {
        return seats;
    }

    /**
     * Gets the list of stations.
     * @return List of station names
     */
    @JsonGetter
    public List<String> getStations() {
        return stations;
    }

    /**
     * Gets the train ID.
     * @return Train ID
     */
    @JsonGetter
    public String getTrainId() {
        return trainId;
    }

    /**
     * Gets the train number.
     * @return Train number
     */
    @JsonGetter
    public String getTrainNo() {
        return trainNo;
    }

    /**
     * Gets the map of station times.
     * @return Map of station names to times
     */
    @JsonGetter
    public Map<String, String> getStationTimes() {
        return stationTimes;
    }

    /**
     * Sets the train ID.
     * @param trainId Train ID
     */
    @JsonSetter
    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    /**
     * Sets the seat layout.
     * @param seats 2D list of seats
     */
    @JsonSetter
    public void setSeats(List<List<Integer>> seats) {
        this.seats = seats;
    }

    /**
     * Sets the list of stations.
     * @param stations List of station names
     */
    @JsonSetter
    public void setStations(List<String> stations) {
        this.stations = stations;
    }

    /**
     * Sets the train number.
     * @param trainNo Train number
     */
    @JsonSetter
    public void setTrainNo(String trainNo) {
        this.trainNo = trainNo;
    }

    /**
     * Sets the map of station times.
     * @param stationTimes Map of station names to times
     */
    @JsonSetter
    public void setStationTimes(Map<String, String> stationTimes) {
        this.stationTimes = stationTimes;
    }

    /**
     * Returns a formatted string with train information.
     * @return Train information string
     */
    public String getTrainInfo() {
        return String.format("Train Id: %s, Train No: %s", trainId, trainNo);
    }
}