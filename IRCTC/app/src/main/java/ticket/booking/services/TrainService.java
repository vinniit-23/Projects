
//todo: complete trainservice

package ticket.booking.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ticket.booking.entities.Train;
import ticket.booking.entities.User;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class TrainService {

    private Train train;

    private List<Train> trainList;

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private static final String USER_PATH = "app/src/main/java/ticket.booking/localDb/trains.json";

    public TrainService(Train train) throws Exception {
        this.train = train;
        // Load the user list from the JSON file
        loadTrains();

    }

    public TrainService()throws Exception{
        loadTrains();
    }

    public List<User> loadTrains() throws Exception
    {
        File users = new File(USER_PATH);

        return OBJECT_MAPPER.readValue(users, new TypeReference<List<User>>() {
        });

    }

    public List<Train> searchTrains(String source, String destination) {
        return trainList.stream().filter(train -> validTrain(train, source, destination)).collect(Collectors.toList());
    }

    private boolean validTrain(Train train, String source, String destination) {
        List<String> stationOrder = train.getStations();

        int sourceIndex = stationOrder.indexOf(source.toLowerCase());
        int destinationIndex = stationOrder.indexOf(destination.toLowerCase());

        return sourceIndex != -1 && destinationIndex != -1 && sourceIndex < destinationIndex;

    }
}
