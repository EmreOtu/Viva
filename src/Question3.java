import java.util.HashMap;
import java.util.Map;

public class Question3 {

    public static void main(String[] args) {
        HashMap<String, String> flights = processFlights(Viva.flights);

        // Print the HashMap If It is Needed
        for (Map.Entry<String, String> entry:flights.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }

        /*
         * I am not sure if we need to clear the data!
         * E.g. Key: AJ1678487RF Value: .5..4.2.23.19:03-Am!terdam@A<S-Johannesburg@JNB
         */
    }

    private static HashMap<String, String> processFlights(String[] flights) {
        HashMap<String, String> result = new HashMap<>();

        // Loop Through Each Flight
        for(String flight:flights) {

            String[] currentFlight = flight.split(",");
            String airline = currentFlight[11];
            String city = currentFlight[9];

            // Filter by Airline and City
            if ("Cerberus Flights".equals(airline) && "Johannesburg".equals(city)) {
                //Get Flight Number
                String flightNumber = currentFlight[10];

                // Get Important Parts and Merge if needed
                String dateOfFlight = currentFlight[0].replace("/", ".") + "." + currentFlight[1];
                String departure = currentFlight[7] + "@" + currentFlight[6];
                String arrival = currentFlight[9] + "@" + currentFlight[8];

                // Create the Value
                String hsvValue = dateOfFlight + "-" + departure + "-" + arrival;

                // Add Key and Value to our HashMap<String, String>
                result.put(flightNumber, hsvValue);
            }
        }

        return result;
    }
}
