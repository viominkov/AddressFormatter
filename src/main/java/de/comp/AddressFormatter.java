package de.comp;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressFormatter {

    public static void main(String[] args) {

        AddressFormatter obj = new AddressFormatter();

        System.out.print("Please enter address to format: ");
        String input = System.console().readLine();

        String formattedAddress = obj.formatAddress(input);
        System.out.println(String.format("The address you entered is %s", formattedAddress));
    }

    /**
     * returns the formated addresd
     * @param input
     * @return
     */
    protected String formatAddress(String input) {
        HashMap<String, String> address = splitIntoStreetAndNumber(input);
        return "{“" + address.get("Street") + "”, “" + address.get("Number") + "”}";
    }

    /**
     * this method parsed the string into street and a number (with possible additional parameter)
     * @param input
     * @returns a hashmap with 2 elements - street and number
     */
    private HashMap<String, String> splitIntoStreetAndNumber(String input) {
        HashMap<String, String> address = new HashMap<>();

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(input);

        int start = 0;
        if (matcher.find()) {
            start = matcher.start();
        }

        address.put("Street", input.substring(0,start-1));
        address.put("Number", input.substring(start));

        return address;
    }
}
