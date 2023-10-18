import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class GetRandomMon {
    //Method to look at file and print line
    //TODO: put docs notes above method or class name - this is the convention in the industry
    public void getRandMon() {
        String pickedRandMon = new File("Pokemon.txt").getAbsolutePath();
        String randMon = findRandMon(pickedRandMon);
        System.out.println(randMon);
    }

    //Method reads all lines in file and picks a random line to show
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
