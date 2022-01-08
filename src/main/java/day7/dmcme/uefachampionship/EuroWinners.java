package day7.dmcme.uefachampionship;

import java.io.*;
import java.util.ArrayList;

public class EuroWinners {

    public static void main(String[] args) {

        ArrayList<String> listOfWinners = new ArrayList<>();

        try {
            File file = new File("src\\main\\java\\day7\\dmcme\\uefachampionship\\ECWinners.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();
            while (line != null){
                if(!checkIfDuplicate(line, listOfWinners)) {
                    listOfWinners.add(line);
                }
                line = bufferedReader.readLine();
            }

            for (String winners: listOfWinners) {
                System.out.println(winners);
            }

            bufferedReader.close();
            fileReader.close();

        }
        catch (FileNotFoundException fileNotFoundException){
            fileNotFoundException.getStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static boolean checkIfDuplicate (String inputLine, ArrayList inputArrayList){
        return inputArrayList.contains(inputLine);
    }
}
