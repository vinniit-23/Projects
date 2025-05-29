package ticket.booking.services;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ticket.booking.Util.UserServiceUtil;
import ticket.booking.entities.Train;
import ticket.booking.entities.User;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class UserBookingService {

    private User user;


    private List<User> userList;

    // ObjectMapper instance for JSON serialization/deserialization
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();


    private static final String USER_PATH = "app/src/main/java/ticket.booking/localDb/users.json";

    // Constructor to initialize the UserBookingService with a User object
    public UserBookingService(User user) throws Exception
    {
        this.user = user;
        // Load the user list from the JSON file
        loadUsers();

    }

    public UserBookingService() throws Exception {
        loadUsers();
    }

    public List<User> loadUsers() throws Exception
    {
        File users = new File(USER_PATH);

            return OBJECT_MAPPER.readValue(users, new TypeReference<List<User>>() {
            });

    }

    /**
     * Authenticates the user by checking if a user with the same username and password
     * exists in the user list loaded from the database.
     *
     * @return true if the user credentials are valid, false otherwise
     */
    public Boolean loginUser() {
        Optional<User> foundUser = userList.stream()
                .filter(u -> u.getName().equals(user.getName()) &&
                        UserServiceUtil.checkPassword(u.getPassword(), user.getPassword()))
                .findFirst();
        return foundUser.isPresent();
    }

    /**
     * Retrieves the user object if the user is authenticated.
     *
     * @return the authenticated User object, or null if authentication fails
     */

    public Boolean signUp(User user) {
        try {
            userList.add(user);
            saveUserListToFile();
            return Boolean.TRUE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }

    private void saveUserListToFile() throws Exception {
        File usersFile = new File(USER_PATH);
        OBJECT_MAPPER.writeValue(usersFile, userList);
    }

    public void fetchBooking() {
        user.printTickets();
    }

    public Boolean cancelBooking(String ticketId) {
        //todo: complete this function
        return Boolean.FALSE;
    }

   /* public List<Train> getTrains(String source, String destination) throws Exception{
            TrainService trainService = new TrainService();
            return trainService.searchTrains(source, destination);
            //todo:add try catch block
    } */
}