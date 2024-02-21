import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

/** Class to get a random Pokémon from a line in the file*/
public class GetRandomMon {
    /** Method to look at a file and print lines*/
    public void getRandMon() {
        String pickedRandMon = new File("Pokemon.txt").getAbsolutePath();
        String randMon = findRandMon(pickedRandMon);
        System.out.println(randMon);
    }

    /** Method to read all lines in a file and pick a random one*/
    public String findRandMon(String pickedRandMon) {
        List<String> randDex;
        try {
            randDex = Files.readAllLines(Paths.get(pickedRandMon));
        } catch (IOException e) {
            e.printStackTrace();
            SurprisedPikachuImage error = new SurprisedPikachuImage();
            error.surprisedPikachu();
            return null;
        }
        Random randomLine = new Random();
        return randDex.get(randomLine.nextInt(randDex.size()));
    }

}
