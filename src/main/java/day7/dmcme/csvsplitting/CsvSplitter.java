package day7.dmcme.csvsplitting;

import java.io.File;
import java.util.Arrays;

public class CsvSplitter {

    public static void main(String[] args) {

        FileProcessor fileProcessor = new FileProcessor("src\\main\\java\\day7\\dmcme\\csvsplitting\\Scores.csv");
        int fileLength = fileProcessor.getLengthOfFile();

        for (int i = 0; i < fileLength; i++) {
            String [] arrayContents = fileProcessor.getValuesAtLocation(i);
            printWinner(arrayContents);

        }
    }

    public static void printWinner(String [] inputString) {

        String winner;
        int teamOneScore = Integer.parseInt(inputString[1]);
        int teamTwoScore = Integer.parseInt(inputString[3]);


        if (teamOneScore == teamTwoScore) {
            winner = "Draw";
        }
        else {
            if (teamOneScore > teamTwoScore) {
                winner = inputString[0];
            }
            else {
                winner = inputString[2];
            }
        }

        System.out.println(inputString[0] + " " + teamOneScore + " : " + inputString[2] + " "
                + teamTwoScore + " Winner: "+ winner);
    }



}
