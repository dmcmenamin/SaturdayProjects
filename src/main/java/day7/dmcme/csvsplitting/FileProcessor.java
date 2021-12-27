package day7.dmcme.csvsplitting;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileProcessor {

    private String[][] arrayString;
    private String absoluteFileLocation;
    private int numberOfLinesInFile;

    public FileProcessor(String absoluteFileLocation) {

        this.arrayString = readAndParseFile(absoluteFileLocation);
    }


    private String[][] readAndParseFile(String absoluteFileLocation) {
        String [] [] returnArray = new String[0][];
        try {

            Path file = Paths.get(absoluteFileLocation);
            FileReader fileReader = new FileReader(String.valueOf(file));
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            this.numberOfLinesInFile = (int) Files.lines(file).count();

            returnArray = new String[this.numberOfLinesInFile][4];

            for (int i = 0; i < numberOfLinesInFile; i++) {
                String[] nextLine = bufferedReader.readLine().split(",");
                for (int j = 0; j < nextLine.length; j++) {
                    returnArray[i][j] = nextLine[j];
                }
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("File Not Found");
            fileNotFoundException.getStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return returnArray;
    }

    public int getLengthOfFile() {
        return this.numberOfLinesInFile;
    }

    public String getFileLocation() {
        return this.absoluteFileLocation;
    }

    public String[] getValuesAtLocation(int outerIndex) {
        String[] returnString = new String[0];

        if (outerIndex > this.numberOfLinesInFile) {
            System.out.println("Invalid value");
        } else {
            returnString = this.arrayString[outerIndex];
        }
        return returnString;
    }
}