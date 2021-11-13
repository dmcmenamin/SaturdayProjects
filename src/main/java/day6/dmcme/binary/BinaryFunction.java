package day6.dmcme.binary;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class BinaryFunction {

    public static void main(String[] args) {

        String sixtyFourBitBinaryNumber = generateRandom64BitBinary();

        HashMap<Integer, HashMap<String, Integer>> binaryStringTable = splitBinaryStringInToHashMap(sixtyFourBitBinaryNumber);
        boolean continueLoop = true;
        Scanner scanner = new Scanner(System.in);

        do {
            try {
                displayMenu();
                int userChoice = getMenuSelection(scanner);

                switch (userChoice) {
                    case 1:
                        displayAllValues(binaryStringTable);
                        break;
                    case 2:
                        int firstInt = getTableSelection(scanner);
                        int secondInt = getTableSelection(scanner);
                        String firstValue = extractStringFromHashMap(firstInt, binaryStringTable);
                        String secondValue = extractStringFromHashMap(secondInt, binaryStringTable);
                        String combinedStringResult = addTwoBinaries(firstValue, secondValue);
                        displayResult(firstValue, secondValue, combinedStringResult);
                        break;
                    case 3:
                        String firstBinaryString = getUserBinary("First", scanner);
                        String secondBinaryString = getUserBinary("Second", scanner);

                        combinedStringResult = addTwoBinaries(firstBinaryString, secondBinaryString);
                        displayResult(firstBinaryString, secondBinaryString, combinedStringResult);
                        break;
                    case 4:
                        firstInt = getTableSelection(scanner);
                        secondInt = getTableSelection(scanner);

                        firstValue = extractStringFromHashMap(firstInt, binaryStringTable);
                        secondValue = extractStringFromHashMap(secondInt, binaryStringTable);

                        combinedStringResult = subtractTwoBinaries(firstValue, secondValue);
                        displayResult(firstValue, secondValue, combinedStringResult);

                        break;
                    case 5:
                        firstBinaryString = getUserBinary("First", scanner);
                        secondBinaryString = getUserBinary("Second", scanner);

                        combinedStringResult = subtractTwoBinaries(firstBinaryString, secondBinaryString);
                        displayResult(firstBinaryString, secondBinaryString, combinedStringResult);
                        break;
                    case 6:
                        String userBinary = getUserBinary("Input", scanner);
                        displayTableHeader();
                        System.out.println(displayLine("Input", userBinary));
                        break;
                    case 7:
                        int userNumber = getDenaryNumber(scanner);
                        String binaryValue = convertIntToString(userNumber);
                        displayTableHeader();
                        System.out.println(displayLine("Input", binaryValue));
                        break;
                    case 8:
                        System.out.println("Thats all folks");
                        continueLoop = false;
                        break;
                    default:
                        System.out.println("Well now we're just broke");
                        System.out.println("So I'm exiting");
                        continueLoop = false;
                }
            }
            catch (Exception exception) {
                System.out.println("Sorry you have entered an incorrect value type");
                System.out.println("Please try again");
                scanner.nextLine();
            }
//            finally {
//                scanner.close();
//            }
        }
        while (continueLoop == true);

    }

    public static String generateRandom64BitBinary() {

        Random random = new Random();
        String tempValue = "";

        for (int i = 0; i < 64; i++) {
            tempValue += random.nextInt(2);
        }

        return tempValue;
    }

    /**
     * A Void Method to display the menu
     */
    public static void displayMenu() {

        System.out.println("Menu");
        System.out.println("1) Display all values");
        System.out.println("2) Add 2 numbers from table");
        System.out.println("3) Add 2 binary numbers (entered as binary string)");
        System.out.println("4) Subtract one number from another (from table)");
        System.out.println("5) Subtract one number from another (entered as binary string)");
        System.out.println("6) Enter binary to display as denary");
        System.out.println("7) Enter denary to display as binary");
        System.out.println("8) Exit");
        System.out.println("Please enter a choice: ");
    }

    public static int getMenuSelection(Scanner scan) {

        return scan.nextInt();
    }

    /**
     * A DRY Method - that takes in a String and converts it to a Denery Number
     * Using inbuilt Integer method
     * @param binaryString - String
     * @return A Integer representation of the String
     */
    public static int convertBinaryStringToInt(String binaryString){

        binaryString = standardizeString(binaryString);

        int decimalValue = Integer.parseInt(binaryString.substring(1,8), 2);
        if (binaryString.charAt(0) == '1'){
            decimalValue *= -1;
        }
        return decimalValue;
    }

    /**
     * A DRY Method - that takes in an Integer and converts it to a String
     * using inbuilt Integer Method
     * @param inputDecimal - Integer
     * @return - String - binary representation of the Integer
     */
    public static String convertIntToString(int inputDecimal) {

        String returnString = "";
        if(inputDecimal < 0) {
            inputDecimal *= -1;
            returnString = standardizeString(Integer.toBinaryString(inputDecimal));
            returnString = "1" + returnString.substring(1,8);
        }
        else {
            returnString = Integer.toBinaryString(inputDecimal);
        }

        return returnString;

    }

    /**
     * A Method that takes in a 64 character String
     * Splits it into 8 equal sections and stores it into a HashMap consisting of
     * Order Number : Int
     *      Binary String: String
     *      Decimal Value: Int
     * @param binaryString 64 character String
     * @return A HashMap
     */
    public static HashMap<Integer, HashMap<String, Integer>> splitBinaryStringInToHashMap(String binaryString) {

        HashMap<Integer, HashMap<String, Integer>> returnHashMap = new HashMap<>();
        for (int i = 0; i < 8; i++) {
            HashMap<String, Integer> innerHashMap= new HashMap<>();
            String splitString = binaryString.substring(i*8, (i+1)*8);
            int decimalValue = convertBinaryStringToInt(splitString);
            innerHashMap.put(splitString, decimalValue);
            returnHashMap.put(i, innerHashMap);
        }
        return returnHashMap;
    }

    /**
     * A Void Method that loops through the HashMap to Display all the values
     * @param inputHashMap - HashMap
     */
    public static void displayAllValues(HashMap<Integer, HashMap<String, Integer>> inputHashMap) {
        displayTableHeader();
//        for (int i = 0; i <inputHashMap.size(); i++) {
//            System.out.println(inputHashMap.get(i));
//        }
        for (Integer i : inputHashMap.keySet()){
            System.out.print(i+ "\t\t\t");
            for (String s: inputHashMap.get(i).keySet()) {
                System.out.print(segregateString(s));
                System.out.print(inputHashMap.get(i).values());
            }
            System.out.println();
        }
    }

    /**
     * A Void Method to display the headers
     */
    public static void displayTableHeader() {

        String header = "Number# \t+/-\t64\t32\t16\t8\t4\t2\t1\tDenery";
        System.out.println(header);

    }

    /**
     * Parse out a Binary String for Display purposes
     * @param inputString - String
     * @return - A Tab spaced String
     */
    public static String segregateString (String inputString) {

        String returnString = "";
        int sizeOfInput = inputString.length();
        for (int i = 0; i < inputString.length(); i++) {
            returnString += inputString.charAt(i) + "\t";
        }

        while (sizeOfInput < 8) {
            returnString = "0\t" + returnString;
            sizeOfInput += 1;
        }

        return returnString;
    }

    /**
     * Get Users Selection from table - based on values 0 - 7
     * @param scan Scanner Object
     * @return - int representing the value selected
     */
    public static int getTableSelection(Scanner scan) {

        boolean timeToExit = false;
        int userChoice = -1;
        do {
            try {
                System.out.println("Please select a value from the table: ");
                userChoice = scan.nextInt();
                if(userChoice >= 0 && userChoice < 8) {
                    timeToExit = true;
                }
            }
            catch (Exception exception) {
                System.out.println("That is an invalid selection");
            }

        }
        while (timeToExit == false);

        return userChoice;
    }

    /**
     * Exxtract String from Hashmap
     * @param position - Integer
     * @return - String Value of the HashMap
     */
    public static String extractStringFromHashMap(int position,
                                                    HashMap<Integer, HashMap<String, Integer>> inputHashMap) {

        return inputHashMap.get(position).keySet().toString();

    }

    /**
     * Takes in 2 Binary Numbers as Strings and returns their result as a Binary
     * @param binaryOne - String
     * @param binaryTwo - String
     * @return - Combined results of the 2, as a String
     */
    public static String addTwoBinaries(String binaryOne, String binaryTwo) {

        int numberOne = convertBinaryStringToInt(binaryOne);
        int numberTwo = convertBinaryStringToInt(binaryTwo);
        int result = numberOne + numberTwo;
        String returnString = "";

        if(result > 127 || result < - 128){
            returnString = "Error";
        }
        else {
            returnString = convertIntToString(result);
        }

        return returnString;
    }

    /**
     * A Void Method that takes in 3 Binary Strings and displays the Results in a Tabular format
     * @param firstValue - String
     * @param secondValue - String
     * @param combinedValue - String
     */
    public static void displayResult(String firstValue, String secondValue, String combinedValue) {

        displayTableHeader();
        System.out.println(displayLine("First", firstValue));
        System.out.println(displayLine("Second", secondValue));
        System.out.println(displayLine("Result", combinedValue));
    }

    /**
     * A Method that takes in a label and a Bonary String.
     * It then formats it into a tabular format using tabs
     * @param firstLabel - String - Label Name
     * @param binaryStringValue - Binary String
     * @return - A tab spaced string for display purposes
     */
    public static String displayLine(String firstLabel, String binaryStringValue) {

        String returnString = "";

        if (binaryStringValue.equals("Error")) {
            returnString = firstLabel + "\t\t Invalid. Number is bigger than Allowable size";
        }
        else {
            binaryStringValue = standardizeString(binaryStringValue);
            int binaryIntValue = convertBinaryStringToInt(binaryStringValue);
            returnString = firstLabel + "\t\t" + segregateString(binaryStringValue) + "\t" + binaryIntValue;
        }

        return returnString;
    }

    /**
     * A Method that standardizes a String - to ensure it has a size limit of 8
     * @param inputString - Input String
     * @return - Standardized String
     */
    public static String standardizeString (String inputString) {

        String returnString = "";

        if (inputString.contains("[")) {
            inputString = inputString.substring(1, inputString.length()-1);
        }

        int stringLength = inputString.length();
        while (stringLength < 8) {
            returnString += "0";
            stringLength += 1;
        }

        while (inputString.length() > 8) {
            inputString = inputString.substring(1, inputString.length()-1);
        }

        returnString = returnString + inputString;

        return returnString;
    }

    /**
     * Get a Binary Input from the User - includes limit validation
     * @param valueNumber - Label
     * @param scan - Scanner
     * @return - A Binary String
     */
    public static String getUserBinary (String valueNumber, Scanner scan) {

        boolean exitLoop = false;
        String booleanString = "";

        do {

            try {
                System.out.println("Please enter " + valueNumber + " Boolean Number");
                booleanString = scan.nextLine();

                if(validateBoolean(booleanString)) {
                    exitLoop = true;
                }
            }
            catch (Exception exception) {
                System.out.println("That is not a valid boolean number");
                System.out.println("Please try again");
                scan.next();
            }

        }
        while (exitLoop == false);


        return booleanString;
    }

    /**
     * Validates a Provided String
     * @param inputString - Binary String
     * @return Boolean Value
     */
    public static boolean validateBoolean (String inputString) {

        return inputString.length() == 8;
    }

    /**
     * Subtract 2 Binary Strings 0 by first converting them to Denary and then subtracting
     * Finally restore them to Decimal
     * @param binaryOne - String
     * @param binaryTwo - String
     * @return - Binary String
     */
    public static String subtractTwoBinaries(String binaryOne, String binaryTwo) {

        int numberOne = convertBinaryStringToInt(binaryOne);
        int numberTwo = convertBinaryStringToInt(binaryTwo);
        int result = numberOne - numberTwo;
        String returnString = "";

        if(result > 127 || result < - 128){
            returnString = "Error";
        }
        else {
            returnString = convertIntToString(result);
        }

        return returnString;
    }

    /**
     * Get A Denary Number from the user - includes validation if value exists between -128 to 127
     * @param scan Scanner Object
     * @return - Integer
     */
    public static int getDenaryNumber(Scanner scan) {

        boolean validValue = false;
        int returnInt = 0;

        do {
            try {
                System.out.println("Please enter a Denery number in the range -128 to 127");
                returnInt = scan.nextInt();

                if (returnInt >= -128 && returnInt <= 127) {
                    validValue = true;
                }
            }
            catch (Exception ex) {
                System.out.println("Invalid Value Entered - please try again");
                scan.nextLine();
            }

        }
        while (validValue == false);

        return returnInt;
    }

}
