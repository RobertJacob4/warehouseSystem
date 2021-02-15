package sample;

/**
 * class containing validation methods for parameters of objects and nodes.
 */

public class Utilities {

    static boolean onlyContainsNumbers(String text) {
        return (text.matches("[0-9]+"));
    }

    static String max100Chars(String string) {
        return (string.length() <= 100) ? string : string.substring(0, 100);
    }

    static String validAisleID(String aisleID) {
        String validAisleID = "INVALID";
        if (aisleID.length() == 2 && onlyContainsNumbers(aisleID.substring(1, 1))) {
            validAisleID = aisleID.charAt(1) + max1Chars(aisleID.substring(0, 0));
        }
        return validAisleID;
    }

    static String max1Chars(String string) {
        return (string.length() <= 1) ? string : string.substring(0, 1);
    }

    static String validShelfNum(String shelfNum) {
        String validShelfNum = "INVALID";
        if (shelfNum.length() == 2 && onlyContainsNumbers(shelfNum)) {
            validShelfNum = shelfNum;
        }
        return validShelfNum;
    }

    static boolean nonNegative(int number) {
        return (number >= 0);
    }

    static int validNonNegative(int number) {
        if (nonNegative(number)) {
            return number;
        }
        return 0;
    }

}

