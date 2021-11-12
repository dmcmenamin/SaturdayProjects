package day4.dmcme.mastermind;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MasterMind {


    final static int EASY_ARRAY_SIZE = 3;
    final static int EASY_NO_OF_ATTEMPTS = 18;
    final static int EASY_MAXIMUM_DIGIT = 5;

    final static int NORMAL_ARRAY_SIZE = 4;
    final static int NORMAL_NO_OF_ATTEMPTS = 10;
    final static int NORMAL_MAXIMUM_DIGIT = 6;

    final static int HARD_ARRAY_SIZE = 5;
    final static int HARD_NO_OF_ATTEMPTS = 10;
    final static int HARD_MAXIMUM_DIGIT = 8;

    /**
     * Asks yser to select value 1 - 3 to identify the challenge level
     * Validates, such that user can only select values 1 - 3
     * Returns the difficulty level selected
     * 1 - returns 'Easy'
     * 2 - returns 'Normal'
     * 3 - returns 'Hard'
     * @param sc - Scanner Object - used for User input
     * @return - String for difficulty level selected
     */
    public static String getChallengeLevel(Scanner sc) {
        int userInput;
        String returnChallengeLevel = "";
        boolean validEntry = false;

        // get User Input and keep looping user enters a value between 1 - 3
        do {
            System.out.println("Welcome to Code Cracker, please choose a difficulty (1-3):");
            System.out.println("1) Easy");
            System.out.println("2) Normal");
            System.out.println("3) Hard");
            userInput = sc.nextInt();

            if (userInput < 1 || userInput > 3){
                System.out.println("Invalid value - please retry");
            } //end if
            else {
                validEntry = true;
            } // end else
        } // end do
        while (! validEntry);

        switch (userInput) {
            case 1 -> returnChallengeLevel = "Easy";
            case 2 -> returnChallengeLevel = "Normal";
            case 3 -> returnChallengeLevel = "Hard";
        } //end Switch

        sc.nextLine();
        return returnChallengeLevel;
    } // end getChallenge Level

    /**
     * Takes in the difficulty and depending on the value supplied will create an array
     * 1) Easy - You have 15 guesses to crack a 3 digit code. Possible digits are 1-5.
     * 2) Normal - You have 10 guesses to crack a 4 digit code. Possible digits are 1-6.
     * 3) Hard - You have 10 guesses to crack a 5 digit code. Possible digits are 1-8.
     * @param difficulty - String
     * @return - an Integer Array
     */
    public static int[] setupCode(String difficulty) {

        int [] returnArray;
        if (difficulty.equals("Easy")){
            returnArray = codeGenerator(EASY_ARRAY_SIZE, EASY_MAXIMUM_DIGIT);
        } // end if
        else {
            if (difficulty.equals("Normal")) {
                returnArray = codeGenerator(NORMAL_ARRAY_SIZE, NORMAL_MAXIMUM_DIGIT);
            } // end if
            else {
                returnArray = codeGenerator(HARD_ARRAY_SIZE, HARD_MAXIMUM_DIGIT );
            } // end else
        } // end else

        return returnArray;
    } // end setUpCode

    /**
     * A Generic Code Generator - which takes in 2 values
     * @param arraySize - Integer - to identify the size of the arrays
     * @param valueRange - Integer - the value range
     * @return - the populated Range Value
     */
    public static int[] codeGenerator(int arraySize, int valueRange){

        int [] codeArray= new int[arraySize];
        Random random = new Random();

        for (int i = 0; i < arraySize; i++) {
            codeArray[i] = random.nextInt(valueRange) + 1;
        } // end for

        return codeArray;
    }// end CodeGenerator

    /**
     * Set the maximum number expected for each difficulty
     * If Difficulty is 'Easy' - return 5
     * Difficulty is 'Normal' - return 6
     * Difficulty is 'Hard' - return 9
     * @param difficulty - String - either 'Hard', 'Normal' or 'Easy'
     * @return - Integer - returns the maximum number expected
     */
    public static int setMaximumDigit(String difficulty) {
        int range;
        if (difficulty.equals("Easy")){
            range = EASY_MAXIMUM_DIGIT;
        }
        else {
            if (difficulty.equals("Normal")) {
                range = NORMAL_MAXIMUM_DIGIT;
            }
            else
                range = HARD_MAXIMUM_DIGIT;
        }
        return range;
    }

    /**
     * Take in the Difficulty level and set up the number of attempts
     * Easy - 15 Attempts
     * Normal - 10 Attempts
     * Hard - 10 Guesses
     * @param difficulty - string
     * @return - returns the number of attempts
     */
    public static int setNumberOfAttempts(String difficulty) {

        int numberOfAttempts;

        if(difficulty.equals("Easy")) {
            numberOfAttempts = EASY_NO_OF_ATTEMPTS;

        }//end if
        else {
            if (difficulty.equals("Normal")){
                numberOfAttempts = NORMAL_NO_OF_ATTEMPTS;
            }
            else {
                numberOfAttempts = HARD_NO_OF_ATTEMPTS;
            }
        }// end else
        return numberOfAttempts;

    }// end setNumberOfAttempts

    /**
     * Gets the Users input as a String
     * Using Regex, it validates if it contains any alphabetic characters, or if the input is less
     * than the required amount
     * @param sc - Scanner used for user input
     * @param numberOfDigits - the expected length of input
     * @param highestNumber - the maximum value expected from the user
     * @return - An Int Array where each digit contains 1 value
     */
    public static int [] getUserGuess(Scanner sc, int numberOfDigits, int highestNumber) {

        String userNumber = sc.nextLine();
        int [] returnUserArray = new int[numberOfDigits];
        String regexAlphabetic = "[^0-9]+";

        Pattern alphaPattern = Pattern.compile(regexAlphabetic);

        Matcher alphaMatcher  = alphaPattern.matcher(userNumber);
        boolean containsInvalids = alphaMatcher.find();

        boolean numberTooHigh = numberIsTooHigh(userNumber, highestNumber);

        while ((userNumber.length() != numberOfDigits) || containsInvalids || numberTooHigh) {
            System.out.printf("You have need to enter a number that is %d long with numbers in the range 1 - %d %n",
                    numberOfDigits, highestNumber);
            System.out.println("Please re-enter: ");
            userNumber = sc.nextLine();

            alphaMatcher = alphaPattern.matcher(userNumber);
            containsInvalids = alphaMatcher.find();
            numberTooHigh = numberIsTooHigh(userNumber, highestNumber);

        }// end while

        for (int i = 0; i < userNumber.length(); i++) {
            returnUserArray[i] = Character.getNumericValue(userNumber.charAt(i));
        }// end for
        return returnUserArray;
    }// end getUserGuess

    /**
     * Boolean check to see if the user has entered a number higher than the maximum value
     * @param userInput- String user Inputs
     * @param maxNumber - Maximum Number allowed
     * @return - boolean - true if a value higher than max was entered
     */
    public static boolean numberIsTooHigh(String userInput, int maxNumber) {
        boolean returnBool = false;
        for (int i = 0; i < userInput.length(); i++) {
            if (Character.getNumericValue(userInput.charAt(i))> maxNumber) {
                returnBool = true;
            }// end if
        }// end for
        return returnBool;
    }//

    /**
     * Check 2 int arrays and return true if it is an exact match
     * Otherwise false
     * @param computerArray - int array - Computer generated array
     * @param userArray - int array - user inputted array
     * @return - Boolean - true or false depending on if it is a match
     */
    public static boolean checkForFullMatch(int [] computerArray, int [] userArray) {
        return Arrays.equals(computerArray, userArray);

    }

    /**
     * Performs a check for matches, first checking if digit for exact position
     * Then checking if digit occurs, but not in current position
     * @param codedValue - System generated value
     * @param userGuess - user's current guess
     * @return - an Array that consists of 4 values
     *          Value 1 - Users Current Guess
     *          Value 2 - Exact Matches
     *          Value 3 - Partial Matches
     *          Value 4 - No Matches
     */
    public static int[] checkForMatches(int[] codedValue, int[] userGuess) {
        int [] returnArray = new int[4];
        int exactPositionalMatch = 0;
        int containsMatch = 0;
        int noMatch = userGuess.length;

        int multiplier = 1;

        for (int i = 0; i < userGuess.length; i++) {
            if(userGuess[i] == codedValue[i]) {
                exactPositionalMatch += 1;
                noMatch --;
            }
            else {
                for (int j: codedValue) {
                    if (userGuess[i] == j) {
                        containsMatch++;
                        noMatch --;
                        break;
                    }// end id
                }// end for
            }// end else
        }// end for

        /*
        converts an array into an int
        by starting at the end of the string and then looping through each value
        multiplying it by (10 to the power of index) e.g.
        10**1, = 10
        10**2 = 100
        and adding that to the existing value
         */
        for (int i = userGuess.length-1; i >= 0 ; i--) {
            returnArray[0] += userGuess[i] * multiplier;
            multiplier = (int) Math.pow(10, String.valueOf((returnArray[0])).length());
        } //end for

        returnArray[1] = exactPositionalMatch;
        returnArray[2] = containsMatch;
        returnArray[3] = noMatch;

        return returnArray;
    }// end checkForMatches

    /**
     * Add an integer array to a 2d Array
     * @param currentPosition - current position in 2D array
     * @param table - Result table that we are adding a row to
     * @param currentRow - Row to be added
     */
    public static void addToCurrentTable(int currentPosition, int[][] table, int[] currentRow) {

        //end for
        System.arraycopy(currentRow, 0, table[currentPosition], 0, table[currentPosition].length);

    }// end addToCurrentTable

    /**
     * A Void Array that prints out a header and then loops through the display Table
     * It provides the users Guess and then also a match to show the number of
     * exact matches, partial matches and no matches
     * @param displayTable - The current result table
     */
    public static void displayTable(int[][] displayTable, int currentDistance) {
        System.out.printf("Turn %5s  User Guess %8s Exact Match %7s  Partial Match %8s No Match%n", " ", " "," "," ");
        for (int outerLoop = 0; outerLoop <= currentDistance; outerLoop++) {

            System.out.printf("%d", outerLoop+1);
            for (int innerLoop = 0; innerLoop < displayTable[outerLoop].length; innerLoop++) {
                System.out.printf("%10s %d %8s", " ", displayTable[outerLoop][innerLoop], " ");
            }// end inner forloop

            System.out.println();
        }// end outer for loop
    }// end display table

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String challengeLevel = getChallengeLevel(scanner);
//        System.out.println(challengeLevel);
        int [] codedValue = setupCode(challengeLevel);
        codedValue = new int[] {1,3,1};
//        System.out.println(Arrays.toString(codedValue));

        int numberOfAttempts = setNumberOfAttempts(challengeLevel);
        int maximumDigit = setMaximumDigit(challengeLevel);

        int [] [] resultTable = new int [numberOfAttempts] [4];

        System.out.printf("You have selected %s. You have %d Attempts to select a %d digit code. Possible digits are 1 - %d %n",
                challengeLevel, numberOfAttempts, codedValue.length, maximumDigit);

        for (int i = 0; i < numberOfAttempts; i++) {
            System.out.printf("Turn %d - Enter your guess (%d numbers from 1-%d ): %n", i+1, codedValue.length, maximumDigit);
            int [] userGuess = getUserGuess(scanner, codedValue.length, maximumDigit);
//            System.out.println(Arrays.toString(userGuess));

            if (checkForFullMatch(codedValue, userGuess)) {
                System.out.printf("Congratulations you got a perfect match in %d turns", i+1);
                break;
            }// end if

            int [] currentResult = checkForMatches(codedValue, userGuess);
            addToCurrentTable(i, resultTable, currentResult);
            displayTable(resultTable, i);
        } // end for

        System.out.println("The correct code was: " + Arrays.toString(codedValue));
        scanner.close();
    }// end main

}
