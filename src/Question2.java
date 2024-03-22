import java.util.ArrayList;
import java.util.Arrays;

public class Question2 {

    public static void main(String[] args) {
        ArrayList<Integer> indexes = configureData();
        ArrayList<String> filteredFlights = new ArrayList<>();

        // Loop Through Indexes List
        for(int index:indexes) {
            String[] currentLine = Viva.flights[index].split(",");

            // Validation
            if (isDateValid(currentLine[0]) && isAirportValid(currentLine[6]) && isCityValid(currentLine[7])) {
                filteredFlights.add(Arrays.toString(currentLine));
            }
        }

        // Print each row
        for(String flight:filteredFlights) {
            System.out.println(flight);
        }
    }

    private static boolean isDateValid(String dateOfFlight) {

        // Check if empty or contains space
        if (dateOfFlight.isEmpty() || dateOfFlight.contains(" ")) {
            return false;
        }

        // Check if date's length is 10 E.g. 10/11/2023 is valid, and 1/11/2023 is not valid!
        if (dateOfFlight.length() != 10) {
            return false;
        }

        // Check if date contains "/" at index of 2 and 5 E.g. 3/222/2020 is not valid!
        if (dateOfFlight.charAt(2) != '/' && dateOfFlight.charAt(5) != '/') {
            return false;
        }

        // Check if date has 3 parts
        String[] dateParts = dateOfFlight.split("/");
        if (dateParts.length != 3) {
            return false;
        }

        // Trying pars to integer E.g. 23 is valid, and 2+ is not valid!
        int day, month, year;
        try {
            day = Integer.parseInt(dateParts[0]);
            month = Integer.parseInt(dateParts[1]);
            year = Integer.parseInt(dateParts[2]);
        } catch (NumberFormatException e) {
            return false;
        }

        // Check if date suitable
        return day >= 1 && day <= 31 && month >= 1 && month <= 12 && year >= 0;
    }

    private static boolean isAirportValid(String departureAirport) {

        // Check if empty or contains space
        if (departureAirport.isEmpty() || departureAirport.contains(" ")) {
            return false;
        }

        // Check if the length is exactly 3
        if (departureAirport.length() != 3) {
            return false;
        }

        // Check if all chars are capital
        for(char c:departureAirport.toCharArray()) {
            if (!Character.isUpperCase(c)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isCityValid(String departureCity) {

        // Check if empty or contains space
        if (departureCity.isEmpty() || departureCity.contains(" ")) {
            return false;
        }

        // Check if city only contains letters, but not special chars etc.
        for (char c:departureCity.toCharArray()) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }

        // Check if the first letter is capital
        if (!Character.isUpperCase(departureCity.charAt(0))) {
            return false;
        }

        // Check if the rest is lower case
        for (int i = 1; i < departureCity.length(); i++) {
            if (!Character.isLowerCase(departureCity.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    private static ArrayList<Integer> configureData() {
        ArrayList<Integer> data = new ArrayList<>();

        for (int i = 0; i < Viva.flights.length; i++) {
            String[] currentLine = Viva.flights[i].split(",");

            double flightDuration = Double.parseDouble(currentLine[3]);
            double distance = Double.parseDouble(currentLine[4]);
            String arrivalCity = currentLine[9];

            if (flightDuration > 2.20 && distance < 4000 && "Bangkok".equals(arrivalCity)) {
                data.add(i);
            }
        }

        return data;
    }
}
