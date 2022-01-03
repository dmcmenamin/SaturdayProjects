package day7.dmcme.oopcsvsplitting;

import java.io.*;
import java.util.ArrayList;

public class SongStats {

    public static void main(String[] args) {

        String line;

        try {

            File file = new File("src\\main\\java\\day7\\dmcme\\oopcsvsplitting\\songlist.csv");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            ArrayList <Song> listOfSongs = new ArrayList<>();

            line = bufferedReader.readLine();
            while (line != null) {
                String [] splitSongs = line.split(",");
                Song newSong = new Song(splitSongs[0], splitSongs[1], splitSongs[2]);
                listOfSongs.add(newSong);

                line = bufferedReader.readLine();
            }

            for (Song song: listOfSongs) {
                System.out.println(song.toString());
            }

            bufferedReader.close();
            fileReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
