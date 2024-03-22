import java.util.ArrayList;

public class Question1 {

    public static void main(String[] args) {
        ArrayList<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < Viva.flights.length; i++) {
            // Get the Current Line
            String[] currentLine = Viva.flights[i].split(",");

            // Get Necessary Values
            double flightDuration = Double.parseDouble(currentLine[3]);
            double distance = Double.parseDouble(currentLine[4]);
            String arrivalCity = currentLine[9];

            // Condition With Ands
            if (flightDuration > 2.20 && distance < 4000 && "Bangkok".equals(arrivalCity)) {
                // Either Print the Current Line | *Import java.util.Arrays;*
                // System.out.println(Arrays.toString(currentLine));

                // Or Add Index to the ArrayList<Integer>
                indexes.add(i);
            }
        }

        // And Print the Array Here!
        System.out.println(indexes);
    }

}
