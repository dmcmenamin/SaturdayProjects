package day5.dmcme.highestnumberin2darray;

import java.util.Arrays;

public class HighestNumberIn2DArray {

    public static void main(String[] args) {

        int [][] arrayOfNumbers = new int[][] { {-100,2, 50}, {2, 4, 5}, {5, 17, 30} };

        int [] highestNumberArray = highestNumberIn2DArray(arrayOfNumbers);

        System.out.println("The array of largest Numbers is " + Arrays.toString(highestNumberArray));

        int overallHighestNumber = highestNumberInAnArray(highestNumberArray);
        System.out.println("The highest number is " + overallHighestNumber);

    }

    /**
     * Take in an Array, Sort it and return the highest value i.e. the last value
     * @param inputArray Array
     * @return Highest Value
     */
    public static int highestNumberInAnArray (int [] inputArray) {

        //Sort an Array
        Arrays.sort(inputArray);

        // Return last value in sorted array
        return inputArray[inputArray.length-1];
    }

    /**
     * Take in a 2D Array - iterate through each individual Array
     * And populate the highest value in an Array
     * Sort this array and return the highest value
     * @param input2DArray - Int Array
     * @return highest value
     */
    public static int [] highestNumberIn2DArray (int [] [] input2DArray) {

        int [] arrayOfHighestNumbers = new int[input2DArray.length];

        for (int i = 0; i < input2DArray.length; i++) {

            arrayOfHighestNumbers[i] = highestNumberInAnArray(input2DArray[i]);
        }

        return arrayOfHighestNumbers;
    }

}
