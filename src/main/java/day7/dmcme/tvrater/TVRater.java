package day7.dmcme.tvrater;

import java.io.*;
import java.util.ArrayList;

public class TVRater {


    public static void main(String[] args) {

        ArrayList <TVProgram> tvListings = new ArrayList<>();
        ArrayList <TVProgram> outputTvListings = new ArrayList<>();
        String [] header = new String[4];
        String line;

        try {

            File file = new File("src\\main\\java\\day7\\dmcme\\tvrater\\TVProgrammes.csv");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            File outputFile = new File("src\\main\\java\\day7\\dmcme\\tvrater\\filterTVPrograms.csv");
            FileWriter fileWriter = new FileWriter(outputFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            line = bufferedReader.readLine();

            if (line!= null) {
                header = populateHeader(line);
                line = bufferedReader.readLine();

                while (line != null) {
                    String [] splitTV = line.split(",");
                    TVProgram tvProgram = new TVProgram(splitTV[0], splitTV[1], Integer.parseInt(splitTV[2]),
                            Double.parseDouble(splitTV[3]));
                    tvListings.add(tvProgram);
                    line = bufferedReader.readLine();
                }
            }

            for (TVProgram tvProgram: tvListings) {
                if (searchByBroadcaster("BBC", tvProgram)) {
                    outputTvListings.add(tvProgram);
                }
            }

            bufferedWriter.write(csvBuilder(header));

            for (TVProgram outputTvListing : outputTvListings) {
                bufferedWriter.newLine();
                bufferedWriter.write(csvBuilder(outputTvListing));
            }

            bufferedReader.close();
            fileReader.close();

            bufferedWriter.close();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String [] populateHeader(String inputLine) {
        return inputLine.split(",");
    }

    public static boolean searchByBroadcaster(String broadcaster, TVProgram tvProgram) {
        return tvProgram.getBroadcaster().equalsIgnoreCase(broadcaster);
    }

    public static String csvBuilder(String [] inputArray) {
        StringBuilder returnString = new StringBuilder();

        for (String value: inputArray) {
            returnString.append(value).append(',');
        }
        return returnString.substring(0, returnString.length()-1);
    }

    public static String csvBuilder(TVProgram tvProgram){

        return tvProgram.getProgrammeName() + "," + tvProgram.getBroadcaster() + "," +
                tvProgram.getRating() + "," + tvProgram.getAverageAudience();
    }

}
