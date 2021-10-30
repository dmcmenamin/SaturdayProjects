package day3.dmcme.reversetriangle;

//Challenge idea:
//    Standard: Take square me up and try to print a triangle instead
//    Hard: Print two triangles, base to base like
//         x
//        x x
//       x   x
//      x     x
//     x x x x x
//     x x x x x
//      x     x
//       x   x
//        x x
//         x

import java.util.Scanner;

public class ReverseTriangle {


    public static void main(String[] args) {

        int triangleSize = getSize();

        String[] displayableArray = populateArray(triangleSize);

        printArrayForwards(displayableArray);
        printArrayBackwards(displayableArray);

    }

    /***
     * Using the Scanner class - request the user to input the size of a triangle they'd like.
     * Number entered must be odd, in order to create an equilateral triangle
     * @return - int
     */
    public static int getSize(){
        Scanner scanner = new Scanner(System.in);
        boolean equilateralTriangle = false;
        int userInput = 0;

        while (equilateralTriangle == false) {
            System.out.printf("Please identify the size of an equilateral  triangle: ");
            userInput = scanner.nextInt();
            scanner.nextLine();
            if (userInput % 2 == 0) {
                System.out.println("Sorry Triangle must be equilateral (odd number)");
            } else {
                equilateralTriangle = true;
            }
        }
        scanner.close();
        return userInput;
    } // end getSize


    /**
     * Populates an array based on a required Triangle Size -
     * Creates a line which is twice the triangle size + 1, to allow for spacing
     * Initially set to blanks, it then loops through the array starting on the 2nd line - index 1
     * It uses this index to populate a '*' on the +/- index side of the middle.
     * Such that if the triangle side is 5 - the middle will be 3.
     * So index 1 will populate a star at position 2 & 4 (middle +/- (index value:1))
     * @param arrayLength - the required size od the triangle
     * @return - a String Array with the values populated
     */
    public static String[] populateArray (int arrayLength) {

        String [] triangleArray = new String[arrayLength];

        // create a new blank line, populate the middle character with a *
        String line = " ".repeat((arrayLength*2) + 1) ;
        line = line.substring(0, arrayLength-1) + "* ";
        triangleArray[0] = line;

        // start counter at 1 - as first line will only have 1 star in the middle
        for (int counterLoop = 1; counterLoop < arrayLength-1; counterLoop++) {

            // first populate blank line of spaces
            line = " ".repeat(arrayLength*2);

            // find where stars need to be printed based on offsets
            int sideOne = arrayLength - counterLoop;
            int sideTwo = arrayLength + counterLoop;

            // populate line
            line = line.substring(0,sideOne-1) + "* "
                    + line.substring(sideOne + 1, sideTwo-1) + "* ";

            // insert populated line into array
            triangleArray[counterLoop] = line;

        }// end counterLoop

        // populate the last line with *'s
        triangleArray[arrayLength-1] = "* ".repeat(arrayLength);
        return triangleArray;

    }// end populateArray

    /**
     * A Void Array that takes in an array and prints it forwards
     * @param printArray - String Array to be printed
     */
    public static void printArrayForwards(String [] printArray) {
        for (int i = 0; i < printArray.length; i++) {
            System.out.println(printArray[i]);

        }// end for
    }// end printArrayForward

    /**
     * A Void Array that takes in an array and prints it backwards
     * @param printArray - String to be printed backwards
     */
    public static void printArrayBackwards(String[] printArray) {
        for (int i = printArray.length-1; i >= 0 ; i--) {
            System.out.println(printArray[i]);

        }
    }


}
