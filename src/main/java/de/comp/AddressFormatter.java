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
        // if two different numbers in the string
        int count = getNumberOfMatchedNumbers(input);
        if (count!=1 && count!=0){
            return parseStringContainingTwoNumbers(input);
        } else {
            return parseStringContainingOneNumber(input);
        }
    }

    /**
     *
     * @param input
     * @return
     */
    private HashMap<String, String> parseStringContainingOneNumber(String input) {
        HashMap<String, String> address = new HashMap<>();

        Pattern pattern = Pattern.compile("\\d+(\\s?)[a-zA-Z]?\\b");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            String s = input.replaceAll(String.valueOf(pattern), "");
            String street = trimString(s);
            String number = trimString(matcher.group());

            address.put("Street", street);
            address.put("Number", number);
        } else {
            throw new RuntimeException(String.format("Couldn't match street number in string %s", input));
        }
        return address;
    }

    /**
     *
     * @param input
     * @return
     */
    private HashMap<String, String> parseStringContainingTwoNumbers(String input) {
        HashMap<String, String> address = new HashMap<>();

        Pattern pattern = Pattern.compile("");
        Matcher matcher = pattern.matcher(input);
        return address;
    }

    /**
     * find out the count of all numbers
     * @param string
     * @return
     */
    private int getNumberOfMatchedNumbers(String string) {
        Pattern pattern_double_numbers = Pattern.compile("\\d+(\\s?)");
        Matcher matcher_double_numbers = pattern_double_numbers.matcher(string);

        int count = 0;
        while (matcher_double_numbers.find()){
            count++;
        }
        return count;
    }

    private String trimString(String string) {
        string = string.replaceAll("[-,;]", "");
        return string.trim();
    }
}
