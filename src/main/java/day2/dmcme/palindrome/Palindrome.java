package day2.dmcme.palindrome;

import java.util.Scanner;

public class Palindrome {


    public static void main(String[] args) {

        String potentialPalindrome = getUserInput();

        if (palindromeChecker(potentialPalindrome)) {
            System.out.printf("Congratulations %s is a palindrome %n", potentialPalindrome);
        }
        else {
            System.out.printf("Sorry %s is not a palindrome %n", potentialPalindrome);
        }

    }

    /**
     * Get User input
     * @return String to be checked
     */
    public static String getUserInput() {
        System.out.printf("Please provide the string you want to check: ");
        Scanner scanner = new Scanner(System.in);

        String userString = scanner.nextLine();
        scanner.close();
        return userString;
    }

    /**
     * Palindrome Checker - loops through each character in a String and checks if the String is a palindrome
     * @param stringToBeChecked - String
     * @return boolean
     */
    public static boolean palindromeChecker(String stringToBeChecked) {
        boolean validPalindrome = true;

        // set String length as length - 1 to allow for index 0 offset
        int stringLength = stringToBeChecked.length() - 1;

        //loop through each character in the string, and check if their lower case
        //value is the same as that value offset from the end ( - 1; to allow for 0 index)
        //i.e. Character 0 is the same as length - 1
        // Character 1 is the same as length -2
        for (int i = 0; i < stringLength; i++) {
            if (stringToBeChecked.toLowerCase().charAt(i) !=
                    stringToBeChecked.toLowerCase().charAt(stringLength - i)){
                validPalindrome = false;
                break;
            }
        }
        return validPalindrome;

    }// end PalindromeChecker


}
