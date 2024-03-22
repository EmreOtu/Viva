import java.util.ArrayList;

public class Question4 {

    // Section B Question 1
    public static void main(String[] args) {
        ArrayList<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < Viva.airbusA380.size(); i++) {

            String postcode, email;

            try {
                postcode = Viva.airbusA380.get(i).person.postcode;
                email = Viva.airbusA380.get(i).person.email;

                if (isPostcodeValid(postcode) && isEmailValid(email)) {
                    // Add current index to indexes
                    indexes.add(i);
                }

            } catch (NullPointerException e) {
                // Executed if the current person is null!
                System.out.println("Current Person is Null!");
            }

        }

        System.out.println(indexes);
    }

    private static boolean isPostcodeValid(String postcode) {

        // Check if current letter is NOT letter or digit!
        for (char c : postcode.toCharArray()) {
            if (!(Character.isLetter(c) || Character.isDigit(c))) {
                return false;
            }
        }

        return true;
    }

    private static boolean isEmailValid(String email) {

        String[] invalidDomains = {"protonmail.com", "zoho.com", "yandex.com", "mail.com"};

        for (char c : email.toCharArray()) {
            // Check if current letter is @ or . skip
            if (c == '@' || c == '.') {
                continue;
            }

            // Check if current letter is NOT letter or digit!
            if (!(Character.isLetter(c) || Character.isDigit(c))) {
                return false;
            }
        }

        // Check if domain is an invalid domain!
        String[] emailParts = email.split("@");
        for (String domain : invalidDomains) {
            if (domain.equals(emailParts[1])) {
                return false;
            }
        }

        return true;
    }

}
